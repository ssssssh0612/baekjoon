package BaekJoon.programmers.level2;

public class 양궁대회 {
    private static int max;
    private static int[] answer;
    private static int[] apeach;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        apeach = info;
        max = 0 ;
        backTracking(n, 0, new int[11]);
        return max == 0 ? new int[]{-1} : answer;
    }

    private static int getScore(int[] ryan){
        int score = 0;
        for(int i = 0 ; i <= 10 ; i++){
            if(ryan[i] + apeach[i] > 0){
                score += ryan[i] > apeach[i] ? ( 10 - i ) : -(10 - i);
            }
        }
        return score;
    }

    private static void calculateDiff(int[] ryan){
        int score = getScore(ryan);
        if(max < score){
            max = score;
            answer = ryan.clone();
        }else if(max > 0 && max == score){
            for(int i = 10; i >= 0 ; i--){
                if(answer[i] != ryan[i]){
                    if(answer[i]<ryan[i]){
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }

    private static void backTracking(int n, int idx, int[] ryan){
        if(n==0){
            for(int i = 0 ; i < ryan.length; i ++){
                System.out.print(ryan[i] + " ");
            }
            calculateDiff(ryan);
            return;
        }
        for(int i = idx; i <= 10; i ++){
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            backTracking(n - cnt, i + 1, ryan);
            ryan[i] = 0;
        }
    }

}
