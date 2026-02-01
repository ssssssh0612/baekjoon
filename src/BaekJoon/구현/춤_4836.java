package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 춤_4836 {
    static List<String> list = new ArrayList<>();
    static int[] arr ;
    static List<Integer> dipList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            list = new ArrayList<>();
            arr = new int[6];
            dipList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(str);
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            if(!step1()){
                arr[1]++;
            }
            if(!step2()){
                arr[2]++;
            }
            if(!step3()){
                arr[3]++;
            }
            if(!step4()){
                arr[4]++;
            }
            if(!step5()){
                arr[5]++;
            }

            int count = 0;
            int lastNum = 0;
            
            for (int i = 1; i < 6; i++) {
                if(arr[i] == 1){
                    count++;
                    lastNum = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            if(count == 0){
                sb.append("form ok: ");
                for (String string : list) {
                    sb.append(string).append(" ");
                }
                System.out.println(sb);
                continue;
            }

            if(count == 1){
                sb.append("form error ").append(lastNum).append(": ");

                if(arr[1] == 1){
                    int index = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if(index >= 0 && index < dipList.size() && dipList.get(index) == i){
                            sb.append("DIP").append(" ");
                            index++;
                        }else{
                            sb.append(list.get(i)).append(" ");
                        }
                    }
                }else{
                    for (String string : list) {
                        sb.append(string).append(" ");
                    }
                }

                System.out.println(sb);
                continue;
            }

            sb.append("form errors");
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i < 6; i++) {
                if(arr[i] == 1){
                    nums.add(i);
                }
            }

            int size = nums.size();
            for (int i = 0; i < size; i++) {
                int num = nums.remove(0);
                if(nums.size() >= 2){
                    sb.append(" ").append(num).append(",");
                    continue;
                }
                if(nums.size() == 1){
                    sb.append(" ").append(num).append(" and");
                    continue;
                }
                sb.append(" ").append(num).append(": ");
            }

            if(arr[1] == 1){
                int index = 0;
                for (int i = 0; i < list.size(); i++) {
                    if(index >= 0 && index < dipList.size() && dipList.get(index) == i){
                        sb.append("DIP").append(" ");
                        index++;
                    }else{
                        sb.append(list.get(i)).append(" ");
                    }
                }
            }else{
                for (String string : list) {
                    sb.append(string).append(" ");
                }
            }
            System.out.println(sb);

        }
    }

    // 1 dip은 jiggle을 춘 다음이나 다다음, 또는 twirl을 추기 전에 출 수 있다. 예를 들면 다음과 같다.
    // ...jiggle dip...
    // ...jiggle stomp dip...
    // ...dip twirl...
    public static boolean step1(){
        int size = list.size();
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if(list.get(i).equals("dip")){
                if((checking(i - 1) && list.get(i - 1).equals("jiggle")) ||
                        (checking(i - 2) && list.get(i - 2).equals("jiggle")) ||
                            (checking(i + 1) && list.get(i + 1).equals("twirl")) ){
                    continue;
                }else{
                    flag = false;
                    dipList.add(i);
                }
            }
        }
        return flag;
    }

    // 2 모든 춤은 clap stomp clap으로 끝나야 한다.
    public static boolean step2(){
        if(list.size() - 3 < 0){
            return false;
        }
        int index = 0;
        for (int i = list.size() - 3; i < list.size(); i++) {
            if(index == 0){
                if(list.get(i).equals("clap")){
                    index++;
                    continue;
                }else{
                    return false;
                }
            }
            if(index == 1){
                if(list.get(i).equals("stomp")){
                    index++;
                    continue;
                }else{
                    return false;
                }
            }
            if(index == 2){
                if(list.get(i).equals("clap")){
                    index++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    // 3 만약 twirl을 췄다면, hop도 춰야한다.
    public static boolean step3(){
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("twirl")){
                flag = true;
            }
        }
        if(!flag){
            return true;
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("hop")){
                return true;
            }
        }
        return false;
    }
    // 4 jiggle로 춤을 시작할 수 없다.
    public static boolean step4(){
        if(list.get(0).equals("jiggle")){
            return false;
        }
        return true;
    }
    // 5 반드시 dip을 춰야 한다.
    public static boolean step5(){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("dip")){
                return true;
            }
        }
        return false;
    }
    public static boolean checking(int size){
        return size >= 0 && size < list.size();
    }

}
