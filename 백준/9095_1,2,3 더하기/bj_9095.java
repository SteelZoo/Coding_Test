package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_9095 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            answer = 0;
            int target = Integer.parseInt(br.readLine());
            checkCase(target,0);
            sb.append(answer+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void checkCase(int target, int nowTotal){
        if (target == nowTotal){
            answer++;
            return;
        } else if (nowTotal >= target) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            checkCase(target,nowTotal+i);
        }
    }
}
