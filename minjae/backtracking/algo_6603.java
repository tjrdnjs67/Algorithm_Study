import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class algo_6603 {

    static int size;
    static int[] find;
    static int[] list;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            size = sc.nextInt();
            if (size == 0) {
                break;
            }
            list = new int[size];
            find = new int[6];
            for (int i = 0; i < size; i++) {
                list[i] = sc.nextInt();
            }

            lotto(0, 0);
            System.out.println();
        }
    }

    static void lotto(int depth, int start) {
        if (depth == 6) {
            show();
            return;
        }
        for (int i = start; i < size; i++) {
            find[depth] = list[i];
            lotto(depth + 1, i + 1);
        }
    }

    static void show() {
        for (int i : find) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
