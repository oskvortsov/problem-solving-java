package others;

//  https://leetcode.com/problems/design-browser-history/
public class BrowserHistory {
    private String[] history;
    private int index;
    private int size;

    public BrowserHistory(String homepage) {
        history = new String[10];
        index = 0;
        history[index] = homepage;
    }

    public void visit(String url) {
        checkAvailableSpace();
        history[++index] = url;
        size = index + 1;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return history[index];
    }

    public String forward(int steps) {
        index = Math.min(index + steps, size - 1);
        return history[index];
    }

    private void checkAvailableSpace() {
        if (index + 1 < history.length) {
            return;
        }

        String[] newHistory = new String[history.length * 2];
        System.arraycopy(history, 0, newHistory, 0, size);

        history = newHistory;
    }
}
