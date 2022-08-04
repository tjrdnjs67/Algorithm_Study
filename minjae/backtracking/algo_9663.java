import java.util.Arrays;
import java.util.Scanner;

public class algo_9663 {

    static boolean[] possibleVer;
    static boolean[] possibleDaigonal;
    static boolean[] possibleDaigonal2;
    static int[][] map;
    static int count;
    static int size;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        possibleVer = new boolean[size];
        possibleDaigonal = new boolean[size * 2 - 1];
        possibleDaigonal2 = new boolean[size * 2 - 1];
        map = new int[size][size];
        count = 0;
        findLocation(0);
        System.out.println(count);
    }

    static void findLocation(int depth) {
        if (depth == map.length) {
//            System.out.println("----map---");
//            for (int[] line : map) {
//                System.out.println(Arrays.toString(line));
//            }
            count += 1;
            return;
        }
        //show();
        //각 줄에 대한 행동 실행
        for (int i = 0; i < map.length; i++) {
            if (!possibleVer[i] && !possibleDaigonal[depth + i] && !possibleDaigonal2[depth - i + size - 1]) {
                map[depth][i] = 1;
                possibleVer[i] = true;
                possibleDaigonal[depth + i] = true;
                possibleDaigonal2[depth - i + size - 1] = true;
                findLocation(depth + 1);
                map[depth][i] = 0;
                possibleVer[i] = false;
                possibleDaigonal[depth + i] = false;
                possibleDaigonal2[depth - i + size - 1] = false;
            }
        }
    }

    static void show() {
        System.out.println("----map---");
        for (int[] line : map) {
            System.out.println(Arrays.toString(line));
        }
    }
}
