package com.nemo.registartion.repository;

import com.nemo.registartion.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
