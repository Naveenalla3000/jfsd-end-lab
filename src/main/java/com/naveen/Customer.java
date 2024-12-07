package com.naveen;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String location;
}
