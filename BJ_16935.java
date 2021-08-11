package homework;

import java.util.Arrays;
import java.util.Scanner;


public class BJ_16935 {
	static int[][] answer;
	public static void main(String[] args){
		/*
		int [][] a = {{1, 6, 2, 9, 8, 4 },
			{7 ,2 ,6 ,9 ,8 ,2 },
			{1 ,8, 3, 4 ,2 ,9},
			{7 ,4, 6 ,2 ,3, 1 },
			{9 ,2, 3 ,6, 1 ,5},
			{4 ,2, 9 ,3 ,1 ,8}};
		int N =6, M = 6;*/
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); int M = sc.nextInt(); int R= sc.nextInt();
		answer= new int[N][M];
		int[][] a = new int[N][M];
		for(int i =0; i<N;i++) {for(int j=0; j<M; j++) {a[i][j]=sc.nextInt();}}
		for(int i = 0; i<R; i++) {
			int operation = sc.nextInt();
			switch(operation) {
			case 1:
				operation1(a,N,M);
				break;
			case 2:
				operation2(a,N,M);
				break;
			case 3:
				operation3(a,N,M);
				break;
			case 4:
				operation4(a,N,M);
				break;
			case 5:
				operation5(a,N,M);
				break;
			case 6:
				operation6(a,N,M);
				break;
			
			}
			
		}
		for(int[] x: answer) {System.out.println(Arrays.toString(x).replace("[", "").replace(",", "").replace("]", ""));}
	}
	
 /*연산 1: 상하 반전*/
	static void operation1(int[][]a, int N, int M) {
	int rowStart=0, colStart =0, rowEnd=N-1 , colEnd=M-1;
	while(colStart<=colEnd) {
	int counter=0;
	for(int i=rowEnd; i>=0; i--) {
			answer[rowStart+counter][colStart]= a[i][colStart];
			counter++;
	}
	colStart++;}
		
	}
/*연산2: 좌우반전: row 가만히 col움직임*/	
	static void operation2(int[][]a , int N, int M) {
		int rowStart=0, colStart =0, rowEnd=N-1 , colEnd=M-1;
		while(rowStart<=rowEnd) {
		int counter=0;
		for(int i=colEnd; i>=0; i--) {
			answer[rowStart][colStart+counter]= a[rowStart][i];
			counter++;
		}
		rowStart++;}
		
	}
/*연산3: 90도 회전*/	
	static void operation3(int[][]a, int N, int M) {
		int rowStart=0, colStart =0, rowEnd=N-1 , colEnd=M-1;
		while(rowStart<=rowEnd) {
		//가로-> 세로
		for(int i=0; i<N; i++ ) {
			answer [i][colEnd] =a[rowStart][i];
		}
		colEnd--;
		rowStart++;}
	
	}
	/*연산4: 왼쪽으로 90도 회전: 맨 왼쪽 아래로 향하는 줄이 맨 가로 윗줄이 된다 오른쪽*/	
	static void operation4(int[][]a, int N, int M) {
		int rowStart=0, colStart =0, rowEnd=N-1 , colEnd=M-1;
		while(colEnd>=0) {
			//row is the one thats changing and its going from top to bottom
			int counter =0;
			for(int i=0; i<colStart; i++ ) {
				answer[i+counter][i]=a[i][colEnd];
				counter++;
				}
			colEnd--;
			}

		
	}
	/*연산5: 1-> 2->3->4->
	 * 1: 맨 왼쪽인데 범위가 : 
	 * 모르겠어서...노가다..분명 for loop nest하면 될텐데...
	 * :4로한범위임*/
	static void operation5(int[][] a,int N, int M) {
		int start=1, add = 0;
		//1 ->2:
		for(int i =0; i<=N/4+1 ; i++) { //row
			add = N/2; int four = M/4;
			for(int j =0; j<=M/4+1 ;j++) {
			answer[i][j+add] = a[i][j]; 
			}
		}
		//22->3
		//	add = N/2; int four = M/4;
		for(int j =0; j<=N/4+1 ;j++) { //row
		for(int i =M/2;i<M ; i++) { 
			answer[j+N/2][i] = a[j][i]; 
			}
		}
		//4->1
		//	add = N/2; int four = M/4;
		for(int j =N/2;j<N; j++) { //row
			for(int i =0; i<= M/4+1; i++) { 
			answer[j-N/2][i] = a[j][i]; 
			}
		}
		//3->4
		//	add = N/2; int four = M/4;
		for(int i =N/2; i<N ; i++) { //row
			for(int j =M/2;j<M ;j++) {
			answer[i][j-M/2] = a[i][j]; 
		}
	}
		
	
	
	}
	
	/*연산5: 1-> 2->3->4->
	 * 1: 맨 왼쪽인데 범위가 : 
	 * 모르겠어서...노가다..분명 for loop nest하면 될텐데...
	 * :4로한범위임*/
	static void operation6(int[][] a,int N, int M) {;
		//1 -> 4: same col, rows till 4/1
		for(int i =0; i<=N/4+1 ; i++) { //row
			for(int j =0; j<=M/4+1 ;j++) {
				answer[i+N/2][j] = a[i][j]; 
			}
		}
		// 4 -> 3: same col, rows till 4/1
		for(int i =N/2; i<N ; i++) { //row
			for(int j =0; j<M/2 ;j++) {
				answer[i][j+M/2] = a[i][j]; 
			}
		}
		// 3 -> 2: same col, rows till 4/1
		for(int i =N/2; i<N ; i++) { //row
			for(int j =M/2; j<M ;j++) {
				answer[i-N/2][j] = a[i][j]; 
			}
		}		
		// 3 -> 2: same col, rows till 4/1
		for(int i =0; i<N/2 ; i++) { //row
			for(int j =M/2; j<M ;j++) {
				answer[i][j-M/2] = a[i][j]; 
			}
		}		
	//	for(int[] x: answer) {System.out.println(Arrays.toString(x));}
		
		
	}
	
	
}
