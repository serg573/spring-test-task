package com.springtask.statistics;

import com.springtask.entity.Statistic;
import com.springtask.entity.User;
import com.springtask.repository.StatisticRepository;
import com.springtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sergey Vasiliev on 9/7/17.
 */

@Component
public class ScheduleTask {

    private final short numberOfMinutesForStatistics = 1;
    private final short numberOfMinutesForRemovingUsers = 2;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatisticRepository statisticRepository;

    @Scheduled(cron = "0 0/1 * * * ?") // fires every 1 minutes
    //@Scheduled(fixedRate = 10000) //fires every 10 seconds
    public void run() {

        saveStatistics();
        removeOldUsers();

    }

    public void saveStatistics() {

        class NationCounter {

            private HashMap nations = new HashMap<String, Integer>();

            public void addNation(String nation) {

                Integer val = (Integer) nations.get(nation);
                if (val == null) {
                    nations.put(nation, 1);
                } else {
                    nations.replace(nation, ++val);
                }
            }

            @Override
            public String toString() {
                return nations.toString();
            }
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -numberOfMinutesForStatistics);

        Statistic statistic = new Statistic();

        List<User> users = userRepository.findByDateGreaterThanEqual(calendar.getTime());

        statistic.setNumberOfUsers(users.size());
        int totalAge = 0;
        int numberOfMales = 0;
        int numberOfFemales = 0;
        NationCounter nCounter = new NationCounter();
        for (User user: users) {

            totalAge += user.getAge();
            if (user.getGender() == User.Gender.male) {
                numberOfMales++;
            } else {
                numberOfFemales++;
            }

            nCounter.addNation(user.getNationality().toString());
        }

        statistic.setAverageAge( users.size() > 0 ? totalAge / users.size() : 0);
        statistic.setNumberOfMales(numberOfMales);
        statistic.setNumberOfFemales(numberOfFemales);
        statistic.setNumberOfNationalities(nCounter.toString());
        statisticRepository.save(statistic);
    }

    private void removeOldUsers() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -numberOfMinutesForRemovingUsers);

        userRepository.removeByDateLessThanEqual(calendar.getTime());

    }

}
