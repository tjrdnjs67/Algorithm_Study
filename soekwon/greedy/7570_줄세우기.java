import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//5
//5 2 4 1 3

public class Main{
	
	static int N, res;
	static int[] arr = new int[1000005];
	

	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[val] = i;
		}
		
		int len = 1;
		for(int i = 0; i < N-1; i++) {
			if(arr[i] < arr[i+1]) res = Math.max(res, ++len);
			else len = 1;
		}
		System.out.println(N - res);
	}	

}
