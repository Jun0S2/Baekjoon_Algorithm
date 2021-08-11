package WarmingUp;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int[] input = new int[10];
		ArrayList<Integer> li = new ArrayList<Integer>();
		for(int t=0; t<10; t++) {input[t]=sc.nextInt();
		int temp = input[t]%42;
		if(!li.contains(temp))li.add(temp);
		}
		System.out.println(li.size());
		li.clear();
		
	}

}
