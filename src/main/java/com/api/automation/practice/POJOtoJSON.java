package com.api.automation.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

// Find the difference in the variable name printed - isStudent vs student

public class POJOtoJSON {
    public void convertPOJOtoJSONUsingGSON() {
        LombokDemo lombokDemo = new LombokDemo("def", 22, false);
        lombokDemo.setName("abc");
        lombokDemo.setAge(26);
        lombokDemo.setStudent(true);

        System.out.println("Name: " + lombokDemo.getName());
        System.out.println("Age: " + lombokDemo.getAge());
        System.out.println("isStudent: " + lombokDemo.isStudent());

        System.out.println(new Gson().toJson(lombokDemo));

        /*
         * When values are passed through both constructor and set menthod, the set
         * method values takes preference and
         * the output is {"name":"abc","age":26,"isStudent":true}
         * 
         * When values are passed only via constructor, the constructor values are
         * considered and
         * the output is {"name":"def","age":22,"isStudent":false}
         * 
         * When some null values are passed via constructor, gson excludes the key while
         * forming the json and
         * the output is {"age":22,"isStudent":false}
         */

    }

    public void convertPOJOtoJSONUsingJackson() {
        LombokDemo lombokDemo = new LombokDemo("ghi", 27, true);
        lombokDemo.setName("xyz");
        lombokDemo.setAge(23);
        lombokDemo.setStudent(false);

        try {
            System.out.println("Name: " + lombokDemo.getName());
            System.out.println("Age: " + lombokDemo.getAge());
            System.out.println("isStudent: " + lombokDemo.isStudent());
            
            System.out.println(new ObjectMapper().writeValueAsString(lombokDemo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // output is {"name":"xyz","age":23,"student":false}

    /*
     * When some null values are passed via constructor, jackson includes the key
     * while forming the json and sets the value as null and
     * the output is {"name":null,"age":27,"student":true}
     */
}
