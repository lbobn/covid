package com.covid.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.util.Date;

@Data
public class EmpIs {
    private Long id;
    private String name;
    private String sex;
    private Long phone;
    private float temp;
    private String type;
    private String place;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date begin;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date end;
    private String leaved;
    private String content;
    private String arrived;
    private String depart;
}
