import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class Main {
	
	static int N, M;
	static int[][] map;
	static int[][] check;
	static int[][] lDist;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	
	static void count(int x, int y, int dir, int val) {
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == val) return;
		int cnt = 0;
		while(true) {
			
			cnt++;
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == val) return;
			if(map[nx][ny] != 0) {
				if(cnt == 1) return;
				
				if(lDist[val][map[nx][ny]] > cnt) {
					lDist[val][map[nx][ny]] = cnt;
					lDist[map[nx][ny]][val] = cnt;
				}			
				return;
			}			
			
		}		
	}
	
	static void findEdge(int x, int y, int val) {
		
		
		for(int dir = 0; dir < 4; dir++) {
			count(x, y, dir, val);
		}
		
	}
	
	static void bfs(int x, int y, int c) {
		Queue<Point> q = new LinkedList<Point>();
		
		q.offer(new Point(x,y));
		check[x][y] = 1;
		map[x][y] = c;
		
		while(!q.isEmpty()) {
			
			Point polled = q.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = polled.x + dx[dir];
				int ny = polled.y + dy[dir];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && check[nx][ny] == 0) {
					check[nx][ny] = 1;
					map[nx][ny] = c;
					
					q.offer(new Point(nx,ny));
				}
			}
		}
		
	}
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		check = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		// map 채우기
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && check[i][j] == 0) {
					cnt++;
					bfs(i,j,cnt);
				}
			}
		}
		
		
		lDist = new int[cnt+1][cnt+1];
		
		for(int i = 0; i < cnt+1; i++) {
			Arrays.fill(lDist[i], Integer.MAX_VALUE);
		}
		
		
		// 간선 채우기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					findEdge(i,j,map[i][j]);
				}
			}
		}
		
		
		// 모든 다리가 이어져 있나 여부
		boolean tf = true;
		for(int i = 1; i < cnt+1; i++) {
			int able = Integer.MAX_VALUE;
			for(int j = 1; j < cnt+1; j++) {
				if(able > lDist[i][j]) {
					able = lDist[i][j];
					 break;
				}
			}
			if(able == Integer.MAX_VALUE) {
				tf = false;
				break;
			} 
		}
		
		if(tf) {	
			// 최소의 경우의 수 계산하기
			int res = 0;
			boolean[] selected = new boolean[cnt+1]; //최소 신장 트리에 속한 정점 
			int[] dist = new int[cnt+1]; //현재 구성된 최소 신장 트리에서 각 정점에 대한 비용
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;
			
			//정점의 횟수만큼 돌면서
			for (int i = 1; i < cnt+1; i++) {
				
				int v = -1;
				int min = Integer.MAX_VALUE;
				
				for (int j = 1; j < cnt+1; j++) {
					if (!selected[j] && min > dist[j]) {
						v = j;
						min = dist[j];
					}
				}
				
				if(v == -1) {
					res = -1;
					break;
				};

				selected[v] = true;
							
				res += dist[v];
				
				//dist 배열 갱신
				for (int j = 1; j < cnt+1; j++) {
					if (!selected[j] && dist[j] > lDist[v][j]) {
						dist[j] = lDist[v][j];
					}
				}
			}		
			System.out.println(res);
		}else {
			System.out.println(-1);
		}
		
	}
	
}
