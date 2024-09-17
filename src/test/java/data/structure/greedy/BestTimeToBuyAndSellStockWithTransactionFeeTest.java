package data.structure.greedy;

import org.junit.Test;
import topic.greedy.BestTimeToBuyAndSellStockWithTransactionFee;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BestTimeToBuyAndSellStockWithTransactionFeeTest {
    @Test()
    public void case1() {
        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
        assertThat(obj.maxProfit(new int[] { 1,3,2,8,4,9 }, 2)).isEqualTo(8);
    }

    @Test()
    public void case2() {
        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
        assertThat(obj.maxProfit(new int[] { 1,3,7,5,10,3 }, 3)).isEqualTo(6);
    }

//    @Test()
//    public void case3() {
//        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
//        assertThat().isEqualTo();
//    }
}
