package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 두개뽑아서더하기 {
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(sc.nextInt(),sc.nextInt()));
        System.out.println(list);
    }

    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i != j){
                    hashSet.add(numbers[i] + numbers[j]);
                }
            }
        }
        return hashSet.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    public static void backTracking(){

    }
}
