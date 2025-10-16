import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        //겹치는 것 상관없이 받을 문자열
        Set<String> arr = new HashSet<>();
        for (int i = 1; i <= word.length(); i++) {
            String ans = "";
            for (int j = 0; j < word.length() - i + 1; j++) {
                ans = word.substring(j , j + i);
                arr.add(ans);
            }
        }

        bw.write(String.valueOf(arr.size()));
        bw.flush();
        br.close();
        bw.close();
    }
}