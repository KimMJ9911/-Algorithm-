import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        StringBuilder sb = new StringBuilder();
        int num_1 = Integer.parseInt(String.valueOf(sb.append(st.nextToken()).reverse()));
        sb = new StringBuilder();
        int num_2 = Integer.parseInt(String.valueOf(sb.append(st.nextToken()).reverse()));

        if (num_2 > num_1) bw.write(String.valueOf(num_2));
        else if (num_2 < num_1) bw.write(String.valueOf(num_1));
        bw.flush();
        br.close();
        bw.close();
    }
}