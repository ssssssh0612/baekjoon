package BaekJoon.DataStructure.Array;

public class 숫자바꿔보기연습 {
    public static void main(String[] args) {
        reverseNumber(123);


    }

    public static void reverseNumber(int a) {
        int anwser = 0;
        while (a > 0) {
        int t = 0;
        t = a % 10;
        anwser = anwser * 10 + t;
        a = a / 10;
        System.out.println(anwser);
        }
    }
}
