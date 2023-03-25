package topic.tree;

public class ConstructQuadTree {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    public Node construct(int[][] grid) {
        return traverse(0, grid.length - 1, 0, grid.length - 1, grid);
    }

    private Node traverse(int rowLeft, int rowRight, int colLeft, int colRight, int[][] grid) {
        if (rowLeft > rowRight) return null;

        boolean isLeaf = isLeaf(rowLeft, rowRight, colLeft, colRight, grid);
        Node node = new Node(grid[rowLeft][colLeft] == 1, isLeaf);

        if (!isLeaf) {
            int midRow = rowLeft + (rowRight - rowLeft) / 2;
            int midCol = colLeft + (colRight - colLeft) / 2;

            node.topLeft = traverse(rowLeft, midRow, colLeft, midCol, grid);
            node.topRight = traverse(rowLeft, midRow, midCol + 1, colRight, grid);

            node.bottomLeft = traverse(midRow + 1, rowRight, colLeft, midCol, grid);
            node.bottomRight = traverse(midRow + 1, rowRight, midCol + 1, colRight, grid);
        }

        return node;
    }

    private boolean isLeaf(int rowLeft, int rowRight, int colLeft, int colRight, int[][] grid) {
        int val = grid[rowLeft][colLeft];
        int size = rowRight - rowLeft;

        for (int i = 0; i <= size; i++) {
            if (
                    grid[rowLeft + i][colLeft + i] != val || grid[rowLeft + i][colRight - i] != val || // diagonal
                    grid[rowLeft + i][colLeft] != val || grid[rowLeft + i][colRight] != val || // check left and right vertical border value
                    grid[rowLeft][colLeft + i] != val || grid[rowRight][colLeft + i] != val // check top and bottom horizontal border value

            ) {
                return false;
            }
        }

        return true;
    }

}
