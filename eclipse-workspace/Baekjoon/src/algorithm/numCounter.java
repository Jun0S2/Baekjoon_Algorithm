package algorithm;

/**
 * author: June Park
 * Date: 07/14/2021
 * #2577
 * Result : Success
 * 
 * */
import java.util.Scanner;
public class numCounter {

	public static void main(String[] args) {
        
		//get input
        Scanner sc = new Scanner(System.in);
        int multiplied =  (sc.nextInt() * sc.nextInt()*sc.nextInt());
        
        //save to array
        int[] ar1 = new int[20];
        int counter = 0;
        while (multiplied > 0) {
        ar1[counter] = multiplied % 10;
        multiplied = multiplied / 10;
        counter++;} 
        //so counter is the length of the array
        
        
        // {3,4,2,3,4,2,} -> count
        int[] count = new int[]{0,0,0,0,0,0,0,0,0,0}; //counts from 0 to 9
        for (int i = 0; i<counter; i++){
            count[ar1[i]]++;
        }
        //print the results
        for(int i= 0; i <count.length; i++){
            System.out.println(count[i]);
        }
        

    }}