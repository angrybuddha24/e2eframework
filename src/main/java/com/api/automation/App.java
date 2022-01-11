package com.api.automation;

import com.api.automation.practice.LombokDemo;

public class App {
  public static void main(String[] args) {
    LombokDemo lombokDemo = new LombokDemo();
    lombokDemo.setAge(26);
    lombokDemo.setName("abc");
    lombokDemo.setStudent(true);

    System.out.println(lombokDemo.getAge());
    System.out.println(lombokDemo.getName());
    System.out.println(lombokDemo.isStudent());
  }
}
