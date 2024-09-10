package com.sparta.round12.service;

import com.sparta.round12.dto.BoardRequest;
import com.sparta.round12.dto.BoardResponse;
import com.sparta.round12.entity.Board;
import com.sparta.round12.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {

    // 주입
    private final BoardRepository boardRepository;

    private Board findBoardById(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("ERROR! 해당 게시글을 찾을 수 없습니다."));
    }

    @Transactional
    public BoardResponse saveBoard(BoardRequest boardRequest) {
        // newBoard 에 request Title, Content 저장
        Board newBoard = new Board(boardRequest.getBoardTitle(), boardRequest.getBoardContent());

        // newBoard 를 repository 에 저장하고, saveBoard 에도 저장
        Board saveBoard = boardRepository.save(newBoard);

        // Id, Title, Contents 를 Response
        return new BoardResponse(saveBoard.getId(), saveBoard.getBoardTitle(), saveBoard.getBoardContent(),
                saveBoard.getCreatedAt(), saveBoard.getModifiedAt());
    }


    public BoardResponse getDetailBoard(Long boardId) {
        Board board = findBoardById(boardId);

        return new BoardResponse( board.getId(), board.getBoardTitle(), board.getBoardContent(),
                                board.getCreatedAt(), board.getModifiedAt());
    }

    @Transactional
    public BoardResponse updateBoard(Long boardId, BoardRequest boardRequest) {
        Board board = findBoardById(boardId);

        board.updateBoard(boardRequest.getBoardTitle(), boardRequest.getBoardContent());

        return new BoardResponse(board.getId(), board.getBoardTitle(), board.getBoardContent(),
                            board.getCreatedAt(), board.getModifiedAt());
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        // Id로 해당 게시글을 찾는다.
        Board board = findBoardById(boardId);

        // 해당 게시글을 삭제
        boardRepository.deleteById(boardId);
    }
}
