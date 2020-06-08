package name.dengchao.leetcode.bytedance.str;

import java.util.Arrays;

public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length(), l2 = num2.length(), l3 = l1 * l2 + 1, l4 = l1 + l2, y = 0;
        int[][] matrix = new int[l3][l4];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                matrix[y][i + j + 1] = num % 10;
                matrix[y][i + j] = num / 10;
                y++;
            }
        }
        int[] result = new int[l4];
        for (int i = 0; i < l4; i++) {
            int sum = 0;
            for (int j = 0; j < l3; j++) {
                sum = sum + matrix[j][i];
            }
            result[i] = sum;
        }
        System.out.println(Arrays.toString(result));
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] > 9) {
                result[i - 1] = result[i - 1] + (result[i] / 10);
                result[i] = result[i] % 10;
            }
        }
        String resultStr = "";
        int start = result[0] == 0 ? 1 : 0;
        for (int i = start; i < result.length; i++) {
            resultStr = resultStr + result[i];
        }
        System.out.println(resultStr);
        return resultStr;
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length(), l2 = num2.length(), l3 = l1 * l2 + 1, l4 = l1 + l2;
        int[] result = new int[l4];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] = result[i + j + 1] + num;
            }
        }
        System.out.println(Arrays.toString(result));
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] > 9) {
                result[i - 1] = result[i - 1] + (result[i] / 10);
                result[i] = result[i] % 10;
            }
        }
        String resultStr = "";
        int start = result[0] == 0 ? 1 : 0;
        for (int i = start; i < result.length; i++) {
            resultStr = resultStr + result[i];
        }
        System.out.println(resultStr);
        return resultStr;
    }

    public static void main(String[] args) {
        Multiply test = new Multiply();
        test.multiply2("68893076933314286352361452983319390898401964604249695833243594",
                "2573679909565709397375829357204773043933002572634481163198840438932447059228411859186497593756571");
        System.out.println(10 % 10);
        System.out.println(10 / 10);
    }
}
