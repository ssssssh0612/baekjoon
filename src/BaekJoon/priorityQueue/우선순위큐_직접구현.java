package BaekJoon.priorityQueue;

import java.io.IOException;
import java.util.Comparator;

public class 우선순위큐_직접구현 {
    public static void main(String[] args) throws IOException {

    }

    public static class Heap<E> {
        private final Comparator<? super E>  comparator;

        private static final int DEFAULT_CAPACITY = 10;

        private int size;

        private Object[] array;

        public Heap(){
            this(null);
        }


        public Heap(Comparator<? super E> comparator) {
            this.array = new Object[DEFAULT_CAPACITY];
            this.size = 0;
            this.comparator = comparator;
        }

        public Heap(int capacity){
            this(capacity, null);
        }

        public Heap(int capacity, Comparator<? super E> comparator){
            this.array = new Object[capacity];
            this.size = 0;
            this.comparator = comparator;
        }

        // 받은 인덱스의 부모 노드 인덱스를 반환
        public int getParent(int index){
            return index / 2;
        }

        // 받은 인덱스의 왼쪽 자식 노드
        private int getLeftChild(int index){
            return index * 2;
        }

        // 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
        private int getRightChild(int index){
            return index * 2 + 1;
        }

        public void resizeArray(){
            this.size *= 2;
            Object[] newArray = new Object[size];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            this.array = newArray;
        }

        public void resize(int newCapacity){
            // 새로 만들 배열
            Object[] newArray = new Object[newCapacity];

            // 새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다.
            for (int i = 1; i <= size; i++) {
                newArray[i] = array[i];

            }

            this.array = null;
            this.array = newArray;
        }

        public void add(E value){
            if( size + 1 == array.length ){
                resize(array.length * 2);
            }
            siftUp(size + 1, value);
            size++;
        }
        private void siftUp(int idx, E target){
            if(comparator != null){
                siftUpComparator(idx, target, comparator);
            }else{
                siftUpComparable(idx, target);
            }
        }

        private void siftUpComparator(int idx, E target, Comparator<? super E> comp ){
            // root 노드보다 클 떄까지만 탐색한다.
            while(idx > 1){
                int parent = getParent(idx); // 삽입노드의 부모노드 인덱스 구하기
                Object parentVal = array[parent]; // 부모노드 값

                // 타겟 노드 값이 부모노드보다 크면 반복문 종료
                if(comp.compare(target, (E) parentVal) >= 0){
                    break;
                }
                /*
                부모노드가 타겟노드보다 크므로
                현재 삽입 될 위치에 부모노드 값으로 교체해주고
                타겟 노드의 위치를 부모노드의 위치로 변경해준다.
                */
                array[idx] = parentVal;
                idx = parent;
            }
            array[idx] = target;
        }
        private void siftUpComparable(int idx, E target){
            // 타겟 노드가 비교 될 수 있도록 한 변수를 만든다.
            Comparable<? super E> comp = (Comparable<? super E>) target;

            while(idx > 1){
                int parent = getParent(idx);
                Object parentVal = array[parent];

                if(comp.compareTo((E)parentVal) >= 0){
                    break;
                }
                array[idx] = parentVal;
                idx = parent;
            }
            array[idx] = comp;
        }
    }
}
