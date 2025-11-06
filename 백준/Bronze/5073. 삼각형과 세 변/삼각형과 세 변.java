import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();


        while (true) {
            int all = 0;
            int MAX = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine() , " ");
            for (int i = 0; i < 3; i++) {
                int val = Integer.parseInt(st.nextToken());
                set.add(val);
                all += val;
                MAX = Math.max(MAX , val);
            }

            if (all == 0) break;

            if (MAX >= all - MAX) sb.append("Invalid").append("\n");
            else {
                if (set.size() == 3) sb.append("Scalene").append("\n");
                else if (set.size() == 2) sb.append("Isosceles").append("\n");
                else sb.append("Equilateral").append("\n");
            }

            set.clear();
        }


        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}