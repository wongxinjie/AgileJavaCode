/**
*@Title:Account.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import java.math.BigDecimal;
import com.jimbob.ach.*;

public class Account implements Accountable{
	private BigDecimal balance;
	private int transactionCount;
	private String bankAba;
	private String bankAccountNumber;
	private BankAccountType bankAccountType;
	private Ach ach;
	
	public enum BankAccountType{
		CHECKING("ck"), SAVINGS("sv");
		private String value;
		private BankAccountType(String value){
			this.value = value;
		}
		
		@Override
		public String toString(){
			return value;
		}
	}
	
	public Account(){
		this.balance = new BigDecimal("0.0");
		this.transactionCount = 0;
	}
	
	public void credit(BigDecimal amount){
		/*
		 * ��:BigDecimal��String�кܶ�����֮��
		 * ��Ϊһ����
		 */
		balance = balance.add(amount);
		transactionCount++;
	}
	
	public BigDecimal getBalance(){
		return balance;
	}
	
	public BigDecimal transactionAverage(){
		return balance.divide(new BigDecimal(transactionCount), 
				BigDecimal.ROUND_HALF_UP);
	}
	
	public void setBankAba(String bankAba){
		this.bankAba = bankAba;
	}
	
	public void setBankAccountNumber(String bankAccountNumber){
		this.bankAccountNumber = bankAccountNumber;
	}
	
	public void setBankAccountType(Account.BankAccountType bankAccountType){
		this.bankAccountType = bankAccountType;
	}
	
	public void transferFromBank(BigDecimal amount){
		//AchCredentials credentials = createCredentials();
		//AchTransactionData data = createData(amount);
		
		//Ach ach = getAch();
		//AchResponse achResponse = ach.issueDebit(credentials, data);
		//credit(amount);
		AchResponse achResponse = getAch().issueDebit(createCredentials(), createData(amount));
		if(achResponse.status == AchStatus.SUCCESS) credit(amount);
	}
	
	private AchCredentials createCredentials(){
		AchCredentials credentials = new AchCredentials();
		credentials.merchantId="12355";
		credentials.userName="sismerc1920";
		credentials.password="pitseleh411";
		return credentials;
	}
	
	private AchTransactionData createData(BigDecimal amount){
		AchTransactionData data = new AchTransactionData();
		data.description="transfer from bank";
		data.amount = amount;
		data.aba = bankAba;
		data.account = bankAccountNumber;
		data.accountType = bankAccountType.toString();
		return data;
	}
	
	private Ach getAch(){
		return ach;
	}
	
	void setAch(Ach ach){
		this.ach = ach;
	}
}
