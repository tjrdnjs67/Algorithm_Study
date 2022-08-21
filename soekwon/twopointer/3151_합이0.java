import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long res;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			//System.setIn(new FileInputStream("input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
					
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i =0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			
			
			for(int i = 0; i < n-2; i++) {
				int val = arr[i];
				
				int left = i+1;
				int right = n - 1;
				
				while(left < right) {
					int sum = val + arr[left] + arr[right];
					
					if(sum == 0) {
						if(arr[left] == arr[right]) {
							res += (right - left + 1) * (right - left) / 2;
							break;
						}
						
						int l = arr[left];
						int lcnt = 0;
						while(true) {
							if(l != arr[left]) break;
							
							lcnt++;
							left++;
						}
						
						int r = arr[right];
						int rcnt = 0;
						while(true) {
							if(r != arr[right])break;
							rcnt++;
							right--;
						}
						
						res += rcnt * lcnt;
					}
					else if(sum > 0) {
						right--;
					}else {
						left++;
					}
				}
			}
			
			System.out.println(res);
			
	}	
}

