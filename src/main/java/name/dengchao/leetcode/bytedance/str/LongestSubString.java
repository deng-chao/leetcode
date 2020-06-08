package name.dengchao.leetcode.bytedance.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubString {

    public int lengthOfLongestSubString(String s) {
        if (s == null) {
            return 0;
        }
        int l = s.length();
        int i = 0, j = 0, result = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < l && j < l) {
            char currentChar = s.charAt(j);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                j = j + 1;
                result = Math.max(result, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] vis = new int[257];
        int len = s.length();
        int left = -1;
        Arrays.fill(vis, -1);
        for (int i = 0; i < len; i++) {
            if (vis[s.charAt(i)] > left) {
                left = vis[s.charAt(i)];
            }
            ans = Math.max(ans, i - left);
            vis[s.charAt(i)] = i;
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        int l = s.length();
        int result = 0, i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < l && j < l) {
            char currentChar = s.charAt(j);
            System.out.println("i: " + i + ", j: " + j + ", map: " + map + ", currentChar: " + currentChar);
            if (!map.containsKey(currentChar) || map.get(currentChar) < i) {
                map.put(currentChar, j);
                j++;
                result = Math.max(result, j - i);
            } else {
                i = Math.max(i, map.get(currentChar));
                map.put(currentChar, j);
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubString test = new LongestSubString();
        System.out.println(test.lengthOfLongestSubstring2("abcabcbb"));
    }
}
