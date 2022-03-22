package test.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {

		double amount = 200.0;
		double expectedValue = 196.0;
		Account account = AccountFactory.createEmptyAccount();

		account.deposit(amount);

		Assertions.assertEquals(expectedValue, account.getBalance());

	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {

		double expectedValue = 100.0;
		Account account = AccountFactory.createAccount(expectedValue);
		double amount = -200.00;

		account.deposit(amount);

		Assertions.assertEquals(expectedValue, account.getBalance());

	}

	@Test
	public void fullWithdrawShouldClearBalanceAndReturnWithdrawalValue() {

		double expectedValue = 0.0;
		double initialBalance = 300.0;
		Account account = AccountFactory.createAccount(initialBalance);

		double result = account.fullWithdraw();

		Assertions.assertTrue(expectedValue == account.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}

}
