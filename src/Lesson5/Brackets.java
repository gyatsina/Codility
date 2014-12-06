package Lesson5;

import java.util.Stack;

/**
 * Created by yaodh on 2014/12/6.
 * 1. Brackets
 * Determine whether a given string of parentheses is properly nested.
 * Task description
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * Write a function:
 * class Solution { public int solution(String S); }
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * Assume that:
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class Brackets {
    public int solution(String S) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(S.charAt(i));
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return 0;
                    else stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return 0;
                    else stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return 0;
                    else stack.pop();
                    break;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
