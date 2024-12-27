package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 국영수_10825 {
    public static class Student implements Comparable<Student> {
        int korea;
        int english;
        int math;
        String name;
        public Student(String name,int korea, int english, int math){
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }

        // 국어 점수 내림차순
        // 영어 점수 오름차순 (국어 같으면)
        // 수학 점수 내림차순
        // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
        @Override
        public int compareTo(Student student){
            if( student.korea - this.korea == 0 ){
                if( this.english - student.english == 0){
                    if( student.math - this.math == 0){
                        return this.name.compareTo(student.name);
                    }else{
                        return student.math - this.math;
                    }
                }else{
                    return this.english - student.english;
                }
            }else{
                return student.korea - this.korea;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, korea, english, math));
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Student student : list){
            sb.append(student.name).append("\n");
        }
        System.out.println(sb);
    }
}
