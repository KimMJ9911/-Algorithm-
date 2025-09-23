import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] += Math.min(dp[i - 1][1] , dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0] , dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0] , dp[i - 1][1]);
        }

        int ans = Arrays.stream(dp[n]).min().getAsInt();

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}