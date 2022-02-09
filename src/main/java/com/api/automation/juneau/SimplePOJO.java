package com.api.automation.juneau;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.juneau.annotation.Beanc;

@Getter
@Setter
@NoArgsConstructor
public class SimplePOJO {

    private String name;
    private int age;
    private boolean isStudent;
    private String[] hobbies;

    @Beanc(properties = "name,age,student,hobbies")
    public SimplePOJO(String name, int age, boolean isStudent, String[] hobbies) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
        this.hobbies = hobbies;
    }
}
