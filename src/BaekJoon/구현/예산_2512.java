package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 예산_2512 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("?");
        step();
    }
//    public static void input(BufferedReader br) throws IOException {
//        int length = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < length; i++){
//            list.add(Integer.parseInt(st.nextToken()));
//        }
//        int maxNum = Integer.parseInt(br.readLine());
//    }
    public static void step(){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.binarySearch(arr,1));
        System.out.println(bs3(arr,4));
    }

    // 정렬되어있는 배열, 숫자를 넣기
    public static int bs(int[] arr, int number){
        int answer = 0;
        int start = 0 ;
        int end = arr.length - 1;
        while( start <= end){
            int mid = (start+end) / 2;
            if(arr[mid] == number ){
                answer = mid + 1;
                break;
            }
            if(arr[mid] > number){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return answer;
    }
    public static int bs2( int [] arr , int number ){
        int start = 0 ;
        int end = arr.length - 1;
        int result = 0 ;
        while( start <= end ){
            int mid = (start + end) / 2;
            if( arr[mid] == number ){
                result = mid;
                return result;
            }
            if( arr[mid] > number ){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int bs3(int[] arr, int number){
        int anwser = 0 ;
        int start = 0 ;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == number){
                anwser = mid;
                return anwser;
            }
            if(arr[mid] > number){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }




















}
