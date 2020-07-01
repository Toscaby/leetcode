package hash;

import java.util.HashMap;

/**
 * @author Tosca
 * @date 1/7/2020
 */
public class ValidAnagram {
  HashMap<Character, Integer> map1 = new HashMap<>();
  HashMap<Character, Integer> map2 = new HashMap<>();
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length())
      return false;

    for (int i = 0; i < s.length(); ++i) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      map1.put(c1, map1.getOrDefault(c1, 0) + 1);
      map2.put(c2, map2.getOrDefault(c2, 0) + 1);
    }

    for (Character c : map1.keySet()) {
      if (!map2.getOrDefault(c, 0).equals(map1.get(c))) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram2(String s, String t) {
    if (s == null || t == null || s.length() != t.length())
      return false;

    int[] dic1 = new int[26];
    int[] dic2 = new int[26];

    for (int i = 0; i < s.length(); ++i) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      dic1[c1 - 'a'] += 1;
      dic2[c2 - 'a'] += 1;
    }

    for (int i = 0; i < 26; ++i) {
      if (dic1[i] != dic2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "a";
    String t = "ab";
    ValidAnagram va = new ValidAnagram();
    System.out.println(va.isAnagram2(s, t));
  }
}
