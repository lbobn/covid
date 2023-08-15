package com.covid.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class VO {
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date idate;
    private String status;
}
