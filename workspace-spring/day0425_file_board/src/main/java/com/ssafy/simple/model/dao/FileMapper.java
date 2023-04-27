package com.ssafy.simple.model.dao;

import java.util.List;

import com.ssafy.simple.model.dto.FileDTO;

public interface FileMapper {
	int insert(FileDTO f);
	List<FileDTO> selectList(int bno); // bno 게시글에 첨부된 파일 정보 여러개 조회
}
