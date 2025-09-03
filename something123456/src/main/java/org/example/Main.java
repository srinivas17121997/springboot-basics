package org.example;

//Activity
//
//Time
//
//User
//users
/*
market email interaction

        2020-07-10 15:00:00.000

        User 2


        market email interaction

        2024-04-20 15:00:00.000

        User 3


        website login

        2024-03-10 15:00:00.000

        User 1


        website login

        2024-04-10 15:00:00.000

*/
import org.example.Repository.UserAndActivityRepository;
import org.example.model.Activity;
import org.example.service.UserActivityService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Activity activity1= new Activity("website login", "User1",timeformatter("2024-03-10 15:00:00.000"));
        Activity activity2= new Activity("market email interaction", "User2",timeformatter("2020-07-10 15:00:00.000"));
        Activity activity21= new Activity("market email interaction", "User3",timeformatter("2024-04-20 15:00:00.000"));
        Activity activity3= new Activity("website login", "User1",timeformatter("2024-03-10 15:00:00.000"));
        Activity activity4= new Activity("website login", "User2",timeformatter("2024-04-10 15:00:00.000"));
        Activity activity5= new Activity("Mobile app login", "User3",timeformatter("2020-07-10 15:00:00.000"));

        UserAndActivityRepository userAndActivityRepository= new UserAndActivityRepository();
        userAndActivityRepository.addUser("User1");
        userAndActivityRepository.addUser("User2");
        userAndActivityRepository.addUser("User3");
        userAndActivityRepository.addUserActivity(activity1);
        userAndActivityRepository.addUserActivity(activity2);
        userAndActivityRepository.addUserActivity(activity21);
        userAndActivityRepository.addUserActivity(activity3);
        userAndActivityRepository.addUserActivity(activity4);
        userAndActivityRepository.addUserActivity(activity5);

        UserActivityService userActivityService= new UserActivityService(userAndActivityRepository, List.of("market email interaction"),90);

        List<String> list=userActivityService.getAccountTobeDeleted(timeformatter("2024-05-01 11:00:00.000"));
        //Activity activity1= new Activity("website login", "User1",LocalDateTime.parse("2024-03-10 15:00:00.000"));


        System.out.println(list);

    }
    static LocalDateTime timeformatter(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnn");

        return LocalDateTime.parse(time, formatter);

    }
}