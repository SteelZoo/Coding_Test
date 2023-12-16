package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int test_case = 0; test_case < TC; test_case++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int answer = getAnswer(x1, y1, r1, x2, y2, r2);

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int getAnswer(int x1, int y1, int r1, int x2, int y2, int r2) {
        double dis = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double sum = r1 + r2;
        double minus = Math.abs(r1 - r2);

        if (dis == 0 && r1 == r2){
            return -1;
        } else if (sum == dis || minus == dis) {
            return 1;
        } else if (minus < dis == dis < sum) {
            return 2;
        } else {
            return 0;
        }
    }
}
