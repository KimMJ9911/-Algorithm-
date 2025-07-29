import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int floor = 0;
            for (int j = 1; j <= n; j++) {
                floor += j;
                if (floor == p) floor --;
            }

            bw.write(floor + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}