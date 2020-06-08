package name.dengchao.leetcode.model;

import org.junit.Assert;
import org.junit.Test;

public class SkipListTest {


    @Test
    public void testRandomLevel() {
        int cnt = 0;
        int pow = 5;
        int expect = 1000;
        for (int i = 0; i < ((int) Math.pow(2, pow) * expect); i++) {
            int level = SkipList.randomLevel(10);
            if (level > pow) {
                cnt++;
            }
        }
        System.out.println(cnt);
        Assert.assertTrue(cnt > expect - (expect / 10) && cnt < expect + (expect / 10));
    }

    @Test
    public void testConstruct() {
        SkipList<Integer> list = new SkipList<>(3);
        list.add(0);
        System.out.println(list);
    }

    @Test
    public void testAdd() {
        SkipList<Integer> list = new SkipList<>(3);
        list.add(10);
        list.add(12);
        list.add(15);
        list.add(30);
        list.add(7);
        System.out.println(list);
    }
}
