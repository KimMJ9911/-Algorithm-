import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //아래부터 위까지 훑어서 올라가는 방식
        //n x n 배열에 저장하고 나머지 빈 구역은 0으로 채운다
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 1; j <= n; j++) {
                if (st.hasMoreTokens()) dp[i][j] = Integer.parseInt(st.nextToken());
                else dp[i][j] = 0;
            }
        }


        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < n; j++) {
                dp[i - 1][j] += Math.max(dp[i][j] , dp[i][j + 1]);
            }
        }
        
        int ans = Arrays.stream(dp[0]).max().getAsInt();
        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}