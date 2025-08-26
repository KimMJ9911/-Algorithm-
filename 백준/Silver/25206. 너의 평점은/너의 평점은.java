import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static double div = 0 , all = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            String word = st.nextToken();
            double scholar = Double.parseDouble(st.nextToken());
            String score = st.nextToken();

            setVal(scholar , score);
        }
        double ans = all / div;
        String str_ans = String.format("%.6f%n" , ans);
        bw.write(str_ans);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void setVal(Double scholar, String score) {
        div += scholar;
        switch (score) {
            case "A+" :
                all += scholar * 4.5;
                break;
            case "A0":
                all += scholar * 4.0;
                break;
            case "B+":
                all += scholar * 3.5;
                break;
            case "B0":
                all += scholar * 3.0;
                break;
            case "C+":
                all += scholar * 2.5;
                break;
            case "C0":
                all += scholar * 2.0;
                break;
            case "D+":
                all += scholar * 1.5;
                break;
            case "D0":
                all += scholar * 1.0;
                break;
            case "P":
                div -= scholar;
                break;
            case "F":
                break;
        }
    }
}