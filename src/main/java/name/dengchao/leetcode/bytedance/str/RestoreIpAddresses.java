package name.dengchao.leetcode.bytedance.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List resultList = new ArrayList();
        if (s.length() > 14) {
            return resultList;
        }
        Set<String> results = new HashSet<>();
        for (int c = s.length() - 1; c > 1; c--) {
            for (int a = 1; a < s.length() - 2; a++) {
                for (int b = a + 1; b < c; b++) {
                    if (a > 3 || (b - a) > 3 || (c - b) > 4 || (s.length() - c) > 3) continue;
                    String part1Str = s.substring(0, a);
                    String part2Str = s.substring(a, b);
                    String part3Str = s.substring(b, c);
                    String part4Str = s.substring(c);
                    if ((part1Str.length() > 1 && part1Str.startsWith("0")) || (part2Str.length() > 1 && part2Str.startsWith("0"))
                            || (part3Str.length() > 1 && part3Str.startsWith("0")) || (part4Str.length() > 1 && part4Str.startsWith("0")))
                        continue;
                    long part1 = Long.valueOf(part1Str);
                    long part2 = Long.valueOf(part2Str);
                    long part3 = Long.valueOf(part3Str);
                    long part4 = Long.valueOf(part4Str);
                    if (part1 < 256 && part2 < 256 && part3 < 256 && part4 < 256) {
                        results.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }
        resultList.addAll(results);
        return resultList;
    }

    public static void main(String[] args) {
        RestoreIpAddresses test = new RestoreIpAddresses();
        System.out.println(test.restoreIpAddresses("010010"));
    }
}
