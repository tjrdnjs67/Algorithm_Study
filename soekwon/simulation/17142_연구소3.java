import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//7 3
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 2 0 1 1
//0 1 0 0 0 0 0
//2 1 0 0 0 0 2

class Point{
	int x, y, cnt;
	
	public Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main{
	
	static int N, M, res = Integer.MAX_VALUE; // N : 연구실의 크기 , M : 바이러스의 개수
	static int[] arr; // 활성화 시킬 바이러스 인덱스 저장
	static int[][] lab; // 연구소
	static ArrayList<Point> virus = new ArrayList<Point>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	private static void simulation(int v, int idx) {
		if(v == M) {		
			int[][] copy = copyLab();
			int num = bfs(copy);
			res = Math.min(res, num);
			return;
		}
			
		for(int i = idx, size = virus.size(); i < size; i++) {		
			arr[v] = i;
			simulation(v+1, i+1);
		}
	}
	
	private static int bfs(int[][] copy) {
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 0; i < M; i++) {
			Point v = virus.get(arr[i]);
			copy[v.x][v.y] = 0;
			q.offer(v);
		}
		
		while(!q.isEmpty()) {
			
			Point polled = q.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = polled.x + dx[dir];
				int ny = polled.y + dy[dir];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && copy[nx][ny] == -2) {
					copy[nx][ny] = -1;
					q.offer(new Point(nx,ny,polled.cnt+1));
				}else if(nx >= 0 && nx < N && ny >= 0 && ny < N && copy[nx][ny] > polled.cnt + 1) {
					copy[nx][ny] = polled.cnt + 1;
					q.offer(new Point(nx,ny,polled.cnt+1));
				}
				
			}
			
		}
		
		int num = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(copy[i][j] > num) num = copy[i][j];
			}
		}
		
		return num;
	}

	private static int[][] copyLab() {
		int[][] copy = new int[N][N];
		for(int i = 0; i < N; i++) {
			System.arraycopy(lab[i], 0, copy[i], 0, lab[i].length);
		}
		return copy;
	}

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		arr = new int[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 0) {
					lab[i][j] = Integer.MAX_VALUE;
				}
				else if(val == 1) {
					lab[i][j] = -1;
				}
				else {
					virus.add(new Point(i,j,0));
					lab[i][j] = -2;
				}
			}
		}
		
		simulation(0, 0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}

}



