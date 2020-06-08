package name.dengchao.leetcode.bytedance.str;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }
        String prefix = "";
        boolean mismatch = false;
        while (i < minLength) {
            char currentChar = 0;
            for (String str : strs) {
                if (currentChar == 0) {
                    currentChar = str.charAt(i);
                    continue;
                }
                if (currentChar != str.charAt(i)) {
                    mismatch = true;
                    break;
                }
            }
            if (mismatch) {
                break;
            }
            prefix = prefix + currentChar;
            i++;
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }
        boolean mismatch = false;
        String firstStr = strs[0];
        while (i < minLength) {
            for (int n = 1; n < strs.length; n++) {
                if (firstStr.charAt(i) != strs[n].charAt(i)) {
                    mismatch = true;
                    break;
                }
            }
            if (mismatch) {
                break;
            }
            i++;
        }
        return firstStr.substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        System.out.println(test.longestCommonPrefix2(new String[]{"aa", "a"}));
    }
}
