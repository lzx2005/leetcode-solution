/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/171/
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings171 {

    public int myAtoi(String str) {
        String trim = str.trim();
        char[] chars = trim.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length == 1 && isPlusOrMins(chars[0])) {
            return 0;
        }
        if (!isNumber(chars[0]) && !isPlusOrMins(chars[0])) {
            return 0;
        }
        int i;
        for (i = 1; i < chars.length; i++) {
            if (!isNumber(chars[i])) {
                break;
            }
        }
        String substring = trim.substring(0, i);
        if (substring.length() == 1 && isPlusOrMins(substring.charAt(0))) {
            return 0;
        }
        try {
            int result = Integer.parseInt(substring);
            if (!substring.startsWith("-") && result == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return result;
        } catch (NumberFormatException e) {
            return chars[0] == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    private boolean isPlusOrMins(char c) {
        return c == '-' || c == '+';
    }

    private boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        int i = new ArrayAndStrings171().myAtoi(s);
        System.out.println(i);
    }
}
