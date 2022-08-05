import java.io.*;
import java.util.StringTokenizer;


public class Main {
	static int[] arr;
	static int[] res;
	static int N;
	
	static void poem(int v, int idx) {
		if(v == 6) {
			for(int i = 0; i <6; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i = idx; i <N; i++) {
			res[v] = arr[i]; 
			poem(v+1,i+1);
		}
		
	}
				
	public static void main(String[] args) throws NumberFormatException, IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			arr = new int[N];
			res = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			poem(0, 0);
			System.out.println();
		}
	}			
}

