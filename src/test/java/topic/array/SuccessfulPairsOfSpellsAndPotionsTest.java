package topic.array;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SuccessfulPairsOfSpellsAndPotionsTest {
    SuccessfulPairsOfSpellsAndPotions obj = new SuccessfulPairsOfSpellsAndPotions();

    @Test()
    public void case1() {
        assertThat(obj.successfulPairs(new int[] { 5,1,3 }, new int[] { 1,2,3,4,5 }, 7)).isEqualTo(new int[] { 4, 0, 3});
    }

    @Test()
    public void case2() {
        try {
            Gson parser = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/test/java/topic/array/files/SuccessfulPairsOfSpellsAndPotionsTestArr1.json"));

            ArrayList<Integer> list = parser.fromJson(reader, ArrayList.class);
            int[] potions = new int[list.size()];
            Arrays.setAll(potions, list::get);
            reader.close();


            assertThat(obj.successfulPairs(new int[] { 77508 }, potions, 5433930978L)).isEqualTo(new int[] { 15309 });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

