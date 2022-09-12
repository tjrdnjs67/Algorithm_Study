import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main{

	static int N, res = 0;
	static int[] order = new int[9];
	static boolean[] base;
	static int[][] predicts;
	
	static void simulataion() {
		
		int sum = 0;
		int next_hitter = 0;
		for(int i = 0; i < N; i++) {
			base = new boolean[3];
			int samjin = 0;
			while(samjin < 3) {
				if(predicts[i][order[next_hitter]] == 0) {
					samjin++;
				}
				else if(predicts[i][order[next_hitter]] == 1) {
					if(base[2]) { 
						sum += 1;
						base[2] = false;
					}
					
					for(int j = 2; j >= 1; j--) {
						base[j] = base[j-1];
						base[j-1] = false;
					}
					
					base[0] = true;
				}
				else if(predicts[i][order[next_hitter]] == 2) {
					for(int j = 2; j >= 1; j--) {
						if(base[j]) {
							sum += 1;
							base[j] = false;
						}
					}
					
					if(base[0]) {
						base[2] = true;
						base[0] = false;
					}
					
					base[1] = true;
				}
				else if(predicts[i][order[next_hitter]] == 3) {
					for(int j = 2; j >= 0; j--) {
						if(base[j]) {
							sum += 1;
							base[j] = false;
						}
					}
					
					base[2] = true;
				}
				else {
					for(int j = 2; j >= 0; j--) {
						if(base[j]) {
							sum += 1;
							base[j] = false;
						}
					}
					
					sum += 1;
				}
				
				next_hitter = (next_hitter + 1) % 9;
			}
		}

		
		res = Math.max(res, sum);
	}
	
	static void perm(int idx, int flag) {
		if(idx == 9) {
			simulataion();
			return;
		}
		
		if(idx == 3) {
			perm(idx+1, flag);
			return;
		}
		
		for(int i = 1; i < 9; i++) {
			if((flag & 1 << i)!= 0) continue;
			
			order[idx] = i;
			perm(idx + 1, flag | 1 << i);
		}
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	predicts = new int[N][9];
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < 9; j++) {
    			predicts[i][j] = sc.nextInt(); 
    		}
    	}
    	
    	order[3] = 0;
    	perm(0,0);
    	
    	System.out.println(res);
    }
}

