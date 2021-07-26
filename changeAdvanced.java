import java.util.Arrays;
import java.util.Scanner;
/**Date 07/26/2021
 * Author June Park
 * SWEA # 1970
 * */
public class changeAdvanced {
		static int[] coins = {50000,10000,5000,1000,500,100,50,10};
		static 	int[] counts = {0,0,0,0,0,0,0,0};
		static Scanner sc = new Scanner(System.in);
		
		public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i=1;i<=T;i++) {
			int paid = sc.nextInt();
			rechange(paid);
			System.out.println("#"+i);
			System.out.println(Arrays.toString(counts).toString().replace("[", "").replace("]", "").replace(",", ""));
		}
		}
		
	static int[] rechange(int paid) {
		int target = paid;
		for(int i = 0; i< coins.length; i++) {
			counts[i] = target / coins[i];
			int subtracted = target - (counts[i]*coins[i]);
			target = subtracted;
			}
		//System.out.println(Arrays.toString(counts));
	return counts;	
	}


		
		
	
}
