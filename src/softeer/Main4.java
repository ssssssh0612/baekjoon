package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main4 {
    public static class Person{
        //
        long age;
        // 여자 남자 여자는 0 남자는 1
        int sex;
        // 임산부 0, 장애인 1, 환자 2
        int check;
        public Person(long age, int sex, int check){
            this.age = age;
            this.sex = sex;
            this.check = check;
        }
    }
    static List<Person> list = new ArrayList<>();
    static int[] arr = new int[3];
    // 성별 나이 노약자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }
    public static void sort(){

    }
    public static void input(BufferedReader br) throws  IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 3;  i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int personCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < personCount; i++) {
            st = new StringTokenizer(br.readLine());
            int check = st.countTokens();
            if(check == 2){

            }else{
                long age = 0 ;
                int sexNumber = 0;
                int checkingNumber = 0;
                char sex = st.nextToken().charAt(0);
                if(sex == 'M'){
                    sexNumber = 1;
                }else{
                    sexNumber = 0;
                }
                age = Long.parseLong(st.nextToken());
                String str = st.nextToken();
                if(str.equals("PW")){
                    checkingNumber = 0;
                }else if(str.equals("DP")){
                    checkingNumber = 1;
                }else{
                    checkingNumber = 2;
                }
                list.add(new Person(age, sexNumber, checkingNumber));
            }
        }
    }
}
