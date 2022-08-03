import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main {
	
	static boolean melt = false;
	static int[][] arr;
	static int[][] checked; 
	static int n;
	static int m;
	static int cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
		
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		int year = 0;
		while(!melt) {
			int num = yearLater();
			year++;
			
			if(num == 0) {
				melt = true;
				break;
			}
			
			if(num >= 2) {
				break;
			}
		}
		
		if(melt) {
			System.out.println(0);
		}else {
			System.out.println(year);
		}
		
	}
	
	static int yearLater() {
		
		meltIce();
		checked = new int[n][m];
		cnt = 1;
		
		for(int i = 0; i <n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] < 0){
					arr[i][j] = 0; 
					continue;
				}
				
				if(arr[i][j] != 0 && checked[i][j] == 0) {
					checked[i][j] = cnt;
					islandcheck(i,j);
					cnt++;
				}
			}
		}
		
		return cnt-1;
	}
	
	static void meltIce() {
				
		for(int i = 0; i <n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] != 0) {
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						
						if(isBound(n,m,nx,ny) && arr[nx][ny] == 0) {
							arr[i][j]--;
							
							if(arr[i][j] == 0) {
								arr[i][j] = -1;
								break;
							}
						}
						
					}
				}				
			}
		}
	}
	
	
	static boolean isBound(int boundX, int boundY, int x, int y) {
		return x >= 0 && x < boundX && y >= 0 && y <boundY;
	}
	
	static void islandcheck(int i, int j) {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(new Point(i,j));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = (int)p.getX();
			int y = (int)p.getY();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(isBound(n,m,nx,ny) && arr[nx][ny] > 0 && checked[nx][ny] == 0) {
					checked[nx][ny] = cnt;
					queue.add(new Point(nx,ny));
				}
			}
			
		}
	}
}
