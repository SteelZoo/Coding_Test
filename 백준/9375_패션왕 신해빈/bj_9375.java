package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_9375 {
    static HashMap<String, Integer> wearMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            wearMap = new HashMap<>();
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String wear = st.nextToken();
                wearMap.put(wear, wearMap.getOrDefault(wear, 0) + 1);
            }

            int total = 1;
            for (String wear : wearMap.keySet()) {
                total = total * (wearMap.get(wear)+1);
            }
            total--;

            sb.append(total).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}