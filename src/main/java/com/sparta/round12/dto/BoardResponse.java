package com.sparta.round12.dto;


import com.sparta.round12.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Getter
public class BoardResponse {

    private final Long id;
    private final  String boardTitle;
    private final String boardContent;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}
