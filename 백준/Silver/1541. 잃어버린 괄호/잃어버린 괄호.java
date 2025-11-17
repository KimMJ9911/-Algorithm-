import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> operator;
    static List<Integer> cal;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        cal = new ArrayList<>();
        operator = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '-') {

            if (line.charAt(i) == '-') {
                    cal.add(Integer.parseInt(line.substring(idx , i)));
                    idx = i + 1;
                    operator.add(String.valueOf(line.charAt(i)));
                }
            } else if(line.charAt(i) == '+') {
                cal.add(Integer.parseInt(line.substring(idx , i)));
                idx = i + 1;
                operator.add(String.valueOf(line.charAt(i)));
            } else if (i == line.length() - 1) {
                cal.add(Integer.parseInt(line.substring(idx)));
            }
        }

        int ans = 0;
        int mid = cal.get(cal.size() - 1);
        for (int i = cal.size() - 2; i >= 0; i--) {
            if (operator.get(i).equals("-")) {
                ans -= mid;
                mid = cal.get(i);
            } else mid += cal.get(i);
        }

        ans += mid;

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}