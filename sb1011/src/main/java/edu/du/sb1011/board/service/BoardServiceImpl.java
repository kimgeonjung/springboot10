package edu.du.sb1011.board.service;

import edu.du.sb1011.board.dto.BoardDto;
import edu.du.sb1011.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() {
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(BoardDto board) {
		boardMapper.insertBoard(board);
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx){
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		boardMapper.updateHitCount(boardIdx);
		return board;
	}
	
	@Override
	public void updateBoard(BoardDto board) {
		boardMapper.updateBoard(board);
	}

	@Override
	public void deleteBoard(int boardIdx) {
		boardMapper.deleteBoard(boardIdx);
	}
}	

