import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pQueue =
                new PriorityQueue<>((o1 , o2) -> {
                    int abs_o1 = Math.abs(o1);
                    int abs_o2 = Math.abs(o2);
                    if (abs_o1 == abs_o2) return o1 - o2;
                    else return abs_o1 - abs_o2;
                });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                if (pQueue.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(pQueue.poll()).append("\n");
            } else pQueue.add(val);
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
}