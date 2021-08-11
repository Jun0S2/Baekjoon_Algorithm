package WarmingUp;

import java.util.Scanner;

public class homework {
/*x- axis , y-axis : initial grpah : (0,0)
 * if input: 넓이 == +1 만큼 input 만큼
 * 
 * */
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int craftPapers = sc.nextInt();
		int paper[][] = new int [100][100];
		answer = 0;
		for(int i = 0; i<craftPapers; i++) {	
			int y = sc.nextInt(); int x = sc.nextInt();
			for(int j = x; j<x +10 ; j ++) {
				for(int k = y; k<y+10; y++) {
					if(paper[x][y]==1) {continue;}
					else if (paper[x][y]==0) { 
						paper[x][y] =1 ; //now covered
						answer++;}
		
				}//ennd of y
				}//end of x
		}//end of craftpapers 
		System.out.println(answer);
	
		}
		
	}
