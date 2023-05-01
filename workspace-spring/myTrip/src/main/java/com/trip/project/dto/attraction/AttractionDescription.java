package com.trip.project.dto.attraction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDescription {
	private int contentId;
	private String homePage;
	private String overview;
	private String telname;
}
