import java.util.Scanner;

public class algo_11726 {
    static long[] result = new long[1001];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        long result = findResult(find) % 10007;
        System.out.println(result);

    }

    static long findResult(int num) {
        if (num < 3) {
            return result[num];
        }
        if (result[num] == 0) {
            result[num] = (findResult(num - 1) + findResult(num - 2)) % 10007;
        }
        return result[num];
    }
}
