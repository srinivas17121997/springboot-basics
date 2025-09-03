package org.example.service;

import org.example.Repository.UserAndActivityRepository;
import org.example.model.Activity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActivityService {

    UserAndActivityRepository userAndActivityRepository;
    List<String> activitsToIgnore;
    int cutOffDays;

    public UserActivityService(UserAndActivityRepository userAndActivityRepository,List<String> activitsToIgnore,int cutOffDays) {
        this.activitsToIgnore=activitsToIgnore;
        this.cutOffDays=cutOffDays;
        this.userAndActivityRepository = userAndActivityRepository;
    }

    public List<String> getAccountTobeDeleted(final LocalDateTime timeNow){

        List<String> users=userAndActivityRepository.getUsers();
        LocalDateTime cutoffTime= timeNow.minus(90,ChronoUnit.DAYS);
        System.out.println(cutoffTime);
        HashMap<String, List<Activity>> activityMapping = userAndActivityRepository.getUserActivityMapping();

       return activityMapping.entrySet()
                .stream().filter(entries -> !validateActivities(entries.getValue(),cutoffTime))
                .map(Map.Entry::getKey)
               .filter(users::contains)
               .collect(Collectors.toList());
    }

    private  Boolean validateActivities(List<Activity> activities,final LocalDateTime cutOffTime){
       return activities.stream()
                .filter(activity -> !activitsToIgnore.contains(activity.getName()))
                .filter(activity -> activity.getLocalDateTime().isAfter(cutOffTime))
                .count()>0;
    }
}
