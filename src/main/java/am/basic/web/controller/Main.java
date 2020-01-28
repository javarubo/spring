package am.basic.web.controller;

import am.basic.web.model.User;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap();
        stringMap.put("username","Ruben999");
        stringMap.put("name","Ruben");
        stringMap.put("age","Ruben999");
        stringMap.put("code","Ruben999");
        stringMap.put("password","Ruben999");

        String username=stringMap.get("username");


        User user=new User();
        user.setName(stringMap.get("name"));



    }
}
