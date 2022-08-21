import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_18808 {
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //input
        String[] input = br.readLine().trim().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        map = new int[N][M];

        Sticker[] stickers = new Sticker[K];
        for (int i = 0; i < K; i++) {
            input = br.readLine().trim().split(" ");
            int[][] tmp = new int[Integer.parseInt(input[0])][];
            for (int j = 0; j < Integer.parseInt(input[0]); j++) {
                tmp[j] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            stickers[i] = new Sticker(tmp);
        }

        //each sticker
        for (int i = 0; i < K; i++) {
            each:
            //each spin
            for (int j = 0; j < 4; j++) {
                //each location
                for (int y = 0; y < map.length - stickers[i].shape.length + 1; y++) {
                    for (int x = 0; x < map[0].length - stickers[i].shape[0].length + 1; x++) {
                        if (canPut(new int[]{y, x}, stickers[i])) {
                            addSticker(new int[]{y, x}, stickers[i]);
                            break each;
                        }
                    }
                }
                stickers[i].spin();
            }
        }
        System.out.println(getResult());
    }

    static int getResult() {
        int result = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    result += 1;
                }
            }
        }
        return result;
    }

    static void showMap() {
        System.out.println("<=========map==========>");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static void addSticker(int[] start, Sticker sticker) {
        int y = start[0];
        int x = start[1];
        for (int i = 0; i < sticker.N; i++) {
            for (int j = 0; j < sticker.M; j++) {
                if (map[y + i][x + j] == 0 && sticker.shape[i][j] == 1) {
                    map[y + i][x + j] = sticker.shape[i][j];
                }
            }
        }
    }

    static boolean canPut(int[] start, Sticker sticker) {
        int y = start[0];
        int x = start[1];
        for (int i = 0; i < sticker.N; i++) {
            for (int j = 0; j < sticker.M; j++) {
                if (map[y + i][x + j] == 1 && sticker.shape[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Sticker {
        int N;
        int M;
        int[][] shape;

        public Sticker(int[][] shape) {
            this.N = shape.length;
            this.M = shape[0].length;
            this.shape = shape;
        }

        void spin() {
            int[][] tmp = new int[M][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmp[j][i] = shape[N - 1 - i][j];
                }
            }
            N = tmp.length;
            M = tmp[0].length;
            shape = tmp.clone();
        }

        void show() {
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(shape[i]));
            }
            System.out.println();
        }
    }
}
