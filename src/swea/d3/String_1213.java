package swea.d3;

import javax.print.attribute.standard.PresentationDirection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1213 {
    static int resultCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            input(br,number);
        }
    }

    public static void input(BufferedReader br, int number) throws IOException {
        char[] chArr = br.readLine().toCharArray();
        String str = br.readLine();
        int chArrLength = chArr.length;
        int strLength = str.length();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (checking(i,chArr,str)) {
                count++;
            }
        }
        System.out.println("#" + (number) + " "+ count);
    }
    public static boolean checking(int start, char[] chArr, String str){
        int count = 0;
        for(int i = start; i < start + chArr.length ; i++ ){
            if (checkingRange(i, str.length()) && chArr[count] == str.charAt(i)) {
                count++;
            }else{
                return false;
            }
        }
        return true;

    }
    public static boolean checkingRange( int number , int length){
        return number >= 0 && number < length;
    }
}
