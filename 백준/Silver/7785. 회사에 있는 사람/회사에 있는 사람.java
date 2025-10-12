import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<String , String> arr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            String name = st.nextToken();
            String status = st.nextToken();
            arr.put(name , status);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String , String> entry : arr.entrySet()) {
            if ("enter".equals(entry.getValue())) ans.add(entry.getKey());
        }

        Collections.sort(ans);
        Collections.reverse(ans);

        for (String an : ans) {
            bw.write(an + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}