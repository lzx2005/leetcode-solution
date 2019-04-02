/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/162/
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings162 {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        while (left < right) {
            char leftChar = chars[left];
            char rightChar = chars[right];
            if (nonLetter(leftChar) && nonNumber(leftChar)) {
                left++;
                continue;
            }
            if (nonLetter(rightChar) && nonNumber(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean nonLetter(char c) {
        return c < 97 || c > 122;
    }

    private boolean nonNumber(char c) {
        return c < 48 || c > 57;
    }


    public static void main(String[] args) {
        String s = "0P";
        boolean palindrome = new ArrayAndStrings162().isPalindrome(s);
    }
}
