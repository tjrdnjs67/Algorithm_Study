import java.util.Scanner;

public class Main {
	static int N, M, K, res = 0;
	static int[][] board;
	static int[][][] sticker;
	
	static int[][] rotate(int[][] c){
		int[][] res = new int[c[0].length][c.length];
		
		for(int i = 0; i <c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				res[j][c.length -i - 1] = c[i][j];
			}
		}
		
		return res;
	}
	
	
	static int[][] rotate(int[][] copy, int n) {
		
		for(int i = 0; i < n; i++) {
			copy = rotate(copy);
		}
		
		return copy;
	}
	
	static void print(int idx, int[][] bd) {
		if(idx == K) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(bd[i][j] == 1) sum++;
				}
			}
			res = Math.max(res, sum);
			return;
		}
		
		int[][] copy = new int[N][M];
		boolean tf = false;
		loop1:for(int k = 0; k < 4; k++) {
			int[][] r_sticker = rotate(sticker[idx], k);
			loop2:for(int i = 0; i < N; i++) {
				loop3:for(int j = 0; j < M; j++) {			
										
						if(i + r_sticker.length <= N && j + r_sticker[0].length <= M) {
							for(int row = i; row < i + r_sticker.length; row++) {
								for(int col = j; col < j + r_sticker[0].length; col++) {
									if(r_sticker[row-i][col-j] == 1 && bd[row][col] == 1) {
										continue loop3;
									}

								}
							}
							
							tf = true;
							
							for(int c = 0; c < N; c++) {
								System.arraycopy(bd[c], 0, copy[c], 0, M);
							}
							

							for(int row = 0; row < r_sticker.length; row++) {
								for(int col = 0; col < r_sticker[0].length; col++) {
									if(copy[row+i][col+j] == 1) {
										continue;
									}
									copy[row+i][col+j] =r_sticker[row][col];
								}
							}
							
	
							print(idx + 1, copy);
							break loop1;
					}//if			
				}// i
								
			}// j
		}// k
		if(tf == false)
			print(idx + 1, bd);	
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	K = sc.nextInt();
    	
    	board = new int[N][M];
    	sticker = new int[K][][];
    	
    	for(int i = 0; i < K; i++) {
    		int r = sc.nextInt();
    		int c = sc.nextInt();
    		sticker[i] = new int[r][c];
    		
    		for(int j = 0; j < r; j++) {
    			for(int k = 0; k < c; k++) {
    				sticker[i][j][k] = sc.nextInt();
    			}
    		}
    	}
    	
    	print(0,board);
    	
    	System.out.println(res);
    }   
}
