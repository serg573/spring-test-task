package com.springtask.repository;

import com.springtask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Sergey Vasiliev on 9/5/17.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByDateGreaterThanEqual(Date date);

    @Transactional
    void removeByDateLessThanEqual(Date date);

}