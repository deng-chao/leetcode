package name.dengchao.leetcode.bytedance.str;

import java.util.Arrays;
import java.util.HashMap;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> charMap = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            Integer cnt = charMap.get(s1.charAt(i));
            cnt = cnt == null ? 1 : cnt + 1;
            charMap.put(s1.charAt(i), cnt);
        }
        int n = 0, m = 0, l = s2.length();
        HashMap<Character, Integer> exploreMap = new HashMap<>(s1.length());
        exploreMap.putAll(charMap);
        while (n < l & m < l) {
            if (charMap.containsKey(s2.charAt(m)) && exploreMap.containsKey(s2.charAt(m))) {
                Integer cnt = exploreMap.get(s2.charAt(m));
                cnt = cnt - 1;
                exploreMap.put(s2.charAt(m), cnt);
                if (cnt == 0) {
                    exploreMap.remove(s2.charAt(m));
                }
                if (exploreMap.size() == 0) {
                    return true;
                }
                m++;
            } else {
                exploreMap = (HashMap<Character, Integer>) charMap.clone();
                n++;
                m = n;
            }
        }
        return false;
    }

    public boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Chars[s1.charAt(i) - 'a'] = s1Chars[s1.charAt(i) - 'a'] + 1;
            s2Chars[s2.charAt(i) - 'a'] = s2Chars[s2.charAt(i) - 'a'] + 1;
        }
        if (Arrays.equals(s1Chars, s2Chars)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            s2Chars[s2.charAt(i) - 'a'] = s2Chars[s2.charAt(i) - 'a'] + 1;
            s2Chars[s2.charAt(i - s1.length()) - 'a'] = s2Chars[s2.charAt(i - s1.length()) - 'a'] - 1;
            if (Arrays.equals(s1Chars, s2Chars)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : s1.toCharArray())
            c1[c - 'a']++;

        for (int i = 0; i < l2; i++) {
            if (i >= l1)
                --c2[s2.charAt(i - l1) - 'a'];
            c2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion test = new CheckInclusion();
//        long t1 = System.currentTimeMillis();
//        IntStream.range(0, 1_000_000).forEach(i -> test.checkInclusion("abcdxabcde", "abcdeabcdx"));
//        long t2 = System.currentTimeMillis();
//        IntStream.range(0, 1_000_000).forEach(i -> test.checkInclusion2("abcdxabcde", "abcdeabcdx"));
//        long t3 = System.currentTimeMillis();
//        IntStream.range(0, 1_000_000).forEach(i -> System.out.println(test.checkInclusion3("abcdxabcde", "abcdeabcdx")));
//        long t4 = System.currentTimeMillis();
//        System.out.println(t2 - t1);
//        System.out.println(t3 - t2);
//        System.out.println(t4 - t3);
        System.out.println(test.checkInclusion3("ab", "eidbaooo"));
    }
}
