package com.shopping.snack.db.repository;

import com.shopping.snack.DTO.BoardUpdateDTO;
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

    public List<Board> boardList(int pageNo){
        List<Board> boardList = em.createQuery("select b from Board b " +
                        "join fetch b.boardWriter where b.boardDisplay = true order by b.boardNo desc")
                .setFirstResult((pageNo-1)*3)
                .setMaxResults(3).
                getResultList();
        return boardList;
    }
    public Long boardTotalCount(){
        return em.createQuery("select count(b) from Board b where b.boardDisplay = true ",Long.class).getSingleResult();
    }
    @Transactional
    public Board boardDetail(Long no){
        Board board = em.find(Board.class,no);
        board.setBoardViews(board.getBoardViews()+1);
        return board;
    }
    @Transactional
    public void boardDelete(Long no){
        Board board = em.find(Board.class,no);
        board.setBoardDisplay(false);
    }

    @Transactional
    public void boardUpdate(BoardUpdateDTO boardUpdateDTO){
        Board board = em.find(Board.class,boardUpdateDTO.getNo());
        board.setBoardContent(boardUpdateDTO.getContent());
        board.setBoardTitle(boardUpdateDTO.getTitle());
    }
}
