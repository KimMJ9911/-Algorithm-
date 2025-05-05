import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();

        int[] piece = {1 , 1 , 2 , 2 , 2 , 8};
        for (int i = 0; i < 6; i++) {
            int n = piece[i] - Integer.parseInt(st.nextToken());
            sb.append(n).append(" ");
        }

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();

    }
}