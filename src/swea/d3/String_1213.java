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
            char[] chArr = br.readLine().toCharArray();
            String str = br.readLine();
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == chArr[0]) {
                    for (int k = 0; k < chArr.length; k++) {
                        if (j + k < str.length()) {
                            char ch2 = str.charAt(j + k);
                            if (ch2 == chArr[k]) {
                                count++;
                            }else{
                                break;
                            }
                        }
                    }
                    if (count == chArr.length) {
                        resultCount++;
                    }
                    count = 0;
                }
            }
            System.out.println("#" + (number) +" "+resultCount);
            resultCount = 0;
        }
    }
}
