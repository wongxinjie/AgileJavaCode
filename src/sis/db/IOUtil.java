/**
*@Title:IOUtil.java
*@Description:《Agile Java》里关于RandomAccessFile的一个例子。
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.db;
import java.io.*;

public class IOUtil{
	public static boolean delete(String... filenames){
		boolean deleteAll = true;
		for(String filename: filenames){
			if( (new File(filename)).delete()){
				deleteAll = false;
			}
		}
		return deleteAll;
	}
}
