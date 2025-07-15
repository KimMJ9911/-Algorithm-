import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int MIN = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= 3; j++) {
                int min = Integer.MAX_VALUE;
                //아래에서 선택한 수 중 작은 수를 구해 더해야 한다.
                for (int k = 1; k <= 3; k++) {
                    if (k != j) {
                        if (min > dp[i + 1][k]) min = dp[i + 1][k];
                    }
                }
                dp[i][j] += min;
            }
        }

        for (int i = 1; i <= 3; i++) {
            MIN = Math.min(MIN , dp[1][i]);
        }
        bw.write(MIN + "");
        bw.flush();
        br.close();
        bw.close();
    }
}