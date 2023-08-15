package com.covid.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class LineVO {
    private List<String> month;
    private Map<String, List> status;
}
