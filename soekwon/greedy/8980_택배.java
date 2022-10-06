import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


class Data implements Comparable<Data>{
	int from, to, val;

	public Data(int from, int to, int val) {
		this.from = from;
		this.to = to;
		this.val = val;
	}

	@Override
	public int compareTo(Data o) {
		return this.to == o.to? this.from - o.from : this.to - o.to;
	}
	
	
}


public class Main{
	
	static int N, W; // 마을의 수 N, 택배로 실을 수 있는 최대 무게 W
	static int[] towns; // 각 마을에서의 트럭 잔여용량
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		towns = new int[N];
		
		int c = Integer.parseInt(br.readLine());

		ArrayList<Data> list = new ArrayList<>();
		
		for(int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			list.add(new Data(from, to, val));
		}
		
		
		Collections.sort(list);
		Arrays.fill(towns, W);
		
		int res = 0;
		
		for(int i = 0, size = list.size(); i < size; i++) {
			Data data = list.get(i);
			
			int min = Integer.MAX_VALUE;
			for(int j = data.from; j < data.to; j++) {
				min = Math.min(towns[j], min);
			}
			
			if(min == 0) continue;
			
			data.val = Math.min(min, data.val);
			res += data.val;
			for(int j = data.from; j < data.to; j++) {
				towns[j] -= data.val;
			}

			
		}
		
		
		System.out.println(res);
	}

}



