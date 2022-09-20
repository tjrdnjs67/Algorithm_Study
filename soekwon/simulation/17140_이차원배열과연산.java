import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Data implements Comparable<Data>{
	int val, cnt;
	
	Data(int val, int cnt){
		this.val = val;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Data o) {
		
		if(this.cnt != o.cnt) {
			return this.cnt - o.cnt;
		}

		return this.val - o.val;
	}
}

public class Main {

	static int R, C, K;
	static int Clen, Rlen;
	static int[][] board = new int[3][3];
	
	static void calcC() {
		int num = 0;
		ArrayList<Data>[] lists = new ArrayList[Clen];
		
		for(int i = 0; i < Clen; i++) {
			lists[i] = new ArrayList<Data>();
		}
		
		for(int i = 0; i < Clen; i++) {
			int[] order = new int[101];
			int num2 = 0;
			for(int j = 0; j < Rlen; j++) {	
				if(board[j][i] != 0 && order[board[j][i]] == 0) {
					num2++;
				}
				
				order[board[j][i]]++;
			}
			
			
			for(int j = 1; j < 101; j++) {
				if(order[j] != 0)
					lists[i].add(new Data(j, order[j]));
				
			}			
			Collections.sort(lists[i]);
			
			num = Math.max(num, num2);
		}
		
		Rlen = num * 2;
		
		if(Rlen > 100) Rlen = 100;
		
		board = new int[Rlen][Clen];
		

		for(int i = 0; i < Clen; i++) {
			int idx = 0;
			for(int j = 0, size = lists[i].size(); j < size; j++) {
					if(idx >= 100) break;
					Data d = lists[i].get(j);
					board[idx++][i] = d.val;
					board[idx++][i] = d.cnt;
			}
		}
		
		
	}
	
	static void calcR() {
		int num = 0;
		ArrayList<Data>[] lists = new ArrayList[Rlen];
		
		for(int i = 0; i < Rlen; i++) {
			lists[i] = new ArrayList<Data>();
		}
		
		for(int i = 0; i < Rlen; i++) {
			int[] order = new int[101];
			int num2 = 0;
			for(int j = 0; j < Clen; j++) {
				
				if(board[i][j] != 0 && order[board[i][j]] == 0) {
					num2++;
				}
				
				order[board[i][j]]++;
			}
			
			
			for(int j = 1; j < 101; j++) {
				if(order[j] != 0)
					lists[i].add(new Data(j, order[j]));
				
			}			
			Collections.sort(lists[i]);
			
			num = Math.max(num, num2);
		}
		
		Clen = num * 2;
		
		if(Clen > 100) Clen = 100;
		
		board = new int[Rlen][Clen];
		

		for(int i = 0; i < Rlen; i++) {
			int idx = 0;
			for(int j = 0, size = lists[i].size(); j < size; j++) {
					if(idx >= 100) break;
					Data d = lists[i].get(j);
					board[i][idx++] = d.val;
					board[i][idx++] = d.cnt;
			}
		}
				
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt() - 1;
		C = sc.nextInt() - 1;
		K = sc.nextInt();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		Clen = 3;
		Rlen = 3;
		while(cnt <= 100) {
			
			if(Clen > C && Rlen > R && board[R][C] == K) {
				System.out.println(cnt);
				return;
			}
			
			
			if(Rlen >= Clen) {
				calcR();
			}else {
				calcC();
			}
				
			cnt++;
		}
		
		System.out.println(-1);
	}
	
}
