import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        int[] arrs = new int[N + 1];
        arrs[0] = 0;
        input = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            arrs[i + 1] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < N + 1; i++) {
            arrs[i] += arrs[i - 1];
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (start < N) {
//            System.out.printf("sum : %d, len : %d\n", arrs[end] - arrs[start], end - start);
            if (end == N && arrs[end] - arrs[start] < S) {
                break;
            } else if (arrs[end] - arrs[start] < S) {
                end += 1;
            } else {
                min = Math.min(min, end - start);
                start += 1;
            }
        }

        min = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(min);
    }
}
