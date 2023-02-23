package topic.string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NamingACompanyTest {
    @Test()
    public void case1() {
        NamingACompany namingACompany = new NamingACompany();
        assertThat(namingACompany.distinctNames(new String[] { "aaa","baa","caa","bbb","cbb","dbb" })).isEqualTo(2);
        assertThat(namingACompany.distinctNames(new String[] { "back","lack" })).isEqualTo(0);
        assertThat(namingACompany.distinctNames(new String[] { "coffee","donuts","time","toffee" })).isEqualTo(6);
    }
}

