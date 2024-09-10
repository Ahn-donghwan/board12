package com.sparta.round12.controller;

import com.sparta.round12.dto.BoardRequest;
import com.sparta.round12.dto.BoardResponse;
import com.sparta.round12.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/boards")
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 작성
    @PostMapping
    public ResponseEntity<BoardResponse> saveBoard(@RequestBody BoardRequest boardRequest){
        return ResponseEntity.ok(boardService.saveBoard(boardRequest));
    }

    // 단건 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponse> getDetailBoard(@PathVariable Long boardId){
        return ResponseEntity.ok(boardService.getDetailBoard(boardId));
    }

    // 게시글 수정
    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponse> updateBoard(@PathVariable Long boardId, @RequestBody BoardRequest boardRequest){
        return ResponseEntity.ok(boardService.updateBoard(boardId, boardRequest));
    }

    // 게시글 삭제
    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable Long boardId){
        boardService.deleteBoard(boardId);
    }
}
