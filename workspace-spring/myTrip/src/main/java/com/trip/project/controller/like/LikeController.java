package com.trip.project.controller.like;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trip.project.dto.like.LikeAttractionDto;
import com.trip.project.dto.like.LikeListDto;
import com.trip.project.service.like.LikeService;

@RestController
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@GetMapping("/like/{userId}/{contentId}")
	public int likeAdd(@PathVariable("userId") long userId, @PathVariable("contentId") int contentId) throws Exception {
		return likeService.likeAdd(userId,contentId);
	}
	@PostMapping("/like/list")
	public List<LikeListDto> showLikeList() throws Exception {
		return likeService.showLikeList();
	}

}
