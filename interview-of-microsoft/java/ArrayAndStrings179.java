import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/213/
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings179 {

    private static final HashMap<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character peek = stack.peek();
                if (peek != map.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

}
