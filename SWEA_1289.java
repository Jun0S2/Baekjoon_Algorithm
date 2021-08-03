package review.day1;

import java.util.Scanner;

public class SWEA_1289 {
/**원재의 메모리 복구하기
 * 메모리가 초기화 되었다 == 0000
 * original memory 가 주어졌을때, 몇번 not 해야하나
 * ex) 0011-> 0000 -> 0011 한번
 * 	   1000-> 1111 -> 1000 두번
 * Methodology:
 * char compare = '0';
 * 앞bit와 compare 가 같나? 같으면 아무것도 안해도 됨
 * 다른가? 그럼 count ++. compare = '1'하고 하면 memory를 not 시키지 않아도 비교만 not 시켜서 하면 같다
 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T =sc.nextInt();
		for(int t = 1; t<=T; t++) {
			String input = sc.next();
			int answer = operations(input);
			
			
			//Print Result:
			System.out.printf("#%d %d", t, answer);
		}

	}
	static int operations(String original) {
		char compare = '0'; //시작은 0
		int count = 0;
		for(int i =0; i<original.length();i++) {
			if(original.charAt(i)==compare) {continue;}//do nothing
			else {
				count ++;
				compare = compare =='0' ? '1': '0';
			}
		}
		return count;
	}

}
