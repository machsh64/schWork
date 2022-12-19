package sc04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-20 23:10
 * @description: 数组模拟队列的创建判断字符串是否为回文
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("请输入数组长度：");
            int maxSize = scan.nextInt();
            ArrayQueue queue = new ArrayQueue(maxSize);

            System.out.println("输入一个字符串，以@为末尾符号");
            String str = scan.next();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '@') {
                    queue.addQueue(str.charAt(i));
                } else {
                    break;
                }
            }

            if (isOverCome(queue)) {
                System.out.println("该字符串是回文");
            } else {
                System.out.println("该字符串不是回文");
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("数据输入错误");
        }
    }

    //判断是否为回文
    public static boolean isOverCome(ArrayQueue queue) {
        int len = queue.length();
        char[] chars = new char[len];
        boolean isOverCome = true;
        for (int i = 0; i < len / 2; i++) {
            chars[i] = queue.getQueue();
            if (len % 2 != 0) {
                queue.getQueue();
            }
        }

        int len1 = queue.length();
        for (int i = len1 - 1; i >= 0; i--) {
            if (queue.getQueue() != chars[i]) {
                isOverCome = false;
                break;
            }
        }
        return isOverCome;
    }
}

//使用数组模拟队列--编写一个ArrayQueue类
class ArrayQueue {
    private final int maxSize;  //表示数组的最大容量
    private int front;   //队列头
    private int rear;   // 队列尾
    private final char[] arr;   // 该数据用于存放数据，模拟队列

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new char[maxSize];
        front = -1;   //指向队列头部，分析出front是指向队列头的前一个位置。
        rear = -1;   //指向队列尾，指向队列尾的具体数据（即就是队列最后一个数据）
    }

    public int length() {
        return rear - front;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(char str) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        rear++;  //让rear 后移
        arr[rear] = str;
    }

    //获取队列的数据 出队列
    public char getQueue() throws RuntimeException {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常来处理
            throw new RuntimeException("队列为空，不能获取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {         //用数组方式遍历显示所有元素，在队列中不可用此方法出队列
        if (isEmpty()) {
            System.out.println("对列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

}