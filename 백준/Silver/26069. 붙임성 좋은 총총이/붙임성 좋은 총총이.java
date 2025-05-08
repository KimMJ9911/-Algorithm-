import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final String chong = "ChongChong";
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        Map<String , Integer> convert_chong = new HashMap<>();
        convert_chong.put(chong , 1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            String init = st.nextToken();
            String end = st.nextToken();
            if (convert_chong.containsKey(init) || convert_chong.containsKey(end)) {
                if (!convert_chong.containsKey(init)) convert_chong.put(init , 1);
                else if (!convert_chong.containsKey(end)) convert_chong.put(end , 1);
                else cnt--;
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        br.close();
        bw.close();
    }
}