package com.example.springboot.controller;

import com.example.springboot.entity.FilteringBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public FilteringBean filtering() {
        return new FilteringBean("Maya", "M@123", "Vzm");
    }

    // list of bean
    @GetMapping("/filtering-list")
    public List<FilteringBean> filteringList() {
        return Arrays.asList(new FilteringBean("Maya", "M@123", "Vizag"),
                new FilteringBean("Abhi", "A@123", "Vzm"));
    }
}
