/**
*@Title:AccountFactoryTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.math.*;
import java.util.*;
import java.lang.reflect.*;

import sis.security.*;

public class AccountFactoryTest {
	List<Method> updateMethods;
	List<Method> readOnlyMethods;
	
	@Before
	public void setUp() throws Exception {
		updateMethods = new ArrayList<Method>();
		addUpdateMethod("setBankAba", String.class);
		addUpdateMethod("setBankAccountNumber", String.class);
		addUpdateMethod("setBankAccountType", Account.BankAccountType.class);
		addUpdateMethod("transferFromBank", BigDecimal.class);
		addUpdateMethod("credit", BigDecimal.class);
		
		readOnlyMethods = new ArrayList<Method>();
		addReadOnlyMethod("getBalance");
		addReadOnlyMethod("transactionAverage");
		
	}
	
	private void addUpdateMethod(String name, Class parmClass) throws Exception{
		updateMethods.add(Accountable.class.getDeclaredMethod(name, parmClass));
	}
	
	private void addReadOnlyMethod(String name) throws Exception{
		Class[] noParms = new Class[] {};
		readOnlyMethods.add(Account.class.getDeclaredMethod(name, noParms));
	}
	
	@Test
	public void testUpdateAccess() throws Exception{
		Accountable account = AccountFactory.create(Permission.UPDATE);
		for(Method method: readOnlyMethods){
			verifyNoException(method, account);
		}
		for(Method method: updateMethods){
			verifyNoException(method, account);
		}
	}
	
	@Test
	public void testReadOnlyAccess() throws Exception{
		Accountable account = AccountFactory.create(Permission.READ_ONLY);
		for(Method method: readOnlyMethods){
			verifyNoException(method, account);
		}
		for(Method method: updateMethods){
			verifyException(PermissionException.class, method, account);
		}
	}
	
	private void verifyException(Class exceptionType, Method method, 
			Object object) throws Exception{
		try{
			method.invoke(object, nullParmsFor(method));
			fail("expected expection");
		}catch(InvocationTargetException e){
			assertEquals("expected expection", exceptionType, e.getCause().getClass());
		}
	}
	
	private void verifyNoException(Method method, Object object) throws Exception{
		try{
			method.invoke(object, nullParmsFor(method));
		}catch(InvocationTargetException e){
			assertFalse("unexpected permission exception", 
					PermissionException.class == e.getCause().getClass());
		}
	}
	
	private Object[] nullParmsFor(Method method){
		return new Object[method.getParameterTypes().length];
	}
}
