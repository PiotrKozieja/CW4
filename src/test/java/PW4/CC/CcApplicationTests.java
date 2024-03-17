package PW4.CC;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CcApplicationTests {

	@Test
	void isPossibleToAssignLimit(){
		//arrange
		CreditCard card = new CreditCard();
		//act
		card.AssignCreditCardLimit(BigDecimal.valueOf(1000));
		//Assert
		assertEquals(
				card.getCreditLimit(),
				BigDecimal.valueOf(1000));
	}
	@Test
	void isLimitUnderTreshold(){
		CreditCard card = new CreditCard();
		assertThrows(LimitBelowTresholdException.class,
				()-> card.AssignCreditCardLimit(BigDecimal.valueOf(50))

		);
	}
	@Test
	void isLimitAlreadyAssigned(){
		CreditCard card = new CreditCard();
		card.AssignCreditCardLimit(BigDecimal.valueOf(500));
		assertThrows(LimitAlreadyAssignedException.class,
				()-> card.AssignCreditCardLimit(BigDecimal.valueOf(500))
		);
	}
	@Test
	void isBalanceEqualsLimit(){
		CreditCard card = new CreditCard();
		card.AssignCreditCardLimit(BigDecimal.valueOf(500));
		card.getBalance().equals(card.getCreditLimit());
	}
	@Test
	void isPossibleToWithdraw(){
		CreditCard card = new CreditCard();
		card.AssignCreditCardLimit(BigDecimal.valueOf(500));
		card.withdraw(BigDecimal.valueOf(499));
	}
	@Test
	void isPossibleToWithdrawV2(){
		CreditCard card = new CreditCard();
		card.AssignCreditCardLimit(BigDecimal.valueOf(500));
		card.withdraw(BigDecimal.valueOf(500));
	}
	@Test
	void isWithdrawOverBalance(){
		CreditCard card = new CreditCard();
		card.AssignCreditCardLimit(BigDecimal.valueOf(500));
		assertThrows(WithdrawOverBalanceException.class,
				() -> card.withdraw(BigDecimal.valueOf(550))
				);
	}

}
