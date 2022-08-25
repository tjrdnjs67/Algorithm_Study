import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_17136 {
    static int[][] map;
    static int[] paperCount;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];
        paperCount = new int[]{0, 5, 5, 5, 5, 5};

        for (int i = 0; i < 10; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        find();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void find() {
        int[] location = getPostLocation();
        if (location[0] == -1) {
            findResult();
            return;
        }

        int max = getMaxLen(location);
        for (int i = max; i > 0; i--) {
            if (paperCount[i] > 0) {
                putPaper(location, i, 0);
                paperCount[i] -= 1;

                find();

                putPaper(location, i, 1);
                paperCount[i] += 1;
            }
        }
    }

    static void findResult() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    return;
                }
            }
        }
        result = Math.min(result, (25 - Arrays.stream(paperCount).sum()));
    }

    static int[] getPostLocation() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int getMaxLen(int[] start) {
        for (int i = 5; i > 0; i--) {
            if (canPutIn(start, i)) return i;
        }
        return 0;
    }

    static void showMap() {
        System.out.println("each");
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static void putPaper(int[] start, int size, int status) {
        for (int i = start[0]; i < start[0] + size; i++) {
            for (int j = start[1]; j < start[1] + size; j++) {
                map[i][j] = status;
            }
        }
    }

    static boolean canPutIn(int[] start, int size) {
        for (int i = start[0]; i < start[0] + size; i++) {
            for (int j = start[1]; j < start[1] + size; j++) {
                if (i >= 10 || j >= 10 || map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
