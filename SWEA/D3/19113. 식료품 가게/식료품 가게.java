import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine() , " ");

            Deque<Long> deque = new ArrayDeque<>();
            sb.append("#").append(i).append(" ");

            for (int j = 0; j < n * 2; j++) {
                long val = Long.parseLong(st.nextToken());
                if (deque.contains(val * 3 / 4)) {
                    sb.append(deque.pollFirst()).append(" ");
                } else deque.offer(val);
            }
            sb.append("\n");
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}