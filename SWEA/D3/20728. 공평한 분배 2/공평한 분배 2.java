import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine() , " ");
            int[] pocket = new int[n];
            for (int j = 0; j < n; j++) {
                pocket[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(pocket);

            int div = Integer.MAX_VALUE;
            for (int j = k - 1; j < n; j++) {
                div = Math.min(div , pocket[j] - pocket[j - k + 1]);
            }

            bw.write("#" + i + " " + div + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}