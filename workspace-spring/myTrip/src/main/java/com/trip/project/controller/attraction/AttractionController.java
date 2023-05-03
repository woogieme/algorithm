package com.trip.project.controller.attraction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trip.project.dto.attraction.RouteAttractionDto;
import com.trip.project.dto.attraction.RouteResponseDto;
import com.trip.project.service.attraction.AttractionService;

@RestController
public class AttractionController {
	
	@Autowired
	private AttractionService attractionService;
	
	@GetMapping("/attraction/route")
	public List<Integer> isRoute(@RequestParam("point") List<Integer> point){
		List<Integer> rotAttractionDtos = attractionService.isRoute(point);
		return rotAttractionDtos;
	}
}
