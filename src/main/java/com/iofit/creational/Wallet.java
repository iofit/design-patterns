package com.iofit.creational;

import com.iofit.exceptions.NoMoneyException;

/**
 * Singleton example of a wallet
 */
public class Wallet {
    private static Wallet instance;
    private volatile int money;

    private Wallet() {
    }

    private Wallet(int money) {
        this.money = money;
    }

    public static Wallet getInstance() {
        synchronized (Wallet.class) {
            if (instance == null) {
                instance = new Wallet();
            }

        }
        return instance;
    }

    public static Wallet getInstance(int money) {
        synchronized (Wallet.class) {
            if (instance == null) {
                instance = new Wallet(money);
            }

        }
        return instance;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public synchronized void withdraw(int money) throws NoMoneyException {
        int withdrawalResult = this.money - money;
        if (withdrawalResult < 0) {
            throw new NoMoneyException();
        }
        this.money = withdrawalResult;
        System.out.printf("Total money left %s \n", this.money);
    }
}
