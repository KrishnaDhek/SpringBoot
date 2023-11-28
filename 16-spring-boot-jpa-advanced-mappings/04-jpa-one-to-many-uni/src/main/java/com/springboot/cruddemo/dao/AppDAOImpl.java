package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Course;
import com.springboot.cruddemo.entity.Instructor;
import com.springboot.cruddemo.entity.InstructorDetail;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    //define field for entity manager

    //inject entity manager using constructor injection

    private  EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
    entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        //retrieve instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        //get courses for instructor
        List<Course> courses =tempInstructor.getCourses();


        //break association of all the courses for the instructor

        for (Course tempCourses: courses){
            tempCourses.setInstructor(null);
        }

        //delete the instructor
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return  entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        //retrieve instructor detail by id
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        //remove the associated object reference
        //break bi_directional link

        tempInstructorDetail.getInstructor().setInstructorDetail(null);



        //delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query =entityManager.createQuery(
                "from Course where instructor.id = :data",Course.class);
        query.setParameter("data", theId);

        //execute

        List<Course> courses = query.getResultList();
        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                                    "select i from Instructor i "
                                            + "JOIN FETCH i.courses "
                                            + "JOIN FETCH i.instructorDetail "
                                            + "where i.id = :data", Instructor.class);


        query.setParameter("data" , theId);

        //execute query
        Instructor instructor = query.getSingleResult();
        return instructor;

    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);

    }


    //course update
    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int theID) {
        return entityManager.find(Course.class, theID);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        //retrieve the course
       Course tempCourse= entityManager.find(Course.class, theId);

       //delete  the course
       entityManager.remove(tempCourse);

    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }


}
