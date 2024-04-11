package com.example.kubernetes.model.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Table("ku_board")
public class KuBoard {
    @Id
    private Long id;
    private String title;
    private String content;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime updated;

    public static KuBoard of(String title, String content) {
        KuBoard instance = new KuBoard();
        instance.title = title;
        instance.content = content;
        return instance;
    }
}
