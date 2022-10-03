import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//4 4 1
//1 1 2 3
//5 2 4 2
//3 1 3 5
//2 1 3 2
//2 0 1
// 0 시계
// 1 반시계

public class Main{
	
	static int N,M,T;
	static int[][] circles;
	static boolean[][] check;
	static boolean tf; // 인접하면서 같은 수가 있는지 없는지 여부를 판단 

	static void avgCircle() {
		
		int sum = 0;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(circles[i][j] > 0) {
					sum += circles[i][j];
					cnt++;
				} 
			}
		}
		
		double avg = (double)sum / cnt;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(circles[i][j] > 0) {
					if(circles[i][j] > avg) {
						circles[i][j] -= 1;
					}else if(circles[i][j] < avg) {
						circles[i][j] += 1;
					}
				} 
			}
		}
		
	}
	
	
	static void erase() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(check[i][j]) circles[i][j] = -1;
			}
		}
	}
	
	static void eraseCircle(int v) {
		if(v == N - 1) {
			for(int i = 0; i < M; i++) {
				int val = circles[v][i];
				
				if(val > 0 && circles[v][(i+M-1)%M] == val) {
					check[v][(i+M-1)%M] = true;
					tf = true;
					check[v][i] = true;
				}
				if(val > 0 && circles[v][(i+1)%M] == val) {
					check[v][(i+1)%M] = true;
					tf = true;
					check[v][i] = true;
				}
			}
			
			if(tf) {
				erase();
			}	
			return;
		} 
		
		for(int i = 0; i < M; i++) {
			int val = circles[v][i];
			
			if(val > 0 && circles[v+1][i] == val) {
				check[v+1][i] = true;
				tf = true;
				check[v][i] = true;
			} 
			if(val > 0 && circles[v][(i+M-1)%M] == val) {
				check[v][(i+M-1)%M] = true;
				tf = true;
				check[v][i] = true;
			}
			if(val > 0 && circles[v][(i+1)%M] == val) {
				check[v][(i+1)%M] = true;
				tf = true;
				check[v][i] = true;
			}
		}
		
		
		eraseCircle(v+1);
	}
	
	static void rotateCircle(int num, int dir, int cnt) {
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i = 0; i < M; i++) {
			dq.offer(circles[num][i]);
		}
		
		if(dir == 0) {		
			for(int i = 0; i < cnt; i++) {
				int val = dq.pollLast();
				dq.offerFirst(val);
			}
		}else {
			for(int i = 0; i < cnt; i++) {
				int val = dq.pollFirst();
				dq.offerLast(val);
			}
		}
		
		for(int i = 0; i < M; i++) {
			circles[num][i] = dq.pollFirst();
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		
		circles = new int[N][M];
		//parents = new int[N * M + 1];
		
		
		// 원판 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				circles[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < T; i++) {
			
			int n = sc.nextInt();
			int dir = sc.nextInt();
			int cnt = sc.nextInt();
			
			//원판 돌리기
			for(int k = 1; k * n - 1 < N; k++)
				rotateCircle(n*k-1,dir,cnt);
			

			
			//인접한 같은 수 지우기
			check = new boolean[N][M];
			tf = false;
			eraseCircle(0);
			
			//인접한 수가 없을 경우 평균을 구해서 +1, -1 연산
			if(!tf) {
				avgCircle();
			}
		}
		
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(circles[i][j] > 0) res += circles[i][j];
			}
		}
		
		System.out.println(res);
	}
}
