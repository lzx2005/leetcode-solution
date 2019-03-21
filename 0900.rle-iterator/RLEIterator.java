import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/rle-iterator/
 * 编写一个遍历游程编码序列的迭代器。
 * 迭代器由 RLEIterator(int[] A) 初始化，其中 A 是某个序列的游程编码。
 * 更具体地，对于所有偶数 i，A[i] 告诉我们在序列中重复非负整数值 A[i + 1] 的次数。
 * <p>
 * 迭代器支持一个函数：next(int n)，它耗尽接下来的  n 个元素（n >= 1）并返回以这种方式耗去的最后一个元素。
 * 如果没有剩余的元素可供耗尽，则  next 返回 -1 。
 * <p>
 * 例如，我们以 A = [3,8,0,9,2,5] 开始，这是序列 [8,8,8,5,5] 的游程编码。
 * 这是因为该序列可以读作 “三个八，零个九，两个五”。
 * <p>
 * Created by hzlizx on 2019/3/21
 */
public class RLEIterator {

    private int[] A;
    private int index = 0;

    public RLEIterator(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        int count = 0;
        while (index < A.length && n > A[index]) {
            n = n - A[index];
            A[index] = 0;
            index += 2;
        }
        if (index < A.length) {
            A[index] = A[index] - n;
            return A[index + 1];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 0, 9, 2, 5};
        RLEIterator rleIterator = new RLEIterator(a);
        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(2));
    }
}
