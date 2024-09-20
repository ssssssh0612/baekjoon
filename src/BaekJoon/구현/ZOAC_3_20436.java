package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZOAC_3_20436 {
    static char[][] keyBoard = new char[3][10];
    static int[] leftPos;
    static int[] rightPos;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        String a = "qwertyuiop";
        String b = "asdfghjkl";
        String c = "zxcvbnm";
        String leftWord = "qwertasdfgzxcv";
        String rightWord = "yuiophjklbnm";
        list.add(a);
        list.add(b);
        list.add(c);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                keyBoard[i][j] = list.get(i).charAt(j);
            }
        }
        String RL = sc.nextLine();
        char left = RL.charAt(0);
        char right = RL.charAt(2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(keyBoard[i][j] == left){
                    leftPos = new int[]{i,j};
                }else if(keyBoard[i][j] == right){
                    rightPos = new int[]{i,j};
                }
            }
        }
        String sentence = sc.next();

        for (int i = 0; i < sentence.length(); i++) {
            if(leftWord.contains(sentence.charAt(i)+"")){
                int [] sentencePos = posFind(sentence.charAt(i));
                count = count + Math.abs(leftPos[0] - sentencePos[0])+Math.abs(leftPos[1] - sentencePos[1]);
                count++;
                leftPos[0] = sentencePos[0];
                leftPos[1] = sentencePos[1];
            }else if(rightWord.contains(sentence.charAt(i)+"")){
                int [] sentencePos = posFind(sentence.charAt(i));
                count = count + Math.abs(rightPos[0] - sentencePos[0])+Math.abs(rightPos[1] - sentencePos[1]);
                count++;
                rightPos[0] = sentencePos[0];
                rightPos[1] = sentencePos[1];
            }
        }
        System.out.println(count);
    }
    // 위치 찾기
    public static int[] posFind( char a){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(keyBoard[i][j] == a){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
