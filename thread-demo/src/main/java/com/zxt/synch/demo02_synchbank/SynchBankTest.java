package com.zxt.synch.demo02_synchbank;

import com.zxt.synch.TransferRunnable;

/**
 * This program shows how multiple threads can safely access a data structure.
 */
public class SynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable transferRunnable = new TransferRunnable(b, i, INITIAL_BALANCE);
            new Thread(transferRunnable).start();
        }
    }
}