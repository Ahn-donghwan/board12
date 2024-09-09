package com.sparta.round12.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class BoardResponse {

    private final Long id;
    private final String boardTitle;
    private final String boardContent;

}
