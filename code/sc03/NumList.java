package sc03;

import org.junit.Test;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-15 10:28
 * @description: 建立顺序表 实现初始化，插入，删除，输出
 **/
public class NumList {

    int elemSize;   //顺序表实际长度
    int[] elm;      //顺序表

    public NumList() {
        this(10);         //在空参构造器中默认初始化长度为10 的顺序表
    }

    public NumList(int i) {
        elm = new int[i];         //带参构造器初始化顺序表
        elemSize = 0;      //将实际长度构造顺序表时初始为0
    }

    //判断顺序表是否已满
    public boolean isFull() {
        return elemSize == elm.length;
    }

    //插入数据
    public boolean inPut(int Val, int s) {     //Val为要插入的值，s为插入位置
        //首先判断顺序表是否已满
        if (isFull() || s < 0 || s > elemSize) {
            return false;
        }
        for (int i = elemSize - 1; i >= s; i--) {
            elm[i + 1] = elm[i];
        }
        elm[s] = Val;
        elemSize++;
        return true;
    }

    //删除数据
    public boolean delete(int s) {    //s为要删除的位置
        s -= 1;
        if (s < 0 || s >= elemSize) {
            return false;
        }
        for (int i = s; i < elemSize -1 ; i++) {
            elm[i] = elm[i + 1];
        }
        elemSize--;
        return true;
    }

    public void show() {
        for (int i = 0; i < elemSize; i++) {
            System.out.println(elm[i]);
        }
    }

    public static void main(String[] args) {
        NumList list = new NumList(5);

        for (int i = 0; i < list.elm.length; i++) {
            if (!list.isFull())                    //判断数组是否已满
                list.inPut(i+1,i);                     //遍历代替赋值
            else System.out.println("数组已满");
        }

        list.show();

        list.delete(3);        //删除操作

        System.out.println("***********");
        list.show();
    }
}


