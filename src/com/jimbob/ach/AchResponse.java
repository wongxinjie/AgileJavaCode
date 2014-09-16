/**
*@Title:AchResponse.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package com.jimbob.ach;

import java.util.*;

public class AchResponse {
	public Date timestamp;
	public String traceCode;
	public AchStatus status;
	public List<String> errorMessages;
}
