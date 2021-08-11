package BJ.Lecture.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**Date : 08/12/2021
 * Author: June Park */
public class BOJ_9093 {
	//Stack 을 활용하였다
	static Stack<Character> st = new Stack<Character>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Getting Input:
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); String[] input = new String[T]; //Get number of Test Cases and make a String array
		for(int i =0; i<T; i++) {
			input[i]= br.readLine();//if input is 3 -> stored as {"hello there hi", "how are you", "mehhh"};
			reverse(input[i]); // call solution method -> parsing one string input at a time
			}
	}
	
	public static void reverse(String a) { 		//String[] input 중 i 번째 스트링 인풋이 들어옴
		String[] splitted = a.split(" "); 		//들어온 문자열을 띄어쓰기를 기준으로 배열에 넣음
		for(int i =0; i<splitted.length; i++) { //배열만큼 루프 돌리기
			for(int j =splitted[i].length()-1; j>=0;j--) { //i번째 배열의 문장의 길이만큼
				st.push(splitted[i].charAt(j)); //각 문자를 스택에 쌓고 출력문에 더한다
				sb.append(st.pop());			//그리고 다시 스택을 비운다
			}
			st.push(' '); 						//한 문장이 끝났단 소리는 띄어쓰기가 있었단 소리이므로 추가하고 빼주자
			sb.append(st.pop()); 				//다시 다음 배열의 문장으로 넘어간다
			
		}
		sb.setLength(sb.length()-1);			//맨 마지막에 공백을 추가하는 알고리즘으로 짯기 때문에 공백을 제거한다
		System.out.println(sb);
		sb.setLength(0);						//리셋 (스택은 이미 루프 안에서 리셋됬으므로 리셋할 필요 없다)
	}

	

}
