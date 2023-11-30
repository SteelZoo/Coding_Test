package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class bj_10773 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            Integer target = Integer.parseInt(br.readLine());

            if (target == 0){
                stack.pop();
            } else {
                stack.push(target);
            }
        }

        int answer = 0;
        for (Integer integer : stack) {
            answer += integer;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
