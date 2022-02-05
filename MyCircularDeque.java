package javaSePrictice;

import java.util.LinkedList;


class MyCircularDeque {
//    LinkedList<Integer> a=new LinkedList<>();
//    int size=0;
//    int tempsize=0;
//
//    /** Initialize your data structure here. Set the size of the deque to be k. */
//    public MyCircularDeque(int k) {
//        size=0;
//        tempsize=k;
//    }
//
//    /** Adds an item at the front of Deque. Return true if the operation is successful. */
//    public boolean insertFront(int value) {
//        if(size>=3){
//            return false;
//        }
//        a.addFirst(value);
//        size++;
//        return true;
//
//    }
//
//    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//    public boolean insertLast(int value) {
//        if(size>=3){
//            return false;
//        }
//
//        a.addLast(value);
//        size++;
//        return true;
//
//    }
//
//    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//    public boolean deleteFront() {
//        if(size<1){
//            return false;
//        }
//        a.removeFirst();
//        size--;
//        return true;
//
//    }
//
//    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//    public boolean deleteLast() {
//        if(size<1){
//            return false;
//        }
//        a.removeLast();
//        size--;
//        return true;
//
//    }
//
//    /** Get the front item from the deque. */
//    public int getFront() {
//        if(a.isEmpty()){
//            return -1;
//        }
//        int result=a.peekFirst();
//        a.addFirst(result);
//        return result;
//
//    }
//
//    /** Get the last item from the deque. */
//    public int getRear() {
//        if(a.isEmpty()){
//            return -1;
//        }
//        int result=a.peekLast();
//        a.addLast(result);
//        return result;
//
//    }
//
//    /** Checks whether the circular deque is empty or not. */
//    public boolean isEmpty() {
//        return size<=0;
//
//    }
//
//    /** Checks whether the circular deque is full or not. */
//    public boolean isFull() {
//        if(size>=3){
//            return true;
//        }
//        return false;
//    }
//}
//
// class MyCircularDeque {
//
//    // 1、不用设计成动态数组，使用静态数组即可
//    // 2、设计 head 和 tail 指针变量
//    // 3、head == tail 成立的时候表示队列为空
//    // 4、tail + 1 == head
//
//    private int capacity;
//    private int[] arr;
//    private int front;
//    private int rear;
//
//    /**
//     * Initialize your data structure here. Set the size of the deque to be k.
//     */
//    public MyCircularDeque(int k) {
//        capacity = k + 1;
//        arr = new int[capacity];
//
//        // 头部指向第 1 个存放元素的位置
//        // 插入时，先减，再赋值
//        // 删除时，索引 +1（注意取模）
//        front = 0;
//        // 尾部指向下一个插入元素的位置
//        // 插入时，先赋值，再加
//        // 删除时，索引 -1（注意取模）
//        rear = 0;
//    }
//
//    /**
//     * Adds an item at the front of Deque. Return true if the operation is successful.
//     */
//    public boolean insertFront(int value) {
//        if (isFull()) {
//            return false;
//        }
//        front = (front - 1 + capacity) % capacity;
//        arr[front] = value;
//        return true;
//    }
//
//    /**
//     * Adds an item at the rear of Deque. Return true if the operation is successful.
//     */
//    public boolean insertLast(int value) {
//        if (isFull()) {
//            return false;
//        }
//        arr[rear] = value;
//        rear = (rear + 1) % capacity;
//        return true;
//    }
//
//    /**
//     * Deletes an item from the front of Deque. Return true if the operation is successful.
//     */
//    public boolean deleteFront() {
//        if (isEmpty()) {
//            return false;
//        }
//        // front 被设计在数组的开头，所以是 +1
//        front = (front + 1) % capacity;
//        return true;
//    }
//
//    /**
//     * Deletes an item from the rear of Deque. Return true if the operation is successful.
//     */
//    public boolean deleteLast() {
//        if (isEmpty()) {
//            return false;
//        }
//        // rear 被设计在数组的末尾，所以是 -1
//        rear = (rear - 1 + capacity) % capacity;
//        return true;
//    }
//
//    /**
//     * Get the front item from the deque.
//     */
//    public int getFront() {
//        if (isEmpty()) {
//            return -1;
//        }
//        return arr[front];
//    }
//
//    /**
//     * Get the last item from the deque.
//     */
//    public int getRear() {
//        if (isEmpty()) {
//            return -1;
//        }
//        // 当 rear 为 0 时防止数组越界
//        return arr[(rear - 1 + capacity) % capacity];
//    }
//
//    /**
//     * Checks whether the circular deque is empty or not.
//     */
//    public boolean isEmpty() {
//        return front == rear;
//    }
//
//    /**
//     * Checks whether the circular deque is full or not.
//     */
//    public boolean isFull() {
//        // 注意：这个设计是非常经典的做法
//        return (rear + 1) % capacity == front;
//    }
//}


class MyCircularDeque {
    int[] arr;
    int size;
    int front;
    int last;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Deque size is less than 0!");
        }
        this.arr = new int[k];
        this.size = 0;
        this.front = 0;
        this.last = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == arr.length) {
            return false;
        }
        if (front == 0) {
            arr[arr.length - 1] = value;   //将头插的数据放在数组的末尾位置
            front = arr.length - 1;       //然后将数组往前移动一个位置
        } else {
            arr[--front] = value;
        }
        size ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == arr.length) {
            return false;
        }
        arr[last] = value;
        size ++;
        last = last == arr.length - 1 ? 0 : last + 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        front = front == arr.length - 1 ? 0 : front + 1;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (last == 0) {
            last = arr.length - 1;
        } else {
            last --;
        }
        size --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return last == 0 ? arr[arr.length - 1] : arr[last - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}



public class 设计循环双端队列问题 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque=new MyCircularDeque(3);
        myCircularDeque.insertFront(5);
        int result=myCircularDeque.getFront();
        System.out.println(result);
        boolean a=myCircularDeque.isEmpty();
        System.out.println(a);
    }
}
