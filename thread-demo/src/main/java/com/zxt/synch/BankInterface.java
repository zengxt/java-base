package com.zxt.synch;

/**
 * A bank with a number of bank accounts.
 */
public abstract class BankInterface {
    protected final double[] accounts;

    /**
     * Constructs the bank.
     *
     * @param n              the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public BankInterface(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++)
            accounts[i] = initialBalance;
    }

    /**
     * Transfers money from one account to another.
     *
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    protected abstract void transfer(int from, int to, double amount) throws InterruptedException;

    /**
     * Gets the sum of all account balances.
     *
     * @return the total balance
     */
    protected abstract double getTotalBalance();

    /**
     * Gets the number of accounts in the bank.
     *
     * @return the number of accounts
     */
    protected int size() {
        return accounts.length;
    }
}