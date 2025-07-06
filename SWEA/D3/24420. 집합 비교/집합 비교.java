import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static Set<Integer> containerA , containerB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int list_f = Integer.parseInt(st.nextToken());
            int list_s = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine() , " ");
            containerA = new HashSet<>();
            for (int j = 0; j < list_f; j++) {
                containerA.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine() , " ");
            containerB = new HashSet<>();
            for (int j = 0; j < list_s; j++) {
                containerB.add(Integer.parseInt(st.nextToken()));
            }

            bw.write(getFlag(containerA , containerB) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static String getFlag(Set<Integer> A , Set<Integer> B) {
        if (A.equals(B)) return "=";
        if (A.containsAll(B)) return ">";
        else if (B.containsAll(A)) return "<";
        else return "?";
    }
}
