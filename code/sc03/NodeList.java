package sc03;

import javax.xml.soap.Node;
import java.util.Scanner;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-15 11:08
 * @description: 单链表的初始化，插入，删除
 **/
public class NodeList {

    public static class Node {    //内部类创建单链
        Node next;   //指针
        int data;   //数据域

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;


    //插入数值
    public void addHead(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public int length() {
        int length = 0;
        Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    //按传入数值删除
    public void delete(int index) throws RuntimeException {
        index -= 1;
        Node temp = head;
        if (index < 0 || index > length()) {
            throw new RuntimeException("删除失败：链表中不存在此位置数值");
        } else if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    //打印数值
    public void show() {
        Node curNode = head;
        //检测此节点？为空
        while (curNode != null) {
            System.out.println(curNode.data + "  ");
            curNode = curNode.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        NodeList nodelist = new NodeList();
        Scanner scan = new Scanner(System.in);

        //头插法插入
        System.out.println("向链表中添加数值(按-1结束输入)");
        int data = scan.nextInt();
        while (data >= 0) {
            nodelist.addHead(data);
            data = scan.nextInt();
        }
        System.out.println("链表中的数值");
        nodelist.show();

        System.out.println("********");
        System.out.println("删除链表中指定位置的数值(按-1结束操作)");
        try {
            int index = scan.nextInt();
            while (index >= 0) {
                nodelist.delete(index);
                nodelist.show();
                index = scan.nextInt();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("链表中的数值");
        nodelist.show();

    }

}



