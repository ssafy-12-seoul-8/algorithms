public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();

        // n, m
        int n = reader.nextInt();
        int m = reader.nextInt();

        // n numbers & 구간 합 배열 생성
        int[] sum = new int[n + 2];

        sum[0] = 0;

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + reader.nextInt();
        }

        // 구간 합 출력
        for (int i = 0; i < m; i++) {
             int lowerBound = reader.nextInt() - 1;
             int upperBound = reader.nextInt();

             System.out.println(sum[upperBound] - sum[lowerBound]);
        }
    }
}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    int nextInt() throws Exception {
        int n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32); //{ if (size < 0) return -1; }
        if (c == 45) { c = read(); isMinus = true; }
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }
}
