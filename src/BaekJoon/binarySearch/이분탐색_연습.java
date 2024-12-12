package BaekJoon.binarySearch;

public class 이분탐색_연습 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] arr4 = new int[]{1,2,3,4,5,6};
        int[] arr2 = new int[]{1,1,2,2,3,3,3,3,3,3,4,4,4,5,5,5,6,7,8,9,10};
        int[] arr3 = new int[]{1,3,3,3,3,3,3,5};

//        bs(arr,10);
//        System.out.println(lowerBound(arr4,2));
//        System.out.println();
//        System.out.println(upperBound(arr3,3));
        check();

    }
    public static void check(){
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1 ;
        }
        int index = 1;
        while (index < arr.length){
            System.out.println(lowerBound(arr, index));
            index++;
        }
    }
    public static int bs(int[] array, int target){
        int low = 0;
        int high = array.length - 1;
        // 시작 index와 끝 index에 대해서

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("high = " + high + " , mid = " + mid + ", low = " + low);
            if (array[mid] == target) {
                return mid; // target을 찾으면 인덱스를 반환
            }

            if (array[mid] < target) {
                low = mid + 1; // 오른쪽 부분 탐색
            } else {
                high = mid - 1; // 왼쪽 부분 탐색
            }

        }
        return -1; // target이 없는 경우
    }

    //int[] arr2 = new int[]{1,1,2,2,3,3,3,3,3,4,4,4,5,5,5,6,7,8,9,10};


    //int[] arr3 = new int[]{1,3,3,3,3,3,3,5};
    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {

            int mid = (lo + hi) / 2; // 중간위치를 구한다.
//            System.out.println("low = " + lo + " , mid = " + mid + " high = " + hi);

            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }
        return lo;
    }
//  int[] arr3 = new int[]{1,3,3,3,3,3,3,5};
    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {

            int mid = (lo + hi) / 2; // 중간위치를 구한다.
            System.out.println("low = " + lo + " , mid = " + mid + " high = " + hi);

            // key값이 중간 위치의 값보다 작을 경우
            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
