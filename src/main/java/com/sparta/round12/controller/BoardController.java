package com.sparta.round12.controller;

import com.sparta.round12.dto.BoardRequest;
import com.sparta.round12.dto.BoardResponse;
import com.sparta.round12.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/boards")
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public BoardResponse saveBoard(@RequestBody BoardRequest boardRequest){
        return boardService.saveBoard(boardRequest);
    }


}
