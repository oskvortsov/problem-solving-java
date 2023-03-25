package data.structure.linked.list;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeKSortedListsTest {
    MergeKSortedLists obj = new MergeKSortedLists();

    @Test()
    public void case1() {
        ListNode[] input = new ListNode[] {
                new ListNode(-2, new ListNode(-1, new ListNode(-1, new ListNode(-1)))),
                null
        };

        ListNode mergeList = obj.mergeKLists(input);

        assertThat(mergeList.val).isEqualTo(-2);
    }
}

