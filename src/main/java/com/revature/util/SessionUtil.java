package com.revature.util;

import java.util.UUID;


/**
 * 
 * @author teresafitzgerald
 *
 */
public class SessionUtil {

	/**
	 * Generates random String, using java.util.UUID class. The String value of
	 * random UUID is returned.
	 * 
	 * @return
	 */
	public static String createSessionToken() {
		return UUID.randomUUID().toString();
	}

//	TEST
//	public static void main(String[] args) {
//		System.out.println(createSessionToken().length());
//		System.out.println(createSessionToken());
//		System.out.println(createSessionToken());
//		System.out.println(createSessionToken());
//	}

}
