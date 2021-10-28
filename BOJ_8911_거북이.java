package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_8911_거북이 {
	
	/** x, y 좌표를 찍어두는 클래스.
	 *  ArrayList 형태로 저장 후, 마지막에 absolute value of x and y 좌표의 max
	 *  넓이 계산
	 * */
	public static class Positions{
		int x,y;
		Positions(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int direction ; //현재 방향 : 1(상) 2 (우) 3(좌) 4 하
	static ArrayList<Positions> locations; //좌표값들을 담을 arrlist
	/**방향 전환 매서드
	 * L 커멘드가 들어왔을 때의 방향
	 * */
	public static void Left() {
		//previous 방향 (방향 : 1(상) 2 (우) 3(좌) 4 하)
		if(direction == 1) { direction = 3; }		//forward 였을 경우 -> 좌
		else if (direction == 2) { direction = 1;}	//right 였을 경우 -> 위
		else if (direction == 3) { direction = 4;}	//left 였을 경우 -> 하
		else if (direction == 4) {direction = 2;}
	}
	
	/**방향 전환 커멘드
	 * R 커멘드가 들어왔을 때의 방향
	 * */
	public static void Right() {
		if(direction == 1) { direction = 2; }		//forward 였을 경우 -> 우
		else if (direction == 2) { direction = 4;}	//right 였을 경우 -> 아래
		else if (direction == 3) { direction = 1;}	//left 였을  -> 하
		else if (direction == 4) {direction = 2;}
	}
	
	static int [] dx = {0,0,-1,1,0};//0상우좌하 순서 맞춤
	static int [] dy = {0,1,0,0,-1};
	
	/**방향 전환 커멘드
	 * Back*/
	public static void Back() {
		if(direction == 1) { direction = 4; }		//forward 였을 경우 ->하
		else if (direction == 2) { direction = 3;}	//right 였을 경우 -> left
		else if (direction == 3) { direction = 2;}	//left 였을  -> right
		else if (direction == 4) {direction = 1;}
	}
	/**명령을 수행하는 메서드
	 * F : 현재 방향으로 한칸 이동
	 * B : 현재와 반대 방향으로 방향 전환 후, 한칸 이동
	 * R : 표를 참고하여 우측 방향으로 이동
	 * L : 표를 참고하여 좌측 방향으로 이동
	 * */
	public static void Commands(char command , Positions previousLocation) { 
		int nx ,ny; //새 좌표를 담을 x y 좌표
		switch(command) {
		case 'F':
			//previous 방향으로 이동
			//1. previous  : direction과 동일
			nx = previousLocation.x + dx[direction];
			ny = previousLocation.y + dy[direction];
			locations.add(new Positions(nx,ny)); //새 좌표 추가
			break;
		case 'B':
			//previous 방향과 반대 방향으로 이동
			//1. previous와 반대 방향으로 전환
			Back();
			//2. 새 좌표 생성
			nx = previousLocation.x + dx[direction];
			ny = previousLocation.y + dy[direction];
			locations.add(new Positions(nx,ny));
			break;
		case 'L':
			//previous 방향에서 Left 수행
			Left();
			break;
		case 'R':
			//previous 방향에서 Right 수행
			Right();
			break;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ; t++) {
			locations = new ArrayList<>();
			direction  =1 ;//방향의 디폴트값은 상으로 설정
			locations.add(new Positions(0,0)); //시작좌표 삽입
			//System.out.println(locations.get(0).x + ", "+ locations.get(0).y);
			
			char[] commands = br.readLine().toCharArray(); //input완료
			//System.out.println(Arrays.toString(commands));
			
			for(int c = 0 ; c< commands.length; c++) {
				Commands(commands[c] , locations.get(locations.size()-1)); //command 와 최신 좌표
			}
			
			//좌표 print
			int xMax= Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
			for(int i = 0 ; i< locations.size() ; i++) {
			//	System.out.println("x: "+ locations.get(i).x + "y: "+locations.get(i).y);
				xMax = Math.abs(locations.get(i).x)> xMax ? Math.abs(locations.get(i).x) : xMax;
				yMax = Math.abs(locations.get(i).y)> yMax ? Math.abs(locations.get(i).y) : yMax;
			}
			if(xMax== 0|| yMax==0) {System.out.println(0);} //선분일 경우
			else { System.out.println(xMax*yMax);}
			
		}
		

	}

}
