import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer , Integer> card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        card = new HashMap<>();
        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (card.containsKey(next)) card.put(next , card.get(next) + 1);
            else card.put(next , 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int next = Integer.parseInt(st.nextToken());
            sb.append(card.getOrDefault(next , 0)).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}