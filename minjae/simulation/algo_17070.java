import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_17070 {
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Pipe pipe = new Pipe();

        dfs(pipe);

        System.out.println(result);
    }

    static void dfs(Pipe pipe) {
        if (Arrays.equals(pipe.end, new int[]{map.length - 1, map.length - 1})) {
            result += 1;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (pipe.canMove(map.length)[i]) {
                dfs(pipe.move(i));
            }
        }
    }

    static class Pipe {
        int[] start;
        int[] end;
        /**
         * 0 : 가로, 1 : 대각선, 2 : 세로
         */
        int deg;

        public Pipe() {
            this.start = new int[]{0, 0};
            this.end = new int[]{0, 1};
            this.deg = 0;
        }

        public Pipe(int[] start, int[] end, int deg) {
            this.start = start;
            this.end = end;
            this.deg = deg;
        }

        Pipe move(int deg) {
            int[] tmpStart = new int[2];
            int[] tmpEnd = new int[2];
            tmpStart = end.clone();
            switch (deg) {
                case 0:
                    tmpEnd = new int[]{end[0], end[1] + 1};
                    break;
                case 1:
                    tmpEnd = new int[]{end[0] + 1, end[1] + 1};
                    break;
                case 2:
                    tmpEnd = new int[]{end[0] + 1, end[1]};
                    break;
            }
            return new Pipe(tmpStart, tmpEnd, deg);
        }

        boolean[] canMove(int N) {
            boolean[] result = new boolean[3];
            int y = end[0];
            int x = end[1];
            switch (deg) {
                //내가 가로일 때
                case 0:
                    //가로
                    if (!isOver(y, x + 1, N) && map[y][x + 1] == 0)
                        result[0] = true;
                    //대각
                    if (!isOver(y + 1, x + 1, N) && map[y + 1][x] == 0 && map[y][x + 1] == 0 && map[y + 1][x + 1] == 0)
                        result[1] = true;
                    break;
                //내가 대각선 일때
                case 1:
                    //가로
                    if (!isOver(y, x + 1, N) && map[y][x + 1] == 0)
                        result[0] = true;
                    //세로
                    if (!isOver(y + 1, x, N) && map[y + 1][x] == 0)
                        result[2] = true;
                    //대각
                    if (!isOver(y + 1, x + 1, N) && map[y + 1][x] == 0 && map[y][x + 1] == 0 && map[y + 1][x + 1] == 0)
                        result[1] = true;
                    break;
                //내가 세로일 때
                case 2:
                    //세로
                    if (!isOver(y + 1, x, N) && map[y + 1][x] == 0)
                        result[2] = true;
                    //대각
                    if (!isOver(y + 1, x + 1, N) && map[y + 1][x] == 0 && map[y][x + 1] == 0 && map[y + 1][x + 1] == 0)
                        result[1] = true;
                    break;
            }
            return result;
        }

        boolean isOver(int y, int x, int N) {
            return y < 0 || y >= N || x < 0 || x >= N;
        }
    }
}
