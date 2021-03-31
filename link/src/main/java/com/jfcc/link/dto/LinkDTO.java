package com.jfcc.link.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDTO {

    private Integer linkID;
    private String url;
    private Integer redirectCount;
    private String password;
    private boolean isValid;

    public LinkDTO(Integer linkID, String url, Integer redirectCount, String password) {
        this.linkID = linkID;
        this.url = url;
        this.redirectCount = redirectCount;
        this.password = password;
        this.isValid = true;
    }
}
