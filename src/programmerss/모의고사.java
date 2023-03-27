package programmers;

import java.util.ArrayList;

public class Solution { //모의고사
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] person1 = {1,2,3,4,5}; //이만큼씩 반복
		int[] person2 = {2,1,2,3,2,4,2,5};
		int[] person3 = {3,3,1,1,2,2,4,4,5,5};
		int answer1 =0;
		int answer2 =0;
		int answer3 =0;

		for( int i=0; i< answers.length; i++){
			// 1번
			if ( answers[i] == person1[ i % 5 ]) answer1++;
			// 2번
			if ( answers[i] == person2[ i % person2.length ]) answer2++;
			// 3번
			if ( answers[i] == person3[ i % 10 ]) answer3++;
		}
		int max = Math.max(Math.max(answer1, answer2),answer3); // max값 구하기
		ArrayList<Integer> list = new ArrayList<Integer>();
		if ( max == answer1) list.add(1);
		if ( max == answer2) list.add(2);
		if ( max == answer3) list.add(3);

		answer = new int[ list.size()];
		for( int i=0; i<list.size(); i++){
			answer[i] = list.get(i);
		}

		return answer;
	}
}
