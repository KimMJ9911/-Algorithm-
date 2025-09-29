import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        //무게에 따른 가중치를 담기 위하 최대 무개만큼의 크기로 설정한다.
        int[] dp = new int[k + 1];
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
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