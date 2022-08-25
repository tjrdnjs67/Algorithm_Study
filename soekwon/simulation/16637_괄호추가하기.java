import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static Deque<Integer> num = new LinkedList<Integer>();
	static Deque<Character> op = new LinkedList<Character>();
	
	static int N;
	static long res = Integer.MIN_VALUE;
	static String s;
	static int[] arr;
	
	
	static void calculate() {
		num.clear();
		op.clear();
		
		num.offerLast((int)(s.charAt(0) - '0'));
		int idx = 1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				op.offerLast(s.charAt(idx++));
				num.offerLast((int)(s.charAt(idx++) - '0'));								
			}else {
				char ch = s.charAt(idx++);
				int num1 = num.pollLast();
				int num2 = (int)(s.charAt(idx++) - '0');
				int hap = 0;
				if(ch == '+')
					hap = num1 + num2;
				if(ch == '-')
					hap = num1 - num2;
				if(ch == '*')
					hap = num1 * num2;
				
				num.offerLast(hap);
			}
		}
		
		
		long val = num.pollFirst();
		while(!num.isEmpty()) {
			char ch = op.pollFirst();
			long val2 = num.pollFirst();

			if(ch == '+')
				val += val2;
			if(ch == '-')
				val -= val2;
			if(ch == '*')
				val *= val2;			
		}
		
		res = Math.max(res, val);
	}
	
	static void dfs(int depth) {
		if(depth == N/2) {
			calculate();		
			return;
		}
		
		for(int i = 0; i< 2; i++) {
			if(depth != 0 && arr[depth-1] == 1 && i == 1) continue; 
			arr[depth] = i;
			dfs(depth+1);
		}
		
	}
	
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	s = sc.nextLine();
    	s = sc.nextLine();
    	arr = new int[N/2];
    	
    	if(N == 1) {
    		res = (int)(s.charAt(0) - '0');
    	}else {
        	dfs(0);
    	}

    	
    	System.out.println(res);
    }   
}

