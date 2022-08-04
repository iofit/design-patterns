package creational.prototype;

import com.iofit.creational.prototype.Cellphone;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCellphone {

    @Test
    public void testCellphone(){
        Cellphone c1 = new Cellphone();
        Cellphone c2 = c1.clone();

        assertThat(c1).isNotEqualTo(c2);
        assertThat(c1.getFingerprintReader()).isNotEqualTo(c2.getFingerprintReader());
        assertThat(c1.getScreen()).isEqualTo(c2.getScreen());
        assertThat(c1 == c2).isFalse();
        assertThat(c1.getHeadphonesJack()).isNotEqualTo(c2.getHeadphonesJack());
        assertThat(c1.getServiceProviderChip()).isNotEqualTo(c2.getServiceProviderChip());

    }
}
