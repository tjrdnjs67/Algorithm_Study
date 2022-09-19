import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Edge implements Comparable<Edge>{
	int from, to, val;
	
	Edge(int from, int to, int val){
		this.from = from;
		this.to = to;
		this.val = val;
	}

	@Override
	public int compareTo(Edge o) {
		return this.val - o.val;
	}
}

public class Main {

	static int N, M;
	static int[] parents;
	static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	
	static void make() {
		for(int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];
	
		for(int i = 0; i < M; i++) {
			int f = sc.nextInt();
			int t = sc.nextInt();
			int val = sc.nextInt();
			
			edges.add(new Edge(f,t,val));
		}
		
		make();
		Collections.sort(edges);
		
		int res = 0;
        int cnt = 0;
        for(Edge d : edges) {
            if(union(d.from, d.to)) {
                res += d.val;
                cnt++;
            }
            if(cnt == N - 1) { // 연결된 간선의 갯수가  정점의 -1 갯수이면 종료
                res -= d.val;
            	break;
            }
        }

			
		System.out.println(res);
		
	}
	
}
