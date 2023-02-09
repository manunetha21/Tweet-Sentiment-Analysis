package com.cc01.cc01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cc01.cc01.model.UserReport;

@Repository
public interface UserStatusRepository extends JpaRepository<UserReport,Integer> {
    
}
