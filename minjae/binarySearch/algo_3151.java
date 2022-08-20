import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_3151 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] arrays = new int[N];
        String[] input = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            arrays[i] = Integer.parseInt(input[i]) * 10;
        }

        Arrays.sort(arrays);

        long result = 0;

        for (int i = 0; i < N - 2; i++) {
            if (arrays[i] > 0) break;
            for (int j = i + 1; j < N - 1; j++) {
                int find = -arrays[i] - arrays[j];
                int idxLeft = Arrays.binarySearch(arrays, j + 1, N, find - 1);
                int idxRight = Arrays.binarySearch(arrays, j + 1, N, find + 1);
                int range = Math.abs(idxRight - idxLeft);
//                if (range > 0) {
//                    System.out.println("=====================");
//                    System.out.printf("s1 : %d, s2 : %d\n", arrays[i], arrays[j]);
//                    System.out.printf("find : %d, range : %d\n", find, range);
//                }
                result += range;
            }
        }
        System.out.println(result);
    }
}
