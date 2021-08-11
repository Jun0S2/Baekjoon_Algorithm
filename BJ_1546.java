package WarmingUp;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int courses = sc.nextInt();
		ArrayList<Integer> li = new ArrayList<>();
		for(int i =0; i<courses ; i++) {li.add(sc.nextInt());}
		//find max:
		double max =0; double sum =0;
		for(int i =0; i<li.size();i++) {max=li.get(i)>max ? li.get(i): max;}
		//fabricate scores
		for(int i =0; i<li.size(); i++) {sum+=li.get(i)*100/max;}
		System.out.println(sum/courses);
		li.clear();
	}

}
