package com.BasicAuthentication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BasicAuthentication.modal.User;
@Repository
public interface AppRepository  extends CrudRepository<User, Long> {

}
