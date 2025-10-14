import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String , Integer> list = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list.put(br.readLine() , 0);
        }

        int cnt = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (list.containsKey(word)) {
                cnt++;
                ans.add(word);
            }
        }

        Collections.sort(ans);

        bw.write(cnt + "\n");
        for (String a : ans) {
            bw.write(a + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}