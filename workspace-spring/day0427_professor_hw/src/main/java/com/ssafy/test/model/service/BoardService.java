package com.ssafy.test.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.test.model.dao.BoardMapper;
import com.ssafy.test.model.dao.FileMapper;
import com.ssafy.test.model.dto.Board;
import com.ssafy.test.model.dto.FileDTO;

@Service
public class BoardService {
	
	
	@Autowired
	private BoardMapper bDao;
	
	@Autowired
	private FileMapper fDao;

	public List<Board> list() {
		// TODO Auto-generated method stub
		return bDao.selectAll();
	}

	@Transactional
	public int write(Board board, MultipartFile[] myfile) throws IllegalStateException, IOException {
		int result = bDao.insert(board);
		
		String dirPath="c:/SSAFY/uploaded";
		File savedDir = new File(dirPath);
		if(!savedDir.exists()) {
			savedDir.mkdir();
		}
		for(MultipartFile file: myfile) {
			String savedName = new Random().nextInt(1000000)+"";
			File savedFile = new File(dirPath+"/"+savedName);
			file.transferTo(savedFile);
			
			
			FileDTO dto = new FileDTO();
			
			dto.setOriginal_name(file.getOriginalFilename());
			dto.setSaved_path(savedFile.getAbsolutePath());
			dto.setBno(board.getBno());
			
			
			fDao.insert(dto);
		}
		return result;
		
	}

	public Board read(int bno) {
		// TODO Auto-generated method stub
		return bDao.read(bno);
		
	}
}
