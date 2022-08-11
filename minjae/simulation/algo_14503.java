import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_14503 {

    static int col;
    static int row;
    static int[][] map;


    public static void main(String[] args) throws Exception {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        //입력 파트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[col][row];
        st = new StringTokenizer(br.readLine().trim(), " ");
        Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        for (int i = 0; i < col; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        clean(robot);
        System.out.println(countResult());
    }

    static int countResult() {
        int result = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (map[i][j] == -1) {
                    result += 1;
                }
            }
        }
        return result;
    }

    static void clean(Robot robot) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{robot.nowY, robot.nowX});
        while (!que.isEmpty()) {
            int[] now = que.poll();
            map[now[0]][now[1]] = -1;
            boolean allClean = true;
            for (int i = 0; i < 4; i++) {
                int y = now[0] + robot.dy[i];
                int x = now[1] + robot.dx[i];
                if (y >= 0 && y < col && x >= 0 && x < row) {
                    if (map[y][x] == 0) {
                        allClean = false;
                        que.add(new int[]{y, x});
                        robot.nowY = y;
                        robot.nowX = x;
                        robot.spin(i + 1);
                        break;
                    }
                }
            }
            if (allClean) {
                int backY = now[0] + robot.dy[1];
                int backX = now[1] + robot.dx[1];
                if (backY < 0 || backY >= col || backX < 0 || backX >= row || map[backY][backX] == 1) {
                    return;
                } else {
                    que.add(new int[]{backY, backX});
                    robot.nowY = backY;
                    robot.nowX = backX;
                }
            }
        }
    }

    static class Robot {
        int nowY;
        int nowX;
        int look;
        int[] dy;
        int[] dx;

        public Robot(int nowY, int nowX, int look) {
            this.nowX = nowX;
            this.nowY = nowY;
            this.look = look;
            changeLook(look);
        }

        void spin(int num) {
            if (this.look - num < 0) {
                this.look = 4 - num + this.look;
            } else {
                this.look = this.look - num;
            }
            changeLook(this.look);
        }

        void changeLook(int look) {
            //좌 하 우 상
            switch (look) {
                //좌 하 우 상
                case 0:
                    dy = new int[]{0, 1, 0, -1};
                    dx = new int[]{-1, 0, 1, 0};
                    break;
                //상 좌 하 우
                case 1:
                    dy = new int[]{-1, 0, 1, 0};
                    dx = new int[]{0, -1, 0, 1};
                    break;
                //우 상 좌 하
                case 2:
                    dy = new int[]{0, -1, 0, 1};
                    dx = new int[]{1, 0, -1, 0};
                    break;
                //하 우 상 좌
                case 3:
                    dy = new int[]{1, 0, -1, 0};
                    dx = new int[]{0, 1, 0, -1};
                    break;
            }
        }
    }
}
