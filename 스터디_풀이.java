/* 1520
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static int[][] table , visit;
    static int[] mx = {1 , -1 , 0 , 0};     //상하좌우
    static int[] my = {0 , 0 , 1 , -1};     //상하좌우
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }

        bw.write(DFS(0 , 0) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static int DFS(int x , int y) {
        //둘 다 종착점에 도착하는 경우
        if (x == m - 1 && y == n - 1) return 1;
        //순회 전 시작되는 구역의 값이 -1이 아닌 경우
        if (visit[y][x] != -1) return visit[y][x];

        visit[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];
            if ((nx >= 0 && ny >= 0 && nx < m && ny < n) && table[ny][nx] < table[y][x]) {
                visit[y][x] += DFS(nx , ny);
            }
        }

        return visit[y][x];
    }
}
 */

/* 1931
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] time_table = new int[n][2];

        //시작 시간과 종료 시간을 담은 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            time_table[i][0] = Integer.parseInt(st.nextToken());
            time_table[i][1] = Integer.parseInt(st.nextToken());
        }

        //끝나는 시간을 기준으로 배열을 정렬하가
        Arrays.sort(time_table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });


        int prv_time_set = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (prv_time_set <= time_table[i][0]) {
                prv_time_set = time_table[i][1];
                ans++;
            }
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
 */

/* 1018
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static String[] chess_Board;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chess_Board = new String[n];
        for (int i = 0; i < n; i++) {
            chess_Board[i] = br.readLine();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                ans = Math.min(check_chess_Board(i , j) , ans);
            }
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static int check_chess_Board(int x , int y) {
        String start_board_1 = "WBWBWBWB";
        String start_board_2 = "BWBWBWBW";
        int ans = 0;

        int ans_W = 0;
        int ans_B = 0;
        for (int i = x; i < x + 8; i++) {

            for (int j = y; j < y + 8; j++) {
                if (chess_Board[i].charAt(j) != start_board_1.charAt(j - y)) {
                    ans_W++;
                }

                if (chess_Board[i].charAt(j) != start_board_2.charAt(j - y)) {
                    ans_B++;
                }

            }
            if (start_board_1.equals("WBWBWBWB")) start_board_1 = "BWBWBWBW";
            else start_board_1 = "WBWBWBWB";

            if (start_board_2.equals("BWBWBWBW")) start_board_2 = "WBWBWBWB";
            else start_board_2 = "BWBWBWBW";

        }
        return Math.min(ans_W , ans_B);
    }
}
 */

/* 2252
import java.io.*;
import java.util.*;

//위상 정렬 알고리즘 다시 정리하기 (유형화)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //위상정렬 알고리즘 구현
        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        //수가 n + 2개 이므로 그 숫자들을 잇는 선의 갯수는 n + 1이다
        int[] inDegree = new int[n + 1];
        //그래프 가중치를 생각하면 최초 값의 앞 값과 뒷 값이 존재해야 하므로 총 n + 2게 필요하다
        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 생성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int val_1 = Integer.parseInt(st.nextToken());
            int val_2 = Integer.parseInt(st.nextToken());
            //인접 리스트를 이용해 차수가 없는 그래프를 구현했다. 해당 그래프를 저장하는 방식을 생각하면 수를 이어주어야 한다.
            graph.get(val_1).add(val_2);
            //다음에 올 값은 현재 값 = val_1 보다 아래에 존재하는 차수가 하나 더해진 값이 된다.
            inDegree[val_2]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        //초기 값인 차수가 0인 시작값을 queue에 먼저 저장
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            //척 번째 값은 차수가 0으로 확정된 값이므로 바로 정답 배열에 저장
            //다음 값 부터는 차수를 0으로 만든 후 저장
            ans.add(val);
            for (int next : graph.get(val)) {
                inDegree[next]--;
                //차수가 0이 된 값은 다시 queue에 넣고 출력
                if (inDegree[next] == 0) queue.add(next);
            }
        }

        for (Integer an : ans) {
            bw.write(an + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
 */

/* 26069
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final String chong = "ChongChong";
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        Map<String , Integer> convert_chong = new HashMap<>();
        convert_chong.put(chong , 1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            String init = st.nextToken();
            String end = st.nextToken();
            if (convert_chong.containsKey(init) || convert_chong.containsKey(end)) {
                if (!convert_chong.containsKey(init)) convert_chong.put(init , 1);
                else if (!convert_chong.containsKey(end)) convert_chong.put(end , 1);
                else cnt--;
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
 */
