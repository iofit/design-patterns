package creational.abstractfactory;

import com.iofit.creational.abstractfactory.ComputerFactory;
import com.iofit.creational.abstractfactory.apple.AppleComputerFactory;
import com.iofit.creational.abstractfactory.apple.MacbookPro;
import com.iofit.creational.abstractfactory.arm.ARMComputerFactory;
import com.iofit.creational.abstractfactory.arm.ARMLaptop;
import com.iofit.creational.abstractfactory.windows.WindowsComputerFactory;
import com.iofit.creational.abstractfactory.windows.WindowsLaptop;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAbstractComputerFactory {

    @Test
    public void testAbstractComputerFactory(){

        ComputerFactory windowsComputerFactory = new WindowsComputerFactory();
        ComputerFactory appleComputerFactory = new AppleComputerFactory();
        ComputerFactory armComputerFactory = new ARMComputerFactory();

        assertThat(windowsComputerFactory.createLaptop()).isInstanceOf(WindowsLaptop.class);
        assertThat(appleComputerFactory.createLaptop()).isInstanceOf(MacbookPro.class);
        assertThat(armComputerFactory.createLaptop()).isInstanceOf(ARMLaptop.class);
    }
}
