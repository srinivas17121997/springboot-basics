package org.example.Repository;

import org.example.model.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class UserAndActivityRepository {

    private List<String> users;

    private HashMap<String, List<Activity>> userActivityMapping;

    public UserAndActivityRepository() {
        this.users = new ArrayList<>();
        this.userActivityMapping = new HashMap<>();
    }

    public List<String> getUsers() {
        return users;
    }

    public void addUser(String user){
        users.add(user);
    }

    public HashMap<String, List<Activity>> getUserActivityMapping() {
        return userActivityMapping;
    }

    public void addUserActivity(Activity activity) {
        String user=activity.getUserId();

        if(userActivityMapping.containsKey(user)){
            userActivityMapping.get(user).add(activity);
        }else {
            List<Activity> activiteList= new ArrayList<>();
            activiteList.add(activity);
            userActivityMapping.put(user, activiteList);
        }
    }
}
