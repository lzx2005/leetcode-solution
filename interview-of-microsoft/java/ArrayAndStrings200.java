import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/200/
 * Created by hzlizx on 2019/4/2
 */
public class ArrayAndStrings200 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            hash.computeIfAbsent(s, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(hash.values());
    }
}
