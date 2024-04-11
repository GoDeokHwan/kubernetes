package com.example.kubernetes.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("ku_board_post")
public class KuBoardPost {
    @Id
    private Long id;

    @Column("board_id")
    private Long boardId;

    private String title;

    private String content;

    private LocalDateTime created;

    private LocalDateTime updated;
}
