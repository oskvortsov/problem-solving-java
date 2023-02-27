package data.structure.binary.tree;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SerializeАndDeserializeBinaryTreeTest {
    @Test()
    public void case1() {
        SerializeАndDeserializeBinaryTree serialize = new SerializeАndDeserializeBinaryTree();
        TreeNode input = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3, new TreeNode(4), new TreeNode(5))
        );

//        assertThat(serialize.serialize(input)).isEqualTo("[1,2,3,null,null,4,5]");
        assertThat(serialize.serialize(input)).isEqualTo("1,2,#,#,3,4,#,#,5,#,#");
//        assertThat(serialize.deserialize("[1,2,3,null,null,4,5]")).isEqualToIgnoringNullFields(input);
//        assertThat(serialize.deserialize("1,2,#,#,3,4,#,#,5,#,#")).isEqualToIgnoringNullFields(input);
    }

    @Test()
    public void case2() {
        SerializeАndDeserializeBinaryTree serialize = new SerializeАndDeserializeBinaryTree();
        assertThat(serialize.serialize(null)).isEqualTo("[]");
        assertThat(serialize.deserialize("[]")).isEqualTo(null);
    }
}
