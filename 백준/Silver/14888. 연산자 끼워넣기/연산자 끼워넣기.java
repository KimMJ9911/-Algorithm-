import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
    static int[] operator;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        operator = new int[4];
        arr = new int[n];

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        set_calculate(arr[0] , 1);

        bw.write(max + "\n" + min);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void set_calculate(int init , int depth) {
        if (depth == n) {
            max = Math.max(max , init);
            min = Math.min(min , init);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        set_calculate(init + arr[depth] , depth + 1);
                        break;
                    case 1:
                        set_calculate(init - arr[depth] , depth + 1);
                        break;
                    case 2:
                        set_calculate(init * arr[depth] , depth + 1);
                        break;
                    case 3:
                        set_calculate(init / arr[depth] , depth + 1);
                        break;
                }
                operator[i]++;
            }

        }
    }
}