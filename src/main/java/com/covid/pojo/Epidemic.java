package com.covid.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Epidemic {

    private Long id;
    private String name;
    private String status;
    private String sex;
    private Long idcard;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date idate;
    private String place;
    private String depart;
    private Long phonenum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date register;

}

