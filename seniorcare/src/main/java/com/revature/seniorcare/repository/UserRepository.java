package com.revature.seniorcare.repository;

import javax.transaction.Transactional;

import com.revature.seniorcare.beans.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}
