package com.example.learn_jpa_and_hibernate_demo.lombok;

public class LombokRunner {
    public static void main(String[] args) {
        LombokExample lombokExample = new LombokExample();
        // lombokExample.age=10; => this line pops a error since age is private
        // so to retrieve data we use setters and getters.
        lombokExample.setAge(10);
        System.out.println(lombokExample.getAge());
    }
}
