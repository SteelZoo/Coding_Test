package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_10845 {
    static LinkedList<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = -1;
            if (command.equals("push")) {
                num = Integer.parseInt(st.nextToken());
            }
            queueFun(command, num);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void queueFun(String command, int number) {
        switch (command) {
            case "push": {
                q.add(number);
            }
            break;
            case "pop": {
                Integer temp = q.poll();
                sb.append((temp == null) ? -1 : temp.toString());
                sb.append("\n");
            }
            break;
            case "size": {
                sb.append(q.size());
                sb.append("\n");
            }
            break;
            case "empty": {
                if (q.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            }
            break;
            case "front": {
                Integer temp = q.peekFirst();
                sb.append(
                        (temp == null) ? -1 : temp.toString()
                );
                sb.append("\n");
            }
            break;
            case "back": {
                Integer temp = q.peekLast();
                sb.append(
                        (temp == null) ? -1 : temp.toString()
                );
                sb.append("\n");
            }
            break;
        }

    }
}
