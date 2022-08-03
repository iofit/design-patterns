package creational.factory;

import com.iofit.creational.factory.Car;
import com.iofit.creational.factory.CarFactory;
import com.iofit.creational.factory.Cars;
import com.iofit.exceptions.NotAvailableCarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestCarFactory {

    @Test
    public void testCarFactory() throws NotAvailableCarException {
        CarFactory factory = CarFactory.getInstance();
        Car mustang = factory.buildCar(Cars.FORD);
        Car beetle = factory.buildCar(Cars.VOLKSWAGEN);

        mustang.accelerate();
        beetle.accelerate();

        assertThat(mustang.getMaker()).isEqualTo(Cars.FORD.getName());
        assertThat(beetle.getMaker()).isEqualTo(Cars.VOLKSWAGEN.getName());
    }

    @Test
    public void testNotAvailableCarException() {
        Assertions.assertThrows(NotAvailableCarException.class, () -> {
           CarFactory.getInstance().buildCar(Cars.CHEVY);
        });
    }
}
