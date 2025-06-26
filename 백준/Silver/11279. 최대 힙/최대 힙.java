import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                if (pQueue.isEmpty()) sb.append(0);
                else sb.append(pQueue.poll());
                sb.append("\n");
            } else pQueue.add(k);
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}