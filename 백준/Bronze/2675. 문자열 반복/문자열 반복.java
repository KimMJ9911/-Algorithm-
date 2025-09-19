import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int rep = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            repeat(rep , word);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void repeat(int rep, String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < rep; j++) {
                sb.append(word.charAt(i));
            }
        }
        sb.append("\n");
    }
}