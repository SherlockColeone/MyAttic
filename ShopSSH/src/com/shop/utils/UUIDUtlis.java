package com.shop.utils;

import java.util.UUID;

/**
 * @version 1.0
 * @author  天王盖地虎
 *
 */
public class UUIDUtlis {
	/**
	 * 获取带有横线的uuid
	 * @return
	 */
	public static String getUUID()
	{
	   return UUID.randomUUID().toString();	
	}
	/**
	 * 获取不带有横线的uuid
	 * @return
	 */
	public static String getUUID2()
	{
	  return UUID.randomUUID().toString().replace("-", "");	
	}
}
