import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] fish;
    static int[] dx = { 0, 1 };
    static int[] dy = { 1, 0 };

    static ArrayList<Integer> minIdxs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        fish = new int[n][n]; // 높이, 바닥 순서
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fish[0][i] = Integer.parseInt(st.nextToken());
        }

        // 물고기 수 차이 구하기
        int cnt = 0;
        while (haveToRun()) {
            arrange();
            cnt++;
        }
        System.out.println(cnt);
    }

    static void print() {
        for (int[] f : fish) {
            System.out.println(Arrays.toString(f));
        }
        System.out.println();
    }

    // 전체 정리 실행
    static void arrange() {
        addFish();
        pile1();
        moveFish();
        flatten();
        pile2();
        moveFish();
        flatten();
    }

    // 물고기 수 차이가 k 이하인지 확인, 최소인 인덱스들 저장
    static boolean haveToRun() {
        minIdxs = new ArrayList<>();
        int max = 1;
        int min = 10000;
        for (int i = 0; i < n; i++) {
            if (fish[0][i] == min) {
                minIdxs.add(i);
            } else if (fish[0][i] < min) {
                min = fish[0][i];
                minIdxs.clear();
                minIdxs.add(i);
            }
            max = Math.max(max, fish[0][i]);
        }
        return max - min > k;
    }

    // 물고기 수가 가장 적은 어항에 물고기 넣기
    static void addFish() {
        for (int i : minIdxs) {
            fish[0][i]++;
        }
    }

    // 어항 쌓기. start 반환
    static void pile1() {
        int start = 1;
        int w = 1; // 2개 이상 쌓여있는 어항의 크기
        int h = 1;

        while (n - start>= h) {
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    fish[1 + i][start + j] = fish[j][start - 1 - i];
                    fish[j][start - 1 - i] = 0;
                }
            }

            int tmpH = h;
            h = w + 1;
            w = tmpH;
            start += w;
        }
    }

    static void pile2() {
        for (int i = 0; i < n / 2; i++) {
            fish[1][n / 2 + i] = fish[0][n / 2 - 1 - i];
            fish[0][n / 2 - 1 - i] = 0;
        }

        int start = n - n / 4;
        for (int i = 0; i < n / 4; i++) {
            fish[2][start + i] = fish[1][start - 1 - i];
            fish[3][start + i] = fish[0][start - 1 - i];
            fish[1][start - 1 - i] = 0;
            fish[0][start - 1 - i] = 0;
        }
    }

    // 인접 어항의 물고기 수 차이가 fish/5 보다 크면 그만큼을 옮겨준다
    static void moveFish() {
        int[][] moveCnt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fish[j][i] == 0) { // 위로 올라가다가 비어있으면 옆줄로 이동
                    break;
                }

                for (int l = 0; l < 2; l++) {
                    int nx = j + dx[l];
                    int ny = i + dy[l];

                    if (nx < n && ny < n && fish[nx][ny] > 0) {
                        int d = Math.abs(fish[j][i] - fish[nx][ny]) / 5;
                        if (fish[j][i] > fish[nx][ny]) {
                            moveCnt[j][i] -= d;
                            moveCnt[nx][ny] += d;
                        } else {
                            moveCnt[j][i] += d;
                            moveCnt[nx][ny] -= d;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fish[j][i] == 0) {
                    break;
                }

                if (moveCnt[j][i] != 0) {
                    fish[j][i] += moveCnt[j][i];
                }
            }
        }
    }

    // 어항이 나오기 시작하는 가로인덱스 start
    static void flatten() {
        int idx = -1; // 넣을 배열의 인덱스
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fish[j][i] == 0) {
                    break;
                }
                int tmp = fish[j][i];
                fish[j][i] = 0;
                fish[0][++idx] = tmp;
            }
        }
    }
}
