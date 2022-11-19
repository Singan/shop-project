package com.shopping.snack.db.service;

import com.shopping.snack.DTO.BoardDTO;
import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.repository.BoardRepository;
import com.shopping.snack.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long boardInsert(BoardDTO boardDTO, Member member){

        return boardRepository.boardInsert(boardDTO.boardCreate(member));
    }


    public List<Board> boardList(){
        return boardRepository.boardList();
    }

    public Board boardDetail(Long no){
        return boardRepository.boardDetail(no);
    }
}
