package name.dengchao.leetcode.bytedance.str;

public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String[] parts = s.trim().split(" ");
        StringBuilder stb = new StringBuilder(parts[parts.length - 1]);
        for (int i = 1; i < parts.length; i++) {
            if (parts[parts.length - i - 1].equals("")) {
                continue;
            }
            stb.append(" ").append(parts[parts.length - i - 1]);
        }
        return stb.toString();
    }

    private String reverseWord(String word) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            stb.append(word.charAt(word.length() - 1 - i));
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("abs is a good word s!   "));
    }
}
