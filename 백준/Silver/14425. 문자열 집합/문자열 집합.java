import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> word = new HashSet<>();
        String[] comp = new String[m];
        for (int i = 0; i < n; i++) {
            word.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (word.contains(br.readLine())) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}