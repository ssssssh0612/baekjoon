package BaekJoon.TwoPointer;

import java.io.*;

public class 문자열_생성_6137 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            arr[i] = str.charAt(0);
        }
        int start = 0;
        int end = n - 1;
        StringBuilder sb = new StringBuilder();

        while (start != end) {
            // 결국엔 같아질수밖에 없음 같아지는 순간 맨 뒤에 추가
            if (arr[start] == arr[end]) {

                int length = end - start + 1;
                int newStart = start + 1;
                int newEnd = end - 1;

                int count = 1;
                // 짝수
                if (length % 2 == 0) {
                    boolean flag = false;
                    while (newStart < newEnd) {
                        if (arr[newStart] == arr[newEnd]) {
                            newStart++;
                            newEnd--;
                            count++;
                        } else {
                            flag = true;
                            // 누가 더 작은지 찾기
                            if (arr[newStart] > arr[newEnd]) {
                                // end가 더 작으면
                                sb.append((char) arr[end]);
                                end--;
                            } else {
                                sb.append((char) arr[start]);
                                start++;
                            }
                            break;
                        }
                    }

                    if (!flag) {
                        // 모두 같다는 의미이므로 start부터end까지 문자열 모두 추가
                        sb.append((char)arr[start]);
                        start++;
                        continue;
                    }

                } else {
                    // 홀수
                    boolean flag = false;
                    while (newStart != newEnd) {
                        if (arr[newStart] == arr[newEnd]) {
                            newStart++;
                            newEnd--;
                            count++;
                        } else {
                            flag = true;
                            // 누가 더 작은지 찾기
                            if (arr[newStart] > arr[newEnd]) {
                                // end가 더 작으면
                                sb.append((char) arr[end]);
                                end--;

                            } else {
                                sb.append((char) arr[start]);
                                start++;
                            }
                            break;
                        }
                    }
                    if (!flag) {
                        // 모두 같다는 의미이므로 start부터end까지 문자열 모두 추가
                        sb.append((char)arr[start]);
                        start++;
                        continue;
                    }
                }
                continue;
            }

            if (arr[end] < arr[start]) {
                sb.append((char) arr[end]);
                end--;
            } else {
                sb.append((char) arr[start]);
                start++;
            }

        }
        StringBuilder result = new StringBuilder();
        int count = 0 ;

        sb.append((char) arr[start]);
        for (int i = 0; i < sb.length(); i++) {
            result.append(sb.toString().charAt(i));
            count++;
            if(count == 80){
                result.append("\n");
                count = 0;
            }
        }


        System.out.println(result);
    }
}