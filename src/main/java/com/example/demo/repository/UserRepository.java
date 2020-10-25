package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 //User findByUsername(String userName) ;
	// User findUserByMobile(String mobileNumber);
	Optional<User> findByUsername(String username);


	//@Query("select u.name from User u where u.id in (:pIdList)")
	//List<String> findByIdList(@Param("pIdList") List<Long> idList);


	// TODO Auto-generated method stub
}
