package com.example.springboot.lombok;

import lombok.Data;

// @Getter
// @Setter
// @EqualsAndHashCode
// @NoArgsConstructor, @AllArgsConstructor, @RequiredArgsConstructor
// @ToString
// @Builder
// @Value => toString(), equals(), hashcode()


// Above all are given on top of the cls def
// @Data(only given in b/w public & class) => add all methods getters, setters, constructors, hashcode, equals, toString,..
public @Data class LombokExample {

    private int age;
    private String name;
    private String tech;
    // to access var outside cls we use setters and getters

}
