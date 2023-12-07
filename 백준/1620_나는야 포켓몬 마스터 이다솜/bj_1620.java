package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj_1620 {
    static HashMap<String,String> pokeBook = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int quesCount = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= total; i++) {
            String pokemon = br.readLine();
            pokeBook.put(pokemon,Integer.toString(i));
            pokeBook.put(Integer.toString(i),pokemon);
        }

        for (int i = 0; i < quesCount; i++) {
            bw.write(pokeBook.get(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();
    }
}
