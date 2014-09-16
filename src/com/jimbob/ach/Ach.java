/**
*@Title:Ach.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package com.jimbob.ach;

public interface Ach {
	public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data);
	public AchResponse markTransactionAsNSF(AchCredentials credentials,
			AchTransactionData data, String traceCode);
	public AchResponse refundTransaction(AchCredentials credentials,
			AchTransactionData data, String traceCode);
	public AchResponse issueCredit(AchCredentials credentials,
			AchTransactionData data);
	public AchResponse voidSameDayTransaction(AchCredentials credentials,
			AchTransactionData data, String traceCode);
	public AchResponse queryTransactionStatus(AchCredentials credentials,
			AchTransactionData data, String traceCode);
}
