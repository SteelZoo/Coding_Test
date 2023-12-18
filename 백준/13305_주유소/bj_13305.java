package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_13305 {
    static int[] road;
    static int[] oilPrice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // init data
        int oilCount = Integer.parseInt(br.readLine());
        road = new int[oilCount-1];
        oilPrice = new int[oilCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < oilCount-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < oilCount; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        long totalPrice = 0;
        int nowPrice = Integer.MAX_VALUE;
        for (int i = 0; i < road.length; i++) {
            if (oilPrice[i] < nowPrice){
                nowPrice = oilPrice[i];
            }

            totalPrice += (long) nowPrice *road[i];
        }

        bw.write(Long.toString(totalPrice));
        bw.flush();
        bw.close();
    }
}
