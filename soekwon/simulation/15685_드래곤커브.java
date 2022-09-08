import java.util.ArrayList;
import java.util.Scanner;


public class Main{
	
	static int[][] board = new int[101][101];
	static int X,Y,d,g;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static ArrayList<Integer> point = new ArrayList<Integer>();
	
	static void dfs(int x, int y, int gen) {
		if(gen > g) return;
		
		int nx = x;
		int ny = y;
		
		for(int i = point.size() -1; i >= 0; i--) {
			int dir = (point.get(i) + 1) % 4;
			point.add(dir);
			
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			board[nx][ny] = 1;
		}
		
		dfs(nx,ny,gen+1);
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	
    	//모든 드래곤 커브 배열에 저장
    	for(int i = 0; i < n; i++) {
    		point.clear();
    		
    		Y = sc.nextInt();
    		X = sc.nextInt();
    		d = sc.nextInt();
    		g = sc.nextInt();
    		
    		point.add(d);
    		board[X][Y] = 1;
    		board[X + dx[d]][Y + dy[d]] = 1;
    		dfs(X + dx[d],Y + dy[d],1);	
    	}
    	
    	// 정사각형의 갯수 새기
    	int res = 0;
    	for(int i = 0; i < 100; i++) {
    		for(int j = 0; j < 100; j++) {
    			
    			if(board[i][j] == 1 && board[i+1][j] == 1 && board[i][j+1] == 1 && board[i+1][j+1] == 1) {
    				res += 1;
    			}
    		}
    	}
    	
 	
    	System.out.println(res);
    }

}

