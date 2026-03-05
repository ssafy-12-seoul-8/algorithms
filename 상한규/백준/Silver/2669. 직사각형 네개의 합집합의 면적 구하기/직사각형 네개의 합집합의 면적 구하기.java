import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] visited = new boolean[101][101];
        int minX = 101, minY = 101, maxX = 0, maxY = 0;
        int area = 0;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 < minX) minX = x1;
            if (y1 < minY) minY = y1;
            if (x2 > maxX) maxX = x2;
            if (y2 > maxY) maxY = y2;

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        area++;
                    }
                }
            }
        }

        System.out.println(area);
    }
}