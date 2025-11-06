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

        int all = 0;
        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(br.readLine());
            set.add(val);
            all += val;
        }

        if (all == 180) {
            if (set.size() == 1) sb.append("Equilateral");
            else if (set.size() == 2) sb.append("Isosceles");
            else sb.append("Scalene");
        } else sb.append("Error");

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}