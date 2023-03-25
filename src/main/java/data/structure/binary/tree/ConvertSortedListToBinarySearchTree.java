package data.structure.binary.tree;

import data.structure.linked.list.ListNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class ConvertSortedListToBinarySearchTree {
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        node = head;

        while (head != null) {
            size++;
            head = head.next;
        }

        return inorderTraverse(0, size - 1);
    }

    TreeNode inorderTraverse(int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;

        TreeNode left = inorderTraverse(l, mid - 1);

        TreeNode tree = new TreeNode();
        tree.val = node.val;
        node = node.next;
        tree.left = left;

        tree.right = inorderTraverse(mid + 1, r);

        return tree;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return buildTree(list, 0, list.size() - 1);
    }

    TreeNode buildTree(List<Integer> data, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode node = new TreeNode();
        int mid = l + (r - l) / 2;
        node.val = data.get(mid);

        node.left = buildTree(data, l, mid - 1);
        node.right = buildTree(data, mid + 1, r);

        return node;
    }
}
