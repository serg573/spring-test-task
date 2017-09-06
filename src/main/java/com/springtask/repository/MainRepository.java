package com.springtask.repository;

import com.springtask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergey Vasiliev on 9/5/17.
 */

@Repository
public interface MainRepository extends JpaRepository<User, Long> {
}
