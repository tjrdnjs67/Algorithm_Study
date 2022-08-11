import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_1931 {
    static List<int[]> meetings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetingSize = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < meetingSize; i++) {
            meetings.add(Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        Collections.sort(meetings, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int end = 0;
        int count = 0;
        for (int[] m : meetings) {
            if (m[0] >= end) {
                end = m[1];
                count += 1;
            }
        }
        System.out.println(count);
    }
}
