import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos>{
	int x, y, d;
	
	public Pos(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public int compareTo(Pos o) {
		return this.d - o.d;
	}
}

public class Main {
	
	static int N, M, res;
	static int[][] map;
	static boolean[][] isVisited;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
	    //System.setIn(new FileInputStream("input.txt"));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    isVisited = new boolean[N][M];
	    
	    for(int i = 0; i < N; i++) {
	    	
	    	char[] chs = br.readLine().toCharArray();
	    	
	    	for(int j = 0; j < M; j++) {
	    		if(chs[j] == '1') {
	    			map[i][j] = 1;
	    		}else {
	    			map[i][j] = 0;
	    		}
	    	}
	    }
	    
	    
	    PriorityQueue<Pos> q = new PriorityQueue<Pos>();
	    q.offer(new Pos(0,0,0));
	    isVisited[0][0] = true;
	    
	    while(!q.isEmpty()) {
	    	
	    	Pos polled = q.poll();
	    	
	    	if(polled.x == N - 1 && polled.y == M - 1) {
	    		res = polled.d;
	    		break;
	    	}
	    	
	    	for(int dir = 0; dir < 4; dir++) {
	    		int nx = polled.x + dx[dir];
	    		int ny = polled.y + dy[dir];
	    		
	    		if(nx >= 0 && nx < N && ny >= 0 && ny < M && !isVisited[nx][ny]) {
	    			if(map[nx][ny] == 1) {
	    				isVisited[nx][ny] = true;
	    				q.offer(new Pos(nx,ny,polled.d+1));
	    			}else {
	    				isVisited[nx][ny] = true;
	    				q.offer(new Pos(nx,ny,polled.d));
	    			}
	    		}
	    	}
	    }
	    
	    System.out.println(res);
	}

}
