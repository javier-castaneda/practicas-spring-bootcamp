package com.jfcc.link.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkMetricDTO {
    private int redirects;
    private String url;
    private boolean isValid;
}
