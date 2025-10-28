import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        sb.append(Long.parseLong(st.nextToken()) +
                Long.parseLong(st.nextToken()) +
                Long.parseLong(st.nextToken()));


        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}