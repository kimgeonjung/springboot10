package edu.du.sbproject.repository;

import edu.du.sbproject.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    public List<Board> findAllByOrderByBoardIdxDesc(Pageable pageable);
}
