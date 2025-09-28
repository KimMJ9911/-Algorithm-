import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int MAX = Integer.MIN_VALUE;
        int val , idx_x = 0 , idx_y = 0;

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 1; j <= 9; j++) {
                val = Integer.parseInt(st.nextToken());
                if (MAX < val) {
                    MAX = val;
                    idx_x = i; idx_y = j;
                }
            }
        }

        bw.write(MAX + "\n" + idx_x + " " + idx_y);
        bw.flush();
        br.close();
        bw.close();
    }
}