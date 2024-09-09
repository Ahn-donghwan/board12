package com.sparta.round12.service;

import com.sparta.round12.dto.BoardRequest;
import com.sparta.round12.dto.BoardResponse;
import com.sparta.round12.entity.Board;
import com.sparta.round12.repository.BoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {

    // 주입
    private final BoardRepository boardRepository;

    @Transactional
    public BoardResponse saveBoard(BoardRequest boardRequest) {
        // newBoard 에 request Title, Content 저장
        Board newBoard = new Board(boardRequest.getBoardTitle(), boardRequest.getBoardContent());

        // newBoard 를 repository 에 저장하고, saveBoard 에도 저장
        Board saveBoard = boardRepository.save(newBoard);

        // Id, Title, Contents 를 Response
        return new BoardResponse(saveBoard.getId(), saveBoard.getBoardTitle(), saveBoard.getBoardContents());
    }


}
