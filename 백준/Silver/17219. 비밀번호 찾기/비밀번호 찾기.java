import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String , String> key = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            String site = st.nextToken();
            String password = st.nextToken();

            key.put(site , password);
        }

        for (int i = 0; i < m; i++) {
            sb.append(key.get(br.readLine())).append("\n");
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}