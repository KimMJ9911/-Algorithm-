import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        int val = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (values[i] == val) cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        br.close();
        bw.close();
    }
}