package com.springboot.aopdemo.dao;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() +": Doing my DB work: Adding an account");
    }


}
