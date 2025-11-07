import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int val = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                val += Integer.parseInt(st.nextToken());
                arr[i][j] = val;
            }
        }

        for (int i = 0; i < m; i++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine() , " ");
            int x_1 = Integer.parseInt(st.nextToken());
            int y_1 = Integer.parseInt(st.nextToken());
            int x_2 = Integer.parseInt(st.nextToken());
            int y_2 = Integer.parseInt(st.nextToken());

            for (int j = x_1; j <= x_2; j++) {
                ans += arr[j][y_2] - arr[j][y_1 - 1];
            }
            sb.append(ans).append("\n");
        }

        
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}