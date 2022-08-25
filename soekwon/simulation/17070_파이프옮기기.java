import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static int N;
	static int res;
	static int[][] board;
	static int[] dx = {0,1,1};
	static int[] dy = {1,1,0};
	
	static void dfs(int x, int y, int mode) {
		if(x < 0 || x >= N || y < 0 || y >= N) return;
		if(board[x][y] == 1) return;
		if(mode == 1 && ( board[x][y - 1] == 1  || board[x-1][y] == 1 )) return;
		
		if(x == N-1 && y == N-1) {
			res++;
			return;
		}
		
		for(int dir = 0; dir < 3; dir++) {
			if(mode == 0 && dir == 2) continue;
			if(mode == 2 && dir == 0) continue;
			   
			dfs(x+dx[dir], y+dy[dir], dir);
		}
	}
	
	
    public static void main(String[] args) throws NumberFormatException, IOException{
       //System.setIn(new FileInputStream("input.txt"));
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       N = Integer.parseInt(br.readLine());
       board = new int[N][N];
       
       for(int i = 0; i < N; i++) {
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   for(int j = 0; j < N; j++) {
    		   board[i][j] = Integer.parseInt(st.nextToken());
    	   }	   
       }
       
       dfs(0,1,0);
       
	   
	   System.out.println(res);
    }
}

