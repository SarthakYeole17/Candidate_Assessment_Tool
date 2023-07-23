package com.company.test;

public class TempUserData 
{
	static String email;
	static int jid;
	static int hid;
	
	public static int getJid() {
		return jid;
	}

	public static void setJid(int jid) {
		TempUserData.jid = jid;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		TempUserData.email = email;
	}

	public static int getHid() {
		return hid;
	}

	public static void setHid(int hid) {
		TempUserData.hid = hid;
	}
	
	
}
