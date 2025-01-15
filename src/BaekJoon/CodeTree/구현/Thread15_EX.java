package BaekJoon.CodeTree.구현;

public class Thread15_EX {
    public static void main(String args[]) {
        RunImplEx15 r = new RunImplEx15();
        Thread th1 = new Thread(r, "쓰레드1");
        Thread th2 = new Thread(r, "쓰레드2");
        Thread th3 = new Thread(r, "쓰레드3");

        th1.start();
        th2.start();
        th3.start();

        try {
            System.out.println("아 잠든다!!!!!!! =====================================");
            Thread.sleep(10000);	// [by LSH] main 이 흐르는 시간 관장
            System.out.println("잠에서 꺳다!!!!!! =====================================");
            th1.interrupt();
//            th1.suspend();		// 쓰레드 th1을 잠시 중단시킨다.
            System.out.println("아 잠든다!!!!!!! =====================================");
            Thread.sleep(2000);
            System.out.println("잠에서 꺳다!!!!!! =====================================");
            th1.interrupt();
//            th2.suspend();
            System.out.println("아 잠든다!!!!!!! =====================================");
            Thread.sleep(3000);
            System.out.println("잠에서 꺳다!!!!!! =====================================");
            th1.interrupt();
//            th1.resume();		// 쓰레드 th1이 다시 동작하도록 한다.
            System.out.println("아 잠든다");
            Thread.sleep(3000);
            th1.interrupt();
            th1.stop();			// 쓰레드 th1을 강제 종료시킨다.
            th2.stop();
            System.out.println("곧 끝난다");
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {}
    }
}
class RunImplEx15 implements Runnable {
    public void run() {
        while(true) {
            System.out.println("지금 쓰레드" + Thread.currentThread().getName() + " 진행중 ");
            try {
                Thread.sleep(1000);	// [by LSH] 출력하는 단위 시간 관장
            } catch (InterruptedException e) {
                System.out.println("실행대기상태다!!!");
            }
        }
    }
}