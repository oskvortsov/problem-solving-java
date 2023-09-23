package data.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(1, 0, n, "(", ans);

        return ans;
    }

    private void backtrack(int opened, int closed, int n, String stack, List<String> ans) {
        if (opened == n && closed == n) {
            ans.add(stack);
            return;
        }

        if (opened < n) {
            backtrack(opened + 1, closed, n, stack + "(", ans);
        }

        if (closed < opened) {
            backtrack(opened, closed + 1, n, stack + ")", ans);
        }
    }

    private void backtrackStack(int opened, int closed, int n, Stack<String> stack, List<String> ans) {
        if (opened == n && closed == n) {
            ans.add(String.join("", stack));
            return;
        }

        if (opened < n) {
            stack.push("(");
            backtrackStack(opened + 1, closed, n, stack, ans);
            stack.pop();
        }

        if (closed < opened) {
            stack.push(")");
            backtrackStack(opened, closed + 1, n, stack, ans);
            stack.pop();
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        generate(1, 0, n, "(", ans);
        return ans;
    }

    private void generate(int l, int r, int n, String cur, List<String> ans) {
        if (l > n || r > n || r > l) return;

        if (l == n && r == n) {
            ans.add(cur);
            return;
        }

        generate(l + 1, r, n, cur + '(', ans);
        generate(l, r + 1, n, cur + ')', ans);
    }
}
