import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
    static int[] operator , nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operator = new int[4];

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        DFS(nums[0] , 1);

        bw.write(max + "\n" + min);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void DFS(int init, int k) {
        if (k == n) {
            max = Math.max(max , init);
            min = Math.min(min , init);
            return;
        }

        //연산자를 이용해 백트래킹 설정
        //각 연산자가 하나씩 연산되는 경우 뒤로 돌아갈 재귀를 한 연산마다 설정
        //이 연산이 종료된 후 다시 operator[k]++ 로 복귀
        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        DFS(init + nums[k] , k + 1);
                        break;
                    case 1:
                        DFS(init - nums[k] , k + 1);
                        break;
                    case 2:
                        DFS(init * nums[k] , k + 1);
                        break;
                    case 3:
                        DFS(init / nums[k] , k + 1);
                }
                //재귀가 종료되면 다시 roll back
                operator[i]++;
            }
        }
    }
}