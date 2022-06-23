//2020카카오인턴쉽
//키패드누르기

import java.util.ArrayList;

public class PressKeypad {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(int[] numbers, String hand) {
            String useHand = "";
            int leftHand = 10;
            int rightHand = 12;

            for(int i:numbers){
                if(i==1||i==4||i==7){
                    useHand = useHand+"L";
                    leftHand = i;
                }
                if(i==3||i==6||i==9){
                    useHand = useHand+"R";
                    rightHand = i;
                }
                if(i==2||i==5||i==8||i==0){
                    if(i==0){i=11;}
                    if(checkDistance(i,leftHand)<checkDistance(i,rightHand)){
                        leftHand = i;
                        useHand = useHand + "L";
                    }else if(checkDistance(i,leftHand)>checkDistance(i,rightHand)){
                        rightHand = i;
                        useHand = useHand + "R";
                    }else if(checkDistance(i,leftHand)==checkDistance(i,rightHand)){
                       if(hand.equals("right")){
                           rightHand = i;
                           useHand = useHand + "R";
                       } else if (hand.equals("left")){
                           leftHand = i;
                           useHand = useHand + "L";
                       }
                    }
                }
            }
            String answer = useHand;
            return answer;
        }
        public int checkDistance(int i, int hand){
            int gap = Math.abs(i-hand);

            return ((int)gap/3)+(gap%3);
        }
    }//solution
}
