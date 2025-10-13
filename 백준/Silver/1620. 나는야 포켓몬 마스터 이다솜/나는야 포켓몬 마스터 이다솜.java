import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken()) , m = Integer.parseInt(st.nextToken());
        Map<String , String> arr_1 = new HashMap<>();
        Map<String , String> arr_2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String poke = br.readLine();
            arr_1.put(String.valueOf(i) , poke);
            arr_2.put(poke , String.valueOf(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String next = br.readLine();
            if (arr_1.containsKey(next)) sb.append(arr_1.get(next));
            else if (arr_2.containsKey(next)) sb.append(arr_2.get(next));

            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}