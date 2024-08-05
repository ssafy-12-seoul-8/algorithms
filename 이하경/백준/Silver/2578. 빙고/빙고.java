import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo = new int[5][5];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] memo = new int[26][2]; // 빙고판에서 숫자가 써있는 위치 저장

        // 빙고판 숫자 입력
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                bingo[i][j] = num;
                memo[num] = new int[] { i, j };
            }
        }

        // 사회자가 숫자를 부른다
        all:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                int[] call = memo[num];
                bingo[call[0]][call[1]] = 0;
                if (isBingo()){
                    System.out.println(i * 5 + j + 1);
                    break all;
                }
            }
        }
    }

    public static boolean isBingo() {
        int cnt = 0;
        boolean lineIsBingo = true;

        for (int i = 0; i < 5; i++) {
            lineIsBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != 0) {
                    lineIsBingo = false;
                    break;
                }
            }
            if (lineIsBingo && ++cnt == 3){
                return true;
            }
        }

        for (int j = 0; j < 5; j++) {
            lineIsBingo = true;
            for (int i = 0; i < 5; i++) {
                if (bingo[i][j] != 0) {
                    lineIsBingo = false;
                    break;
                }
            }
            if (lineIsBingo && ++cnt == 3){
                return true;
            }
        }

        for (int i = 0; i < 5; i++) {
            lineIsBingo = true;
            if (bingo[i][i] != 0) {
                lineIsBingo = false;
                break;
            }
        }
        if (lineIsBingo && ++cnt == 3){
            return true;
        }

        for (int i = 0; i < 5; i++){
            lineIsBingo = true;
            if (bingo[i][4 - i] != 0){
                lineIsBingo = false;
                break;
            }
        }
        return lineIsBingo && ++cnt == 3;
    }
}
