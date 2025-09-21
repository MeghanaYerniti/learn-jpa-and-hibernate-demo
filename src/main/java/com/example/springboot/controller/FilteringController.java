package com.example.springboot.controller;

import com.example.springboot.entity.FilteringBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue filteringDynamic() {
        FilteringBean filteringBean = new FilteringBean("Maya", "M@123", "Vzm");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "city");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
        // @JsonFilter("SomeBeanFilter") => specify at bean
    }

    // list of bean
    @GetMapping("/filtering-list")
    public List<FilteringBean> filteringList() {
        return Arrays.asList(new FilteringBean("Maya", "M@123", "Vizag"),
                new FilteringBean("Abhi", "A@123", "Vzm"));
    }
}
