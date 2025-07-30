import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] dp = new String[101];
        dp[1] = "impossible";
        dp[2] = "BA";
        dp[3] = "BBA";
        //dp[3] 부터는 무조건 끝이 BBA 임
        //즉, BBA 고정이고 앞에 나오는 애들은 BA , BBA 고정이라 그것만 처리해주면 됨
        for (int i = 4; i < 101; i++) {
            if (i % 3 == 1) dp[i] = "impossible";
            else if (i % 3 == 2) dp[i] = dp[i - 3] + "BBA";
            else  dp[i] = dp[i - 3] + "BBA";
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}