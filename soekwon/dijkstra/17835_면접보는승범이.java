import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class City{
	long val;
	int cur;

	public City(long val, int cur) {
		this.val = val;
		this.cur = cur;
	}

}



public class Main {
	static int N, M, K;
	static ArrayList<int[]>[] list;
	static long[] arr = new long[100005];
	static long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시의 수
		M = Integer.parseInt(st.nextToken()); // 도로의 수
		K = Integer.parseInt(st.nextToken()); // 면접장의 수
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = INF;
			list[i] = new ArrayList<>();
		}
		
		Queue<City> q = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 도시의 수
			int to = Integer.parseInt(st.nextToken()); // 도로의 수
			int val = Integer.parseInt(st.nextToken()); // 면접장의 수
			
			list[to].add(new int[] {from,val});
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int v = Integer.parseInt(st.nextToken());
			
			arr[v] = 0;
			q.offer(new City(0,v));
		}
		
		
		while(!q.isEmpty()) {
			
			City polled = q.poll();
			
			if(arr[polled.cur] < polled.val) {
				continue;
			}
			
			
			for(int i = 0, size = list[polled.cur].size(); i < size; i++) {
				if(arr[list[polled.cur].get(i)[0]] <= polled.val +list[polled.cur].get(i)[1]) {
					continue;
				}
				
				arr[list[polled.cur].get(i)[0]] = polled.val +list[polled.cur].get(i)[1];
				q.offer(new City(polled.val +list[polled.cur].get(i)[1], list[polled.cur].get(i)[0]));
			}
			
		}
		
		long res = 0;
		int idx = 0;
		for(int i = 1; i < N+1; i++) {
			if(res < arr[i]) {
				res = arr[i];
				idx = i;
			}
		}

		
		System.out.println(idx);
		System.out.println(res);
	}

}
