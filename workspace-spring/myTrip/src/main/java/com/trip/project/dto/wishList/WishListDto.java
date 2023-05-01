package com.trip.project.dto.wishList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishListDto {

	private long wishId;
	private int contentId;
	private Long userId;
}