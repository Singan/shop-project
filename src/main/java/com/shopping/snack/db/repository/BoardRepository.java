package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardRepository {
    private final EntityManager em;
    @Transactional
    public Long boardInsert(Board board){

         em.persist(board);
        return board.getBoardNo();
    }

    public List<Board> boardList(){
        List<Board> boardList = em.createQuery("select b from Board b where b.boardDisplay = 1").getResultList();
        return boardList;
    }

    public Board boardDetail(Long no){
        Board board = em.find(Board.class,no);
        board.setBoardViews(board.getBoardViews()+1);
        return board;
    }

    public void boardDelete(Long no){
        Board board = em.find(Board.class,no);
        board.setBoardDisplay(false);
    }
}
