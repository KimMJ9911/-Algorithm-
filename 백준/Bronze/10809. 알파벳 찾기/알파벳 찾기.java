import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabets = new int[26];
        Arrays.fill(alphabets , -1);

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (alphabets[idx] == -1) alphabets[idx] = i;
        }

        for (int alphabet : alphabets) {
            bw.write(alphabet + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}