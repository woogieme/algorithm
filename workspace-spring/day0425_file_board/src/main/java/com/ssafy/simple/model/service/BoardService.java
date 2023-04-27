package com.ssafy.simple.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.simple.model.dao.BoardMapper;
import com.ssafy.simple.model.dao.FileMapper;
import com.ssafy.simple.model.dto.BoardDTO;
import com.ssafy.simple.model.dto.FileDTO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper dao;
	@Autowired
	private FileMapper fdao;
	
	@Transactional
	public int write(BoardDTO board, MultipartFile[] uploadedFiles) throws SQLException, IllegalStateException, IOException {
		System.out.println("DB에 들어가기 전 boardDTO : "+board); // 글번호 : 0
		int result = dao.insert(board); 
		System.out.println("DB에 들어간 후 boardDTO : "+board); // 글번호 : 75 같이 채워짐.
		
		String dirPath = "c:/SSAFY/upload";
		File dir = new File(dirPath);
		if(!dir.exists())
			dir.mkdir();
		
		for(MultipartFile file: uploadedFiles) {
			String savedName = new Random().nextInt(1000000000)+"";
			File savedFile = new File(dirPath+"/"+savedName); //랜덤 이름으로 빈 파일생성
			file.transferTo(savedFile); // 빈 파일에 업로드된 파일 저장시키기 
			
			FileDTO dto = new FileDTO();
			dto.setOriginalName(file.getOriginalFilename()); // 원래 이름
			dto.setSavedPath(savedFile.getAbsolutePath()); // 랜덤하게 저장된 경로+이름
			dto.setBno(board.getBno()); // 지금 어느 게시글 소속인지.
			
			fdao.insert(dto); // FileMapper 한테 insert 시키기.
		}
		
		return result;
	}
	
	public BoardDTO read(int bno) throws SQLException {
		BoardDTO board = dao.selectOne(bno);
		board.setFiles(fdao.selectList(bno)); // 지금 읽으려는 게시글에 첨부된 파일정보 목록
		return board;
	}
	
	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}
	
	public List<BoardDTO> list() throws SQLException{
		return dao.selectAll();
	}
}










