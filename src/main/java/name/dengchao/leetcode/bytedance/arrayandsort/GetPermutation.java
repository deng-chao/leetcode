package name.dengchao.leetcode.bytedance.arrayandsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetPermutation {

    public String getPermutation(int n, int k) {
        k = k - 1;
        List<Integer> values = new LinkedList<>();
        for (int i = 1; i <= n; i++) values.add(i);
        List<Integer> coefficients = new ArrayList<>();
        while (n > 0) {
            int factorial = factorial(n - 1);
            coefficients.add(k / factorial);
            k = k % factorial;
            n--;
        }
        StringBuilder stb = new StringBuilder();
        for (int coefficient : coefficients) {
            stb.append(values.get(coefficient));
            values.remove(coefficient);
        }
        return stb.toString();
    }

    private int factorial(int n) {
        if (n == 0) return 1;
        int result = n;
        for (int i = 1; i < n; i++) result = result * i;
        return result;
    }

    public static void main(String[] args) {
        GetPermutation test = new GetPermutation();
//        List<Integer> result = new ArrayList<>();
//        int n = 3, k = 5;
//        test.dividAndMod(n, k - 1, result);
//        System.out.println(result);
        System.out.println(test.getPermutation(3, 2));
    }
}
