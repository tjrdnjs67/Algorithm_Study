import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class algo_2573 {

    static int[][] map;
    static boolean[][] visited;
    static int[] size;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[size[0]][size[1]];
        int result = -1;
        int count = 0;

        while (count < 2) {
            result += 1;
            count = nextYear();
            if (count == 0) {
                if (isBlank()) {
                    result = 0;
                    break;
                }
            }
        }

        System.out.println(result);

        br.close();
    }

    static boolean isBlank() {
        int sum = 0;
        for (int[] line : map) {
            sum += Arrays.stream(line).sum();
        }
        return sum == 0;
    }

    static int nextYear() {
        int count = 0;
        visited = new boolean[size[0]][size[1]];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0 & !visited[i][j]) {
                    bfs(new int[]{i, j});
                    count += 1;
                }
            }
        }
        if (count < 2) {
            return 0;
        } else {
            return count;
        }
    }


    static void bfs(int[] location) {
        //상하좌우
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        Queue<int[]> que = new LinkedList<>();
        que.add(location);
        List<int[]> locations = new ArrayList<>();
        while (!que.isEmpty()) {
            int[] now = que.poll();
            visited[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (y < 0 | y >= map.length | x < 0 | x >= map[0].length) {
                    continue;
                }
                //녹지 않았고 방문 안 했으면 큐에 추가
                if (map[y][x] != 0 & !visited[y][x]) {
                    visited[y][x] = true;
                    que.add(new int[]{y, x});
                }
                if (map[y][x] == 0) {
                    if (map[now[0]][now[1]] > 1) {
                        map[now[0]][now[1]] -= 1;
                    } else {
                        locations.add(now.clone());
                    }
                }
            }
        }
        for (int[] melted : locations) {
            map[melted[0]][melted[1]] = 0;
        }
    }

    static void showMap() {
        System.out.println("----------------");
        for (int[] line : map) {
            System.out.println(Arrays.toString(line));
        }
    }

}
