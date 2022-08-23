import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, res = 0;
	static int[][] laboratory;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static List<Point> virus_list = new ArrayList<Point>();
	
	
	static void virusMove(int[][] laboratory) {
		int[][] clab = new int[N][M];
		for(int i = 0; i < N; i++) {
			System.arraycopy(laboratory[i], 0, clab[i], 0, M);
		}
		
		
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 0; i < virus_list.size(); i++) {
			q.offer(virus_list.get(i));
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && clab[nx][ny] == 0) {
					clab[nx][ny] = 2;
					q.offer(new Point(nx,ny));
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(clab[i][j] == 0) sum++;
			}
		}		
		
		res = Math.max(sum, res);
	}
	
	static void wallInstall(int cnt) {
		if(cnt == 3) {
			virusMove(laboratory);
			return;
		}
				
		for(int i = 0; i < N; i++) {		
			for(int j = 0; j < M; j++) {
				if(laboratory[i][j] == 0) {
					laboratory[i][j] = 1;
					wallInstall(cnt+1);
					laboratory[i][j] = 0;
				}
			}
		}
	}
	
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	laboratory = new int[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			laboratory[i][j] = sc.nextInt();
    			if(laboratory[i][j] == 2) virus_list.add(new Point(i,j));			
    		}
    	}
    	
    	wallInstall(0);
    	System.out.println(res);
    }   
}

class Point{
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
