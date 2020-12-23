package nql.string;

import java.awt.*;
import java.util.Scanner;

/**
 * @author nql
 * @version 1.0
 * @date 2020/12/23 10:55
 */
public class manacher {

    public String preProcess(String s) {
        int len = s.length();
        if (len == 0) {
            return "$^";
        }
        StringBuilder t = new StringBuilder();
        t.append("$");
        for (int i = 0; i < len; i++) {
            t.append("#");
            t.append(s.charAt(i));
        }
        t.append("#");
        t.append("^");

        return t.toString();
    }

    public String longestPalindrome(String s) {
        String t = preProcess(s);
        int len = t.length();
        int[] p = new int[len];
        int C = 0, R = 0;
        for (int i = 1; i < len - 1; i++) {
            int mirror = 2 * C - i;
            if (R > i) {
                p[i] = Math.min(p[mirror], R - i);
            } else {
                p[i] = 0;
            }

            while (t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            if (i + p[i] > R) {
                R = i + p[i];
                C = i;
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < len - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start,start+maxLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String answer = new manacher().longestPalindrome(s);
        System.out.println(answer);
    }
}
