package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj_14425 {
    static HashSet<String> words = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wordCount = Integer.parseInt(st.nextToken());
        int targetCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < wordCount; i++) {
            words.add(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < targetCount; i++) {
            if (words.contains(br.readLine())){
                answer++;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
