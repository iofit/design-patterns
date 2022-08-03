package creational.singleton;

import com.iofit.creational.singleton.Wallet;
import com.iofit.exceptions.NoMoneyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class TestWallet {

    @Test
    public void testCreateMultipleSequentialInstances() {
        List<Wallet> singletonList = Arrays.stream(new Wallet[100]).map(it -> it = Wallet.getInstance()).toList();

        for(int i=0; i< singletonList.size(); i++) {
            Wallet currentInstance = singletonList.get(i);
            for(int j=0; j< singletonList.size(); j++) {
                if(i == j) {
                    continue;
                }
                assertThat(currentInstance).isNotNull();
                assertThat(currentInstance).isEqualTo(singletonList.get(j));
            }
        }
    }

    @Test
    public void testWalletRunsOutOfMoney() {
        Wallet wallet1 = Wallet.getInstance(2000); // Since this instanced the first object
        Wallet wallet2 = Wallet.getInstance(3000); // This one is the original one with 2000
        AtomicInteger i= new AtomicInteger();
        Assertions.assertThrows(NoMoneyException.class, () -> {
            for(; ; i.addAndGet(100)){
                wallet1.withdraw(i.get());
                wallet2.withdraw(i.get());
            }
        });

        /**
         * Withdraws occur as follows (initial 2000):
         * W1, W2
         * 0, 0
         * 100, 100 => 1800
         * 200, 200 => 1400
         * 300, 300 => 800
         * 400, 400 => 0
         * 500, 500 => -1000 which throws the exception
         */
        assertThat(i.get()).isEqualTo(500);
    }

    @Test
    public void testInMultithreadEnvironment() throws InterruptedException {
        Thread firstThread = new Thread(() -> {
            Wallet wallet = Wallet.getInstance(1000);
            for(int i=0; i<50; i++) {
                try {
                    System.out.println("Removing 10");
                    wallet.withdraw(10);
                } catch (NoMoneyException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread secondThread = new Thread(() -> {
            Wallet wallet = Wallet.getInstance(1000);
            for(int i=0; i<50; i++) {
                try {
                    System.out.println("Removing 5");
                    wallet.withdraw(5);
                } catch (NoMoneyException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        secondThread.start();
        firstThread.start();

        // Wait for threads to finish
        firstThread.join();
        secondThread.join();
        assertThat(Wallet.getInstance().getMoney()).isEqualTo(1000 - (50*10) - (50*5));
    }

}
