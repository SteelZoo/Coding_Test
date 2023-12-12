package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1929 {
    static boolean[] eratosche;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        eratosche = new boolean[end + 1];
        initChe();

        for (int i = start; i <= end ; i++) {
            if (!eratosche[i]){
                sb.append(i+"\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void initChe() {
        eratosche[1] = true;
        for (int i = 2; i < eratosche.length; i++) {
            if (eratosche[i] == false) {
                int tempStart = i * 2;
                for (int j = tempStart; j < eratosche.length; j += i) {
                    eratosche[j] = true;
                }
            }
        }
    }
}
