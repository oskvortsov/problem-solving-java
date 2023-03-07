package data.structure.binary.tree;

import org.junit.Test;
import topic.binary.search.FindDuplicateSubtrees;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindDuplicateSubtreesTest {
    FindDuplicateSubtrees obj = new FindDuplicateSubtrees();

    @Test()
    public void case1() {
        TreeNode root = new TreeNode(
                0,
                new TreeNode(2, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(3), null)
        );
        List<TreeNode> res = obj.findDuplicateSubtrees(root);
        assertThat(res.size()).isEqualTo(2);
    }

    @Test()
    public void case2() {
        TreeNode root = new TreeNode(
                2,
                new TreeNode(2, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(3), null)
        );
        List<TreeNode> res = obj.findDuplicateSubtrees(root);
        assertThat(res.size()).isEqualTo(2);
    }
}

