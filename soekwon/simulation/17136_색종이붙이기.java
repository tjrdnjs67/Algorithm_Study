import java.util.Scanner;


public class Main{
	static int res = Integer.MAX_VALUE;
	static int[][] board = new int[10][10];
	static int[] papers = {0, 5, 5, 5, 5, 5};
	
	static void dfs(int x, int y, int cnt) {
		if(x == 10 && y == 0) {
			if(cnt == 0) return;
			
			res = Math.min(res, cnt);
			
			return;
		}
		
		if(y == 10) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		
		if(board[x][y] == 1) {
			for(int i = 1; i <= 5; i++) {
				// 색종이가 있는지 여부
				if(papers[i] <= 0) continue;
				// 색종이를 붙일 수 있는지 여부
				if(!isAble(x,y,i)) continue;
				
				attach(x,y,i);
				papers[i] -= 1;
				dfs(x, y+1, cnt+1);
				unattach(x,y,i);
				papers[i] += 1;
				
			}
			
		}else {
			dfs(x, y+1, cnt);
		}
		
	}
	
	static boolean isAble(int x,int y, int cnt) {
		for(int i = x; i < x + cnt; i++) {
			for(int j = y; j < y + cnt; j++) {
				if(i < 0 || i >= 10 || j < 0 || j >= 10 || board[i][j] == 0) return false;
			}
		}
		
		return true;
	}
	
	static void attach(int x, int y, int cnt) {
		for(int i = x; i < x + cnt; i++) {
			for(int j = y; j < y + cnt; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	static void unattach(int x, int y, int cnt) {
		for(int i = x; i < x + cnt; i++) {
			for(int j = y; j < y + cnt; j++) {
				board[i][j] = 1;
			}
		}
	}
	
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	int cnt = 0;
    	for(int i = 0; i < 10; i++) {
    		for(int j = 0; j < 10; j++) {
    			board[i][j] = sc.nextInt();
    			if(board[i][j] == 1) cnt++;
    		}
    	}
    	
    	if(cnt == 0) {
    		System.out.println(0);
    	}else {
    		dfs(0,0,0);
        	if(res == Integer.MAX_VALUE) {
        		System.out.println(-1);
        	}else {
        		System.out.println(res);
        	}
    	}	
    }

}

