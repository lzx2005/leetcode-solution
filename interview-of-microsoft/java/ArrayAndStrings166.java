/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/166/
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings166 {

    public String reverseWords(String s) {
        String trim = s.trim();
        String[] arr = trim.split(" ");
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left++, right--);
        }
        StringBuilder result = new StringBuilder();
        for (String s1 : arr) {
            if (s1 != null && !s1.equals("")) {
                result.append(s1).append(" ");
            }
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private void swap(String[] s, int left, int right) {
        String tem = s[left];
        s[left] = s[right];
        s[right] = tem;
    }
}
