package com.springboot.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
   public boolean  addSillyAccount() {
        System.out.println(getClass() +": Doing my DB work: Adding a Membership account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() +": I'm going to sleep now...");

    }


}
