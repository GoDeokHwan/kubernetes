package com.example.kubernetes.domain.controller.request;

import lombok.Getter;

@Getter
public class BoardRequest {
    private String title;
    private String content;
}
