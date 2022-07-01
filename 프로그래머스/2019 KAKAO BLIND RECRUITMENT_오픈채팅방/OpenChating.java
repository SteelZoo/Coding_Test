import java.util.ArrayList;
import java.util.HashMap;

public class OpenChating {
    class Solution {
        public String[] solution(String[] record) {
            HashMap<String,String> userNickName = new HashMap<String,String>();

            for(int i=0;i<record.length;i++){
                String[] message = record[i].split(" ");
                //닉네임 수집(enter이거나 change이면 닉네임 변경 적용)
                if(message[0].equals("Enter")||message[0].equals("Change")){
                    userNickName.put(message[1],message[2]);
                }
            }

            ArrayList<String> result = new ArrayList<String>();
            for(int i=0;i<record.length;i++){
                String[] message = record[i].split(" ");
                //결과메세지 변환(enter이거나 leave일때만)
                if(message[0].equals("Enter")){
                    result.add(userNickName.get(message[1])+"님이 들어왔습니다.");
                }else if(message[0].equals("Leave")){
                    result.add(userNickName.get(message[1])+"님이 나갔습니다.");
                }
            }


            String[] answer = result.toArray(new String[0]);
            return answer;
        }
    }
}
