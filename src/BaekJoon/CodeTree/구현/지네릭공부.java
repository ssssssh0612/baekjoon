package BaekJoon.CodeTree.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Juice {
    String name;

    Juice (String name){
        this.name = name + "Juice";
    }
    public String toString() {
        return name;
    }
}
class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> box){
        String tmp = "";

        for(Fruit f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}

class Fruit implements Comparable<Fruit>{
    String name;
    int weight;

    Fruit (String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    Fruit(){

    }
    public String toString() {
        return name + "("+weight+")";
    }

    @Override
    public int compareTo(Fruit o) {
        return this.weight - o.weight;
    }

}
class Apple extends Fruit {
    Apple(String name, int weight){
        super(name, weight);
    }
    Apple(){
        super();
    }
//    public String toString(){
//        return "Apple";
//    }
}

class Grape extends Fruit{
    Grape(String name, int weight){
        super(name, weight);
    }
    Grape(){
        super();
    }
//    public String toString(){
//        return "Grape";
//    }
}

class AppleComp implements Comparator<Apple>{
    public int compare(Apple t1, Apple t2){
        return t2.weight - t1.weight;
    }
}


class GrapeComp implements Comparator<Grape>{
    public int compare(Grape t1, Grape t2){
        return t2.weight - t1.weight;
    }
}

class FruitComp implements Comparator<Fruit>{
    public int compare(Fruit t1, Fruit t2){
        return t1.weight - t2.weight;
    }
}

//class Fucking implements Comparator<Apple>{
//    public int compare(Apple t1, Apple t2){
//        return t2.weight - t1.weight;
//    }
//}


public class 지네릭공부 {
    public static void main(String[] args){
//        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
//        FruitBox<Apple> appleBox = new FruitBox<Apple>();

//        fruitBox.add(new Apple());
//        fruitBox.add(new Grape());
//        System.out.println(fruitBox);
//        appleBox.add(new Apple());
//        appleBox.add(new Apple());
//        System.out.println(appleBox);
//        System.out.println(Juicer.makeJuice(fruitBox));
//        System.out.println(Juicer.makeJuice(appleBox));
//        새로 알게된 사실 StringBuilder에 객체를 추가하면 해당 객체의 toString 결과값이 추가됨
//        System.out.println("=================");
//        StringBuilder sb = new StringBuilder();
//        sb.append(new Apple());
//        System.out.println(sb);

        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();

        appleBox.add(new Apple("GreenApple", 300));
        appleBox.add(new Apple("GreenApple", 100));
        appleBox.add(new Apple("GreenApple", 200));

        grapeBox.add(new Grape("GreenGrape", 400));
        grapeBox.add(new Grape("GreenGrape", 300));
        grapeBox.add(new Grape("GreenGrape", 200));

        Collections.sort(appleBox.getList());
        Collections.sort(grapeBox.getList());

        System.out.println(appleBox);
        System.out.println(grapeBox);

        System.out.println();

        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());

        System.out.println(appleBox);
        System.out.println(grapeBox);
    }
}

class FruitBox<T extends Fruit> extends Box<T>{

}
class Box<T>{
    ArrayList<T> list = new ArrayList<T>();

    void add(T item){
        list.add(item);
    }

    T get(int i){
        return list.get(i);
    }

    ArrayList<T> getList(){
        return list;
    }

    int size(){
        return list.size();
    }

    public String toString(){
        return list.toString();
    }
}
