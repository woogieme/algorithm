package com.ssafy.simple.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileDownController {
	@GetMapping("/download")
	@ResponseBody
	public void download(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("다운받아간 사람 : "+req.getRemoteAddr());
		// 제대로 구현하려면 파일번호를 파라미터로 받아서 DB select 한 다음에 
		// 저장된 파일명과 원래 어떤 이름이었는지 조회해서 진행해야 함.
		String savedPath = "c:/SSAFY/uploaded";
		String savedName = "9876543";
		String originalName = "귀여운 가오나시.jpg";

		resp.setHeader("Content-Disposition", "attachment; filename=\""+ new String(originalName.getBytes("UTF-8"), "ISO-8859-1")+"\";");
//		resp.setHeader("Content-Disposition","attachment; filename=\"귀여운 가오나시.jpg\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");
		
		File savedFile = new File(savedPath+"/"+savedName); // c: 드라이브에 저장된 파일 오픈
		FileInputStream fis = new FileInputStream(savedFile);
		OutputStream os = resp.getOutputStream();
		FileCopyUtils.copy(fis, os);
	}
}










