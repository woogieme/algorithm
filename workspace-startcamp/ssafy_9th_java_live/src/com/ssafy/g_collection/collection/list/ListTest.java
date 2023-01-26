package com.ssafy.g_collection.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    // 문자열을 저장할 List, 구현체는 ArrayList
    List<String> friends = new LinkedList<>();

    public static void main(String[] args) {

        ListTest alt = new ListTest();
        alt.createTest();
        alt.retrieveTest();
        alt.updateTest();
        alt.deleteTest();
    }

    public void createTest() {
        // TODO: friends에 여러명의 친구를 등록해보자.
    	friends.add("BTS");
    	friends.add("손흥민");
    	friends.add("봉준호");
    	friends.add("정재욱");
    	
        // END:
        System.out.println("추가 후 내용 출력: " + friends);
    }

    public void retrieveTest() {
        // TODO: 다양한 조회 기능을 사용해보자.\
    	System.out.println("list의 size? "+ friends.size());
    	for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
			
		}for (String string : friends) {
			System.out.println(string);
		}
		System.out.println(friends.contains("봉준호"));
		System.out.println(friends.indexOf("정재욱"));
		System.out.println(friends.isEmpty());
		
        // END:
    }

    public void updateTest() {
        // TODO: 홍길동이 있다면 값을 율도국 왕으로 변경해보자.
    	int idx = friends.indexOf("봉준호");
    	if(idx>=0) {
    		friends.set(idx,"지은미");
    	}
    	System.out.println("수정후 "+ friends);
        // END:
    }

    public void deleteTest() {
        // TODO: 0번째 친구와 율도국 왕을 삭제하시오.
    	friends.remove(0);
    	friends.remove("BTS");
        // END:
        System.out.println("삭제 후 : " + friends);
        friends.clear();// 리스트 초기화
        System.out.println("초기화 후 : " + friends);
    }
}
