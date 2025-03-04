package BaekJoon.programmers.level2;
public class 큰_수_만들기 {
    public String solution(String number, int k) {
        int index = 0;
        int length = number.length();
        int count = number.length() - k;
        StringBuilder sb = new StringBuilder();
        while(count > 0){
            int maxValueIndex = 0;
            int maxNum = Integer.MIN_VALUE;
            // System.out.println(index + " " + (length - count));
            for(int i = index; i <= length - count; i++){
                int num = (int)(number.charAt(i) - '0');
                // System.out.println("num = " + num + " maxNum = " + maxNum);
                if(num > maxNum){
                    maxValueIndex = i;
                    maxNum = num;
                }
            }
            sb.append(""+number.charAt(maxValueIndex));
            count--;
            index = maxValueIndex + 1;
        }
        return sb.toString();
    }
}