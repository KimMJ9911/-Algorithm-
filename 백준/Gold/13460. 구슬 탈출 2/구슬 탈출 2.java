import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static boolean game_ends = false;
    static int[] dx = {-1 , 1 , 0 , 0} , dy = {0 , 0 , -1 , 1};
    static int result = -1;

    static class Pair {
        int rx;
        int ry;
        int bx;
        int by;
        public Pair(int rx , int ry , int bx , int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        System.out.println(n + " " + m);

        int srx = 0 , sry = 0 , sbx = 0 , sby = 0;
        map = new String[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
                if (line.charAt(j) == 'R') {srx = i; sry = j;}
                if (line.charAt(j) == 'B') {sbx = i; sby = j;}
            }
        }

//        for (String[] strings : map) {
//            for (String string : strings) {
//                System.out.print(string + " ");
//            }
//            System.out.println();
//        }

        bfs(new Pair(srx , sry , sbx , sby));

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    static Pair move(int idx , Pair curr) {
        Pair next = new Pair(curr.rx , curr.ry , curr.bx , curr.by);

        int flagR = 0 , flagB = 0;  // 각 공의 상태를 나타내는 지표
        boolean[] endPoint = {false , false};  // red , blue 두 공의 상태를 모니터링 하는 배열

        while(true) {
            if (endPoint[0] && endPoint[1]) {  //  두 flag 가 모두 t/f 인 경우이므로
                if (flagR == 1 && flagB == 0) {  // 빨간 공만
                    game_ends = true;
                    break;
                }
                else if (flagR == 1 && flagB == 1) return null;
                else if (flagR == 0 && flagB == 1) return null;
                else break;  // 둘 다 아직 도착하지 않은 경우
            }

            // 벽에 도착한 경우 true
            if (!endPoint[0] && !map[next.rx + dx[idx]][next.ry + dy[idx]].equals("#")) {  // 빨간공이 다음 움직임이 불가능한 경우
                next.rx += dx[idx];
                next.ry += dy[idx];
            } else endPoint[0] = true;

            if (!endPoint[1] && !map[next.bx + dx[idx]][next.by + dy[idx]].equals("#")) {  // 파란공이 다음 움직임이 불가능한 경우
                next.bx += dx[idx];
                next.by += dy[idx];
            } else endPoint[1] = true;

            // 공이 도착점에 도착한 경우
            if (!endPoint[0] && map[next.rx][next.ry].equals("O")) {
                flagR = 1;
                endPoint[0] = true;
            }

            if (!endPoint[1] && map[next.bx][next.by].equals("O")) {
                flagB = 1;
                endPoint[1] = true;
            }

            // 두 공이 만난 경우 true
            if (!endPoint[0] && next.rx == next.bx && next.ry == next.by) {
                next.rx -= dx[idx];  // 다음 움직임 취소
                next.ry -= dy[idx];
                endPoint[0] = true;  // 도착 지표 갱신 (= true)
            }

            if (!endPoint[1] && next.bx == next.rx && next.by == next.ry) {  // 파란공이 최종 도착점에 도착한 경우
                next.bx -= dx[idx];  // 다음 움직임 취소
                next.by -= dy[idx];
                endPoint[1] = true;  // 도착 지표 갱신 (= true)
            }
        }
        return next;
    }

    static void bfs(Pair curr) {
        int cnt = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(curr);

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Pair next = move(j , curr);

                    if (next == null) continue;

                    if (game_ends) {
                        result = cnt;
                        return; //  종료
                    }

                    queue.offer(next);
                }
            }
            if (cnt >= 10) break;  // 10회 이상이면 종료 , -1 출력
        }
    }
}