package BaekJoon.CodeTree.구현;

import java.io.IOException;

@FunctionalInterface
interface MyFunction{
    void myMethod();
}
public class Lambda_Ex {
    public static void main(String[] args) throws IOException {
        MyFunction f = () -> { System.out.println("f입니다."); };
        f.myMethod();
        Object obj = (Object) (MyFunction) () -> { System.out.println("obj입니다.");};
        String str = ((Object) (MyFunction) () -> { System.out.println("str입니다.")}).toString();
        ((MyFunction) obj).myMethod();

    }
}
