import java.util.Scanner;


public class Main{
	static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] board;
	static int[][] adj;
	
	static void calculation() {
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int v = find(board[i][j]);
				int num = favoriteNum(v,i,j);
				//그 값이 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000이다.
				switch(num) {
				case 0:
					sum += 0;
					break;
				case 1:
					sum += 1;
					break;
				case 2:
					sum += 10;
					break;
				case 3:
					sum += 100;
					break;
				case 4:
					sum += 1000;
					break;
				}
			}
		}
		
		System.out.println(sum);
		
	}
	
	static void dfs(int v) {
		if(v == N*N) {
			calculation();
			return;
		}
		

		
		int purposX = 0, purposY = 0,fNum = 0,bNum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(board[i][j] != 0) continue;
				
				int temp = favoriteNum(v,i,j);
				if(temp > fNum) {
					fNum = temp;
					purposX = i; 
					purposY = j;
					bNum = blankNum(i,j);
				}else if(temp == fNum) {
					int temp2 = blankNum(i,j);
					if(temp2 > bNum) {
						bNum = temp2;
						purposX = i; 
						purposY = j;
					}
				}
				
			}
		}
		if(purposX == 0 && purposY == 0) {
			loop:for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(board[i][j] == 0) {
						purposX = i;
						purposY = j;
						break loop;
					}
				}
				
			}
		}
		
		board[purposX][purposY] = adj[v][0];
		dfs(v+1);
	}
	
	static int find(int val) {
		for(int i = 0; i < N*N; i++) {
			if(val == adj[i][0]) return i;
		}
		
		return 0;
	}
	
	static int favoriteNum(int v, int x, int y) {
		int num = 0;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx > 0 && nx <= N && ny > 0 && ny <= N && (board[nx][ny] == adj[v][1] || board[nx][ny] == adj[v][2] || board[nx][ny] == adj[v][3] || board[nx][ny] == adj[v][4])) {
				num += 1;
			}
		}	
		return num;
	}
	
	static int blankNum(int x, int y) {
		int num = 0;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx > 0 && nx <= N && ny > 0 && ny <= N && board[nx][ny] == 0) {
				num += 1;
			}
		}
		
		return num;
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	board = new int[N+1][N+1];
    	adj = new int[N*N][5];
    	
    	for(int i = 0; i < N*N; i++) {
    		for(int j = 0; j < 5; j++) {
    			adj[i][j] = sc.nextInt();
    		}
    	}
    	
    	dfs(0);
    }
}

