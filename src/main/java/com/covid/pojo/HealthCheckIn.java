package com.covid.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class HealthCheckIn {
    private Long id;
    private String name;
    private String sex;
    private Long phonenum;
    private float temp;
    private String risk;
    private String health;
    private String content;
    private String depart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
