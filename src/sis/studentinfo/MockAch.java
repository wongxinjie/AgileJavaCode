/**
*@Title:MockAch.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;
import java.util.*;
import com.jimbob.ach.*;

import static org.junit.Assert.*;

public class MockAch implements Ach{
	public AchResponse issueDebit(AchCredentials credentials, 
			AchTransactionData data){
		return null;
	}
	
	public AchResponse markTransactionAsNSF(AchCredentials credentials,
			AchTransactionData data, String traceCode){
		return null;
	}
	public AchResponse refundTransaction(AchCredentials credentials,
			AchTransactionData data, String traceCode){
		return null;
	}
	
	public AchResponse issueCredit(AchCredentials credentials,
			AchTransactionData data){
		return null;
	}
	
	public AchResponse voidSameDayTransaction(AchCredentials credentials,
			AchTransactionData data, String traceCode){
		return null;
	}
	
	public AchResponse queryTransactionStatus(AchCredentials credentials,
			AchTransactionData data, String traceCode){
		return null;
	}
}
