import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	static int res;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,r,c,d,ori;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		for(int i=0; i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		arr[r][c]=2;
		move();
		print();
		System.out.println(res);

		

		
	}
	static void print_arr() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	static void print() {
		res=0;
		for(int i=1; i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				if(arr[i][j]==2)
					res +=1;
			}
		}
		
	}
	
	static void move() {
		while(true) {
			if((arr[r+1][c]==1 || arr[r+1][c]==2)&&
					(arr[r-1][c]==1 || arr[r-1][c]==2)&&
					(arr[r][c+1]==1 || arr[r][c+1]==2)&&
					(arr[r][c-1]==1 || arr[r][c-1]==2)) {
				
				
				
				if(d==0) {
					r+=1;
					if(arr[r][c]==1) return;
					arr[r][c]=2;
				}
				else if(d==1) {
					c-=1;
					if(arr[r][c]==1) return;
					arr[r][c]=2;
				}
				else if(d==2) {
					r-=1;
					if(arr[r][c]==1) return;
					arr[r][c]=2;
				}
				else if(d==3) {
					c+=1;
					if(arr[r][c]==1) return;
					arr[r][c]=2;
				}
			}
			else break;
		}	
		
		if(arr[r+1][c]==0 || arr[r][c-1]==0 || arr[r-1][c]==0 || arr[r][c+1]==0) {
		for(int i=0;i<4;i++) {
			if(d==0) {
				d=3;
				if(arr[r][c-1]==0) {
					c-=1;
					arr[r][c]=2;
				}
				break;
			}
			else if(d==3) {
				d=2;
				if(arr[r+1][c]==0) {
					r+=1;
					arr[r][c]=2;
				}
				break;
			}
			else if(d==2) {
				d=1;
				if(arr[r][c+1]==0) {
					c+=1;
					arr[r][c]=2;
				}
				break;
			}
			else if(d==1) {
				d=0;
				if(arr[r-1][c]==0) {
					r-=1;
					arr[r][c]=2;
				}
				break;
			}
		}
		}


		
		
		move();
		
		
		}	
	}
	

	

	
	
