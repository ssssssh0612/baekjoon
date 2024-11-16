package BaekJoon.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class compare예제 {
    public static class Student{
        int grade;
        int age;
        String name;
        public Student(String name, int grade, int age){
            this.name = name;
            this.grade = grade;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{3, 4, 5});
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{2, 3, 4});
        list.add(new int[]{5, 6, 3});
        list.add(new int[]{4, 2, 1});
        list.add(new int[]{5, 2, 9});
        list.add(new int[]{3, 4, 6});
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("서상현", 4, 25));
        studentList.add(new Student("서상현1", 2, 22));
        studentList.add(new Student("서상현22", 3, 22));
        studentList.add(new Student("서상현333", 1, 20));
        studentList.add(new Student("서상현4444", 6, 21));
        studentList.add(new Student("서상현55555", 2, 29));

        Comparator<Student> comparatorStudent = new Comparator<Student>(){
            @Override
            public int compare(Student st1, Student st2){
                int result = Integer.compare(st2.age, st1.age);
                if(result != 0){
                    return result;
                }
                result = Integer.compare(st1.name.length() , st2.name.length());
                if(result != 0){
                    return result;
                }
                result = Integer.compare(st1.grade, st2.grade);
                if(result != 0){
                    return result;
                }
                return result;
            }
        };
        // 나이순으로 정렬, 이름 길이순 정렬 마지막 학년순
        Collections.sort(studentList, comparatorStudent);
        for (Student student : studentList) {
            System.out.println(student.age + ", " + student.name + ", " + student.grade);
        }
        System.out.println();







//        Collections.sort(list, comparator);
        for (int[] arr : list) {
            System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]);
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = Integer.compare(o1[0], o2[0]);
                // 0번째 값이 같다면 오름차순
                if (result != 0) {
                    return result;
                }
                // 1번째 값이 같다면 오름차순
                result = Integer.compare(o1[1], o2[1]);
                if (result != 0) {
                    return result;
                }
                result = Integer.compare(o1[2], o2[2]);
                if( result != 0){
                    return result;
                }
                return result;
            }
        };



    }
}
