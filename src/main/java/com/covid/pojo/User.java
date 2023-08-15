package com.covid.pojo;


import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String depart;
    private Boolean isAdministrator = false;

}
