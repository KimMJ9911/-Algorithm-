import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        String rev_word = reverse_String(word);

        if (word.equals(rev_word)) bw.write(1 + "");
        else bw.write(0 + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static String reverse_String(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}