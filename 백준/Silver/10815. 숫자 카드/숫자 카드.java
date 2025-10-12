import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] own;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        own = new int[n];
        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            own[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] comp = new int[m];
        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < m; i++) {
            comp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(own);
        for (int i = 0; i < m; i++) {
            if (!isOwned(comp[i])) sb.append(1);
            else sb.append(0);
            sb.append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isOwned(int val) {
        boolean flag = true;
        int start = 0 , end = own.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (own[mid] < val) start = mid + 1;
            else if (own[mid] > val) end = mid - 1;
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}