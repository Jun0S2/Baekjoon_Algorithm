package WarmingUp;

import java.util.Scanner;

public class BJ_10818_최대최소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i =0; i<N;i++) {arr[i]=sc.nextInt();}
		
		print(arr);
	}
	static void print(int arr[]) {
		int max =arr[0], min = arr[0];
		for(int x: arr) {min = (min>x)?x:min;}
		for(int x: arr) {max = (max<x)? x: max;}
		System.out.printf("%d %d",min,max);
	}
}
