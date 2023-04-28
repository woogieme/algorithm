package com.ssafy.test.model.dao;

import java.util.List;

import com.ssafy.test.model.dto.FileDTO;

public interface FileMapper {

	public int insert(FileDTO dto);
	
	public List<FileDTO> showFiles();
}
