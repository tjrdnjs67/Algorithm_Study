import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_1654 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");

        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] line = new int[K];

        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(line);

        long right = line[K - 1];
        long left = 1;
        long count = 0;
        long mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < K; i++) {
                count += line[i] / mid;
            }
            if (count >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
