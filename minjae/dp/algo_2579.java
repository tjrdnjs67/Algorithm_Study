import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_2579 {
    static int size;
    static int[] steps = new int[301];
    static int[] result = new int[301];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine().trim());
        steps = new int[301];
        for (int i = 0; i < size; i++) {
            steps[i] = Integer.parseInt(br.readLine().trim());
        }

        result[0] = steps[0];
        result[1] = Math.max(steps[0] + steps[1], steps[1]);
        result[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);

        for (int i = 3; i < size; i++) {
            result[i] = Math.max(result[i - 2] + steps[i], steps[i] + steps[i - 1] + result[i - 3]);
        }
        System.out.println(result[size - 1]);
    }
}
