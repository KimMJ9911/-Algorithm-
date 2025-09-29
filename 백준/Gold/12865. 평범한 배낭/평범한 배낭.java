import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];

        int[] value = new int[n + 1];
        int[] weight = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        //물건 하나씩 지정
        for (int i = 1; i <= n; i++) {
            //최대 무게부터 햔재 무게까지
            for (int j = k; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j] , dp[j - weight[i]] + value[i]);
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        br.close();
        bw.close();
    }
}