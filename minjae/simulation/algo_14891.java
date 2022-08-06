import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class algo_14891 {
    static Gear[] gears;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new Gear[4];
        for (int i = 0; i < 4; i++) {
            gears[i] = new Gear(Arrays.stream(br.readLine().trim().split("")).mapToInt(Integer::parseInt).toArray());
        }
        int caseCount = Integer.parseInt(br.readLine().trim());
        int[] cases = new int[2];
        for (int i = 0; i < caseCount; i++) {
            cases = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            spinOtherGear(cases[0] - 1, cases[1]);
        }

        System.out.println(getResult());
    }

    static int getResult() {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += gears[i].getTop() * Math.pow(2, i);
        }
        return result;
    }

    static void spinOtherGear(int nowSpin, int dir) {
        boolean[] spinArr = new boolean[4];
        spinArr[nowSpin] = true;
        int[] dirArr = new int[4];
        for (int i = 0; i < 4; i++) {
            if (i % 2 == nowSpin % 2) {
                dirArr[i] = dir;
            } else {
                dirArr[i] = -dir;
            }
        }
        switch (nowSpin) {
            case 0:
                if (isSpinGearRight(0)) {
                    spinArr[1] = true;
                    if (isSpinGearRight(1)) {
                        spinArr[2] = true;
                        if (isSpinGearRight(2)) {
                            spinArr[3] = true;
                        }
                    }
                }
                break;
            case 1:
                if (isSpinGearLeft(1)) {
                    spinArr[0] = true;
                }
                if (isSpinGearRight(1)) {
                    spinArr[2] = true;
                    if (isSpinGearRight(2)) {
                        spinArr[3] = true;
                    }
                }
                break;
            case 2:
                if (isSpinGearLeft(2)) {
                    spinArr[1] = true;
                    if (isSpinGearLeft(1)) {
                        spinArr[0] = true;
                    }
                }
                if (isSpinGearRight(2)) {
                    spinArr[3] = true;
                }
                break;
            case 3:
                if (isSpinGearLeft(3)) {
                    spinArr[2] = true;
                    if (isSpinGearLeft(2)) {
                        spinArr[1] = true;
                        if (isSpinGearLeft(1)) {
                            spinArr[0] = true;
                        }
                    }
                }
                break;
        }
        for (int i = 0; i < 4; i++) {
            if (spinArr[i]) {
                gears[i].spin(dirArr[i]);
            }
        }
    }

    static boolean isSpinGearLeft(int now) {
        return now <= 0 || gears[now - 1].getRight() != gears[now].getLeft();
    }

    static boolean isSpinGearRight(int now) {
        return now >= 3 || gears[now + 1].getLeft() != gears[now].getRight();
    }

    //기어에 대한 정보들
    static class Gear {
        private int locationTop;
        private int locationLeft;
        private int locationRight;
        int[] gearShape = new int[8];

        public Gear(int[] gearShape) {
            this.locationTop = 0;
            this.locationRight = 2;
            this.locationLeft = 6;
            this.gearShape = gearShape;
        }

        public int getTop() {
            return gearShape[locationTop];
        }

        public int getLeft() {
            return gearShape[locationLeft];
        }

        public int getRight() {
            return gearShape[locationRight];
        }

        public void spin(int dir) {
            int newTop = locationTop - dir;
            int newLeft = locationLeft - dir;
            int newRight = locationRight - dir;
            //move top
            if (newTop < 0) {
                locationTop = 7;
            } else {
                locationTop = newTop % 8;
            }
            //move left
            if (newLeft < 0) {
                locationLeft = 7;
            } else {
                locationLeft = newLeft % 8;
            }
            //move right
            if (newRight < 0) {
                locationRight = 7;
            } else {
                locationRight = newRight % 8;
            }
        }
    }
}