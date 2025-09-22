import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sentence = br.readLine();

        int cnt = 1;
        if (sentence.charAt(0) == ' ') cnt--;
        if (sentence.charAt(sentence.length() - 1) == ' ') cnt--;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}