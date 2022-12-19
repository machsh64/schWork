package sc00;

/**
 * @program: easc
 * @description:
 * @author: Ren
 * @create: 2022-09-01 09:39
 **/
public class num {
    private int maxLength;
    private int[] a;
    private int size;

    public void SeqList(int maxLength) {
        this.maxLength = maxLength;
        a = new int[maxLength];
        size = 0;
    }


    public boolean deleteAllx1(int x) {
        if (size == 0) {
            System.out.println("没有数据可供删除");
            return false;
        }
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] != x) {
                a[k] = a[i];
                k++;
            }
        }
        size = k;
        return true;

    }

}
