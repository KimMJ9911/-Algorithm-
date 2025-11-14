import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        //산술평균
        int mean = 0;
        for (int i = 0; i < n; i++) {
            mean += nums[i];
        }

        double var = (double) mean / n;
        mean /= n;
        if (Math.abs(var - mean) >= 0.5) {
            if (var < 0) mean--;
            else if (var > 0) mean++;
        }

        //중앙값
        int middle = nums[n / 2];

        //최빈값
        int frequent = 0;
        Map<Integer , Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num , map.get(num) + 1);
            else map.put(num , 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        int max = Integer.MIN_VALUE;
        for (Integer value : values) {
            max = Math.max(max , value);
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer , Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                ans.add(entry.getKey());
            }
        }

        if (ans.size() == 1) frequent = ans.get(0);
        else {
            Collections.sort(ans);
            frequent = ans.get(1);
        }


        //범위
        int range = nums[n - 1] - nums[0];

        sb.append(mean).append("\n")
                .append(middle).append("\n")
                .append(frequent).append("\n")
                .append(range).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}