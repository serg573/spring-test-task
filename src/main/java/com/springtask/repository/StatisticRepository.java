package com.springtask.repository;

import com.springtask.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Sergey Vasiliev on 9/7/17.
 */

public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    @Transactional
    List<Statistic> removeByDateLessThanEqual(Date date);

}
