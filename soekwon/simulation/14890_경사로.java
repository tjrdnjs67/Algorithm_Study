import java.util.Scanner;

public class Main {
	
	static int N, L, Res;
	static int[][] board;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
		
	static boolean isAbleRunway(int x, int y, int dir) {
		
		int val = board[x][y];
		
		for(int i = 0; i < L; i++) {
			if(x < 0 || x >= N || y < 0 || y >= N || board[x][y] != val) return false;
			
			x = x + dx[dir];
			y = y + dy[dir];
		}
			
		return true;
	}
	
	static void findRoute(int n, int x, int y, int dir, int cnt) {
		if(n == N - 1) {
			Res += 1;

			return;
		}
				
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(board[nx][ny] == board[x][y]) 
			findRoute(n+1, nx, ny, dir, cnt+1);
		else if(board[nx][ny] == board[x][y] - 1) {
			if(isAbleRunway(nx,ny, dir)) {	
				nx = x + L * dx[dir];
				ny = y + L * dy[dir];
				
				findRoute(n+L, nx, ny, dir, 0);
			} 
		}
		else if(board[nx][ny] == board[x][y] + 1 ) {
			if(cnt >= L)
				findRoute(n+1, nx, ny, dir, 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		Res = 0;
		for(int i = 0; i < N; i++) {
			//n, x, y, dir, cnt
			int res = Res;
			//up
			findRoute(0,N-1,i,0,1);

			//right	
			res = Res;
			findRoute(0,i,0,1,1);		

		}
		
		System.out.println(Res);
	}
	
}
