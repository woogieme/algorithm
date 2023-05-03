package com.trip.project.dto.attraction;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttractionRepository {

	RouteDistanceDto isRoute(Integer point);

}
