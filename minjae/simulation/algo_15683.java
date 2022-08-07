//package algo_0809;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class algo_15683 {

    static int[][] tmpMap;
    static boolean[][] canShow;
    static int col;
    static int row;
    static List<int[]> cameraDirs;
    static int[] find;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        int[][] map = new int[col][row];
        canShow = new boolean[col][row];

        for (int i = 0; i < col; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        List<Camera> cameras = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cameras.add(new Camera(map[i][j], new int[]{i, j}));
                }
            }
        }
        cameraDirs = new ArrayList<>();
        find = new int[cameras.size()];
        tmpMap = new int[col][row];
        getCameraDirs(0, cameras.size());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cameraDirs.size(); i++) {
            copyMap(tmpMap, map);
            for (int j = 0; j < cameras.size(); j++) {
                lookAround(cameras.get(j), cameraDirs.get(i)[j]);
            }
            //showMap(tmpMap);
            min = Math.min(min, getBlindSpot(tmpMap));
        }
        System.out.println(min);
    }

    static void copyMap(int[][] tmpMap, int[][] map) {
        for (int i = 0; i < col; i++) {
            tmpMap[i] = map[i].clone();
        }
    }

    static void showMap(int[][] map) {
        System.out.println("------------------");
        for (int[] line : map) {
            System.out.println(Arrays.toString(line));
        }
    }

    static void getCameraDirs(int depth, int size) {
        if (depth == size) {
            cameraDirs.add(find.clone());
            return;
        }
        for (int i = 0; i < 4; i++) {
            find[depth] = i;
            getCameraDirs(depth + 1, size);
        }
    }

    static int getBlindSpot(int[][] tmpMap) {
        int result = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (tmpMap[i][j] == 0) {
                    result += 1;
                }
            }
        }
        return result;
    }

    static void lookAround(Camera camera, int dir) {
        camera.spin(dir);
        int[] location = camera.location;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < Math.max(col, row); j++) {
                int y = location[0] + camera.locationRangeY[i] * j;
                int x = location[1] + camera.locationRangeX[i] * j;
                if (y < 0 || y >= col || x < 0 || x >= row) {
                    continue;
                }
                if (tmpMap[y][x] == 6) {
                    break;
                } else {
                    if (tmpMap[y][x] == 0) {
                        tmpMap[y][x] = -1;
                    }
                }
            }
        }

    }

    static class Camera {
        int type;
        //상하좌우
        int[] showRangeY;
        int[] showRangeX;
        int[] location;
        int[] locationRangeY = new int[4];
        int[] locationRangeX = new int[4];

        public Camera(int type, int[] location) {
            this.type = type;
            switch (type) {
                //우하좌상
                case 1:
                    this.showRangeY = new int[]{0, 0, 0, 0};
                    this.showRangeX = new int[]{1, 0, 0, 0};
                    break;
                case 2:
                    this.showRangeY = new int[]{0, 0, 0, 0};
                    this.showRangeX = new int[]{1, 0, -1, 0};
                    break;
                case 3:
                    this.showRangeY = new int[]{0, 0, 0, -1};
                    this.showRangeX = new int[]{1, 0, 0, 0};
                    break;
                case 4:
                    this.showRangeY = new int[]{0, 0, 0, -1};
                    this.showRangeX = new int[]{1, 0, -1, 0};
                    break;
                case 5:
                    this.showRangeY = new int[]{0, 1, 0, -1};
                    this.showRangeX = new int[]{1, 0, -1, 0};
                    break;
            }
            this.location = location;
        }

        public void spin(int dir) {
            //우하좌상
            int tmpX1 = showRangeX[0];
            int tmpY1 = showRangeY[1];
            int tmpX2 = showRangeX[2];
            int tmpY2 = showRangeY[3];
            switch (dir) {
                case 0:
                    locationRangeX[0] = tmpX1;
                    locationRangeY[1] = tmpY1;
                    locationRangeX[2] = tmpX2;
                    locationRangeY[3] = tmpY2;
                    break;
                case 1:
                    locationRangeX[0] = -tmpY2;
                    locationRangeY[1] = tmpX1;
                    locationRangeX[2] = -tmpY1;
                    locationRangeY[3] = tmpX2;
                    break;
                case 2:
                    locationRangeX[0] = -tmpX2;
                    locationRangeY[1] = -tmpY2;
                    locationRangeX[2] = -tmpX1;
                    locationRangeY[3] = -tmpY1;
                    break;
                case 3:
                    locationRangeX[0] = tmpY1;
                    locationRangeY[1] = -tmpX2;
                    locationRangeX[2] = tmpY2;
                    locationRangeY[3] = -tmpX1;
                    break;
            }
        }
    }
}
