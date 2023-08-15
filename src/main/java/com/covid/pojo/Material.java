package com.covid.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Material {


    private Long id;
    private String name;
    private int count;
    private String type;
    private String isImp;
    private String charge;
    private Long cnum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
