import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;


class Tree implements Comparable<Tree>{
	
	int x, y, age;
	
	Tree(int x,int y, int age){
		this.x = x;
		this.y = y;
		this.age = age;
	}

	@Override
	public int compareTo(Tree o) {
		return this.age - o.age;
	}
	
	
}


public class Main{
	
	static int N, M, K;
	static int[][] nourishment;
	static int[][] map;
	static int[][] map2;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
		
	public static void main(String[] args) throws IOException {
		 Scanner sc = new Scanner(System.in);
		 
		 N = sc.nextInt(); // 땅의 크기
		 M = sc.nextInt(); // 나무의 수
		 K = sc.nextInt(); // k년 후
		 
		 nourishment = new int[N][N];
		 map = new int[N][N];
		 map2 = new int[N][N];
		 
		 
		 for(int i = 0; i < N; i++) {
			 for(int j = 0; j < N; j++) {
				 nourishment[i][j] = sc.nextInt();
				 map[i][j] = 5;
			 }
		 }
		 
		 PriorityQueue<Tree> pq = new PriorityQueue<>();

		 for(int i = 0; i < M; i++) {
			 int x = sc.nextInt() - 1;
			 int y = sc.nextInt() - 1;
			 int z = sc.nextInt();
			 
			 pq.offer(new Tree(x,y,z));
		 }
		 
		 for(int time = 1; time <= K; time++) {
			 PriorityQueue<Tree> npq = new PriorityQueue<>();
			 // 봄, 여름
			  
			 for(int i = 0, size = pq.size(); i < size; i++) {
				 Tree polled = pq.poll();
				 
				 int x = polled.x;
				 int y = polled.y;
				 
				 if(map[x][y] >= polled.age) {
					 npq.offer(new Tree(x,y, polled.age+1));
					 map[x][y] -= polled.age;
				 }else {
					 map2[x][y] += polled.age/2;
				 }
				 
			 }		 
			 pq = npq;
			 
			 
			 // 가을
			 npq = new PriorityQueue<>();
			  
			 for(int i = 0, size = pq.size(); i < size; i++) {
				 Tree polled = pq.poll();
				 
				 int x = polled.x;
				 int y = polled.y;
			 
				 if(polled.age % 5 == 0) {
					 for(int dir = 0; dir < 8; dir++) {
						 	int nx = x + dx[dir];
							int ny = y + dy[dir];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
								npq.offer(new Tree(nx,ny,1));
							}
					 }
					 
				 }
				 
				 npq.offer(polled);
			 }
			 pq = npq;
			 
			 // 겨울
			 for(int i = 0; i < N; i++) {
				 for(int j = 0; j < N; j++) {
					map[i][j] += nourishment[i][j] + map2[i][j];
					map2[i][j] = 0;
				 }
			 }
			 
		 }
		 
		 System.out.println(pq.size());
	}


}



