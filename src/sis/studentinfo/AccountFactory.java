/**
*@Title:AccountFactory.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;
import java.lang.reflect.*;
import sis.security.*;

public class AccountFactory {
	public static Accountable create(Permission permission){
		if(permission == Permission.UPDATE ) return new Account();
		if(permission == Permission.READ_ONLY) return createSecuredAccount();
		return null;
	}
	
	private static Accountable createSecuredAccount(){
		SecureProxy secureAccount = new SecureProxy(new Account(),
				"credit",
				"setBankAba",
				"setBankAccountNumber",
				"setBankAccountType",
				"transferFromBank");
		return (Accountable)Proxy.newProxyInstance(
				Accountable.class.getClassLoader(),
				new Class[] {Accountable.class},
				secureAccount);
	}
}
