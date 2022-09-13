import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x,y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N, L, R;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] board;
	static int[][] check;
	
	static boolean isopenborders(int x, int y) {
		
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && (Math.abs(board[x][y] - board[nx][ny]) >= L && Math.abs(board[x][y] - board[nx][ny]) <= R)) return true;
		}
		
		return false;
	}
	
	static void bfs(int x, int y, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x,y));
		check[x][y] = c;
		
		while(!q.isEmpty()) {
			
			Point polled = q.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = polled.x + dx[dir];
				int ny = polled.y + dy[dir];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && (Math.abs(board[polled.x][polled.y] - board[nx][ny]) >= L && Math.abs(board[polled.x][polled.y] - board[nx][ny]) <= R) && check[nx][ny] == 0) {
					check[nx][ny] = c;
					q.offer(new Point(nx,ny));
				}
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int res = 0;
		while(true) {
			
			int cnt = 0;
			check = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 연합을 이룰 수 있는지 여부를 판단한다.
					if(check[i][j] == 0 && isopenborders(i,j)) {
						cnt++;
						// bfs를 사용하여 연합을 이룬다.
						bfs(i,j,cnt);
					}
				}
			}
			if(cnt > 0) {
				int[] vals = new int[cnt+1];
				int[] counts = new int[cnt+1];
				
				// 각각의 연합의 총합과 연합을 이루고 있는 수를 구한다.
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(check[i][j] != 0) {
							vals[check[i][j]] += board[i][j];
							counts[check[i][j]]++;
						}
					}
				}
				//각각의 연합의 인구 수를 (연합 인구수) / (연합을 이루고 있는 칸 수)로 재분배한다.
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(check[i][j] != 0) {
							board[i][j] = vals[check[i][j]] / counts[check[i][j]];
						}
					}
				}
				
			}
			else {
				break;
			}
			
			
			res++;
		}
		
		System.out.println(res);
	}
	
}
