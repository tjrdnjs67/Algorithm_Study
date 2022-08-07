//package algo_0809;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class algo_9095 {

    //static List<List<Integer>> founds = new ArrayList<>();
    static List<Integer> find = new ArrayList<>();
    static int count;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int num = sc.nextInt();
            count = 0;
            findSum(num);
            System.out.println(count);
            //System.out.println(founds.size());
        }
    }

    static void findSum(int num) {
        if (num == 0) {
            count += 1;
            //founds.add(find);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (num - i >= 0) {
                find.add(i);
                findSum(num - i);
                find = new ArrayList<>();
            }
        }
    }
}
