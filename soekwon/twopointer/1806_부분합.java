import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, s, res;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			System.setIn(new FileInputStream("input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			arr = new int[n];
			res = Integer.MAX_VALUE;
					
			st = new StringTokenizer(br.readLine());
			
			for(int i =0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int left = 0, right = 0;	
			int sum = arr[0];
			int cnt = 1;
			boolean tf = false;
			while(true) {	
				if(sum < s) {
					if(right < n - 1) {
						right++;
						cnt++;
						sum += arr[right];
					}else {
						break;
					}
				}else{
					tf = true;
					res = Math.min(cnt, res);
					if(res == 1) break;
					
					if(left < right) {
						sum -= arr[left];
						left++;
						cnt--;
					}else {
						break;
					}
				}
				
			}
			
			if(tf == false) {
				System.out.println(0);
			}else {
				System.out.println(res);
			}	
			
	}	
}

