import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_11501 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < testCase; t++) {
            int day = Integer.parseInt(br.readLine().trim());
            int[] each = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = each[day - 1];
            long result = 0;

            for (int i = day - 1; i >= 0; i--) {
                if (each[i] <= max) {
                    result += max - each[i];
                } else {
                    max = each[i];
                }
            }

            System.out.println(result);
        }

    }
}
