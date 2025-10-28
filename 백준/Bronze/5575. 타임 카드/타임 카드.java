import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int ih = Integer.parseInt(st.nextToken());
            int im = Integer.parseInt(st.nextToken());
            int is = Integer.parseInt(st.nextToken());

            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());

            int ah = eh - ih , am = em - im , as = es - is;

            while (ah < 0 || am < 0 || as < 0) {
                if (ah < 0) ah += 24;

                if (am < 0) {
                    ah--;
                    am += 60;
                }

                if (as < 0) {
                    am--;
                    as += 60;
                }
            }



            sb.append(ah).append(" ")
                    .append(am).append(" ")
                    .append(as).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}