/**
*@Title:AccountTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jimbob.ach.*;

import java.math.BigDecimal;
import java.util.Date;

public class AccountTest {
	static final String ABA = "102000012";
	static final String ACCOUNT_NUMBER = "194431518811";
	
	private Account account;
	
	@Before
	public void setUp(){
		account = new Account();
		account.setBankAba(ABA);
		account.setBankAccountNumber(ACCOUNT_NUMBER);
		account.setBankAccountType(Account.BankAccountType.CHECKING);
	}
	
	@Test
	public void testTransaction() {
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.0"));
		assertEquals(new BigDecimal("11.10"), account.getBalance());
	}
	
	@Test
	public void testTransferFromBank(){
		Ach mockAch = new MockAch(){
			public AchResponse issueDebit(AchCredentials credentials, 
					AchTransactionData data){
				assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
				assertTrue(data.aba.equals(AccountTest.ABA));
				
				AchResponse response = new AchResponse();
				response.timestamp = new Date();
				response.traceCode = "1";
				response.status = AchStatus.SUCCESS;
				return response;
			}
		};
		account.setAch(mockAch);
		final BigDecimal amount = new BigDecimal("50.00");
		account.transferFromBank(amount);
		assertEquals(amount, account.getBalance());
	}

}
