import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//4
//1 3
//2 5
//3 5
//6 7


public class Main{
	

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int n = Integer.parseInt(br.readLine());
	        int[][] pos = new int[n][2];
	        
        for (int i = 0; i < n; i++) {
	            String line = br.readLine();
	            int p1 = Integer.parseInt(line.split(" ")[0]);
	            int p2 = Integer.parseInt(line.split(" ")[1]);
	            pos[i][0] = p1;
	            pos[i][1] = p2;
        }
		
		Arrays.sort(pos, (o1,o2) -> {
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			else {
				return o1[0] - o2[0];
			}
		});
			
		int s = pos[0][0];
		int e = pos[0][1];
		long res = e - s;
		
		for(int i = 1; i < n; i++) {	
			if(e >= pos[i][1] && s <= pos[i][0]) continue;
			
			if(pos[i][0] < e) {
				res += pos[i][1] - e;
			}else {
				res += pos[i][1] - pos[i][0];
			}
			
			s = pos[i][0];
			e = pos[i][1];
		}
		
		System.out.println(res);
	}
}
