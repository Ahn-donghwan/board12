package com.sparta.round12.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BoardResponse {

    private final Long id;
    private final String boardTitle;
    private final String boardContent;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public BoardResponse(Long id, String boardTitle, String boardContent,
                         LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
