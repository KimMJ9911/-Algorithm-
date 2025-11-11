import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int SIZE = 123456;
    static boolean[] flag;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //최대 n 까지의 수 중 소수만을 걸러내기 위한 flag 배열
        flag = new boolean[SIZE * 2 + 1];
        arr = new int[SIZE * 2 + 1];

        isPrime();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int cnt = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (flag[i]) {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void isPrime() {
        Arrays.fill(flag , true);
        flag[0] = false;
        flag[1] = false;

        for (int i = 2; i * i <= SIZE * 2; i++) {
            if (flag[i]) {
                for (int j = i * i; j <= SIZE * 2; j += i) {
                    flag[j] = false;
                }
            }

        }
    }
}