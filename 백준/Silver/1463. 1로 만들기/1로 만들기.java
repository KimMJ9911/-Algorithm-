import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];

        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            //새로운 값 갱신을 위해 cnt에 dp값 저장
            //이전 값에 저장된 dp 값  + 1
            int cnt = dp[i - 1] + 1;
            //3으로 나뉘어지는 경우 -> 3으로 나눈 값의 dp 값 + 1
            if (i % 3 == 0) cnt = Math.min(dp[i / 3] + 1 , cnt);
            //2으로 나뉘어지는 경우 -> 2으로 나눈 값의 dp 값 + 1
            if (i % 2 == 0) cnt = Math.min(dp[i / 2] + 1 , cnt);

            //새로운 값 dp에 저장
            dp[i] = cnt;
        }

        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}