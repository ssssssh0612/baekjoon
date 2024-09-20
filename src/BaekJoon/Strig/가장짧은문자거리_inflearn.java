package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장짧은문자거리_inflearn {
    static String a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        String b = st.nextToken();
        char result = b.charAt(0);

        char[] charArr = a.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < charArr.length; i++){
            char c = charArr[i];
            int lt = i;
            int rt = i;
            if(c == result){
                list.add(0);
            }else{
                lt--;
                rt++;
                while(checking(lt)){
                    if( charArr[lt] == result ){
                        break;
                    }else{
                        lt--;
                    }
                }

                while (checking(rt)){
                    if( charArr[rt] == result ){
                        break;
                    }else{
                        rt++;
                    }
                }

                if( lt == -1 ){
                    list.add(Math.abs(i-rt));
                }else if( rt == charArr.length){
                    list.add(Math.abs(i-lt));
                }else{
                    list.add(Math.min(Math.abs(i-lt),Math.abs(i-rt)));
                }

            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }
    public static boolean checking(int number){
        return number >= 0 && number < a.length();
    }
}
