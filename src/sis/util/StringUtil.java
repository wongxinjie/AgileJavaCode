/**
*@Title:StringUtil.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.util;

public class StringUtil {
	public static int occurrences(String string, String subString){
		int occurrences = 0;
		int length = subString.length();
		final boolean ignoreCase = true;
		for(int i=0; i < string.length()-subString.length()+1; i++){
			if(string.regionMatches(ignoreCase, i, subString, 0, length))
				occurrences++;
		}
		return occurrences;
	}
}
