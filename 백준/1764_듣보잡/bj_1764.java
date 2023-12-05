package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_1764 {
    static HashMap<String, Integer> nameMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();
            if (nameMap.containsKey(name)) {
                nameMap.put(name, nameMap.get(name) + 1);
            } else {
                nameMap.put(name, 1);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        String[] keyArray = nameMap.keySet().toArray(new String[]{});
        Arrays.sort(keyArray);
        for (String name : keyArray) {
            if (nameMap.get(name) >= 2) {
                count++;
                sb.append(name + "\n");
            }
        }

        bw.write(count + "\n" + sb.toString());
        bw.flush();
        bw.close();
    }
}
