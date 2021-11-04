package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17204_죽음의게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 게임에 참여하는 사람 수
		int K = Integer.parseInt(st.nextToken()); // target Number
		int targets[] = new int[N];
		for (int i = 0; i < N; i++) {
			// i 번째 사람이 지목하는 사람의 번호
			// 영기는 0번
			targets[i] = Integer.parseInt(br.readLine());
		}
		// count 해서 K에서 끝나면 게임 종료. 한번씩 다 방문해봤는데도 K가 안걸리면 -1
		boolean visited[] = new boolean[N];
		int count = 0; // 몇번째로 걸리는지 세는 변수
		int index = 0;

		while (true) {
			if (targets[index] == K) {//찾음
				count++;
				System.out.println(count);
				return;
			}
			if (visited[targets[index]]) {
				System.out.println(-1);
				return;
			}
			//System.out.println(visited[targets[index]]);
			index = targets[index]; // 다음 사람 인덱스
			visited[index] = true;  // 방문처리
			count++;				// 돌린? 횟수
		}

	}

}
