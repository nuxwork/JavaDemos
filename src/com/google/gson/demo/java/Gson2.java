package com.google.gson.demo.java;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Gson示例，演示Json字符串中的字段名与Entity中的字段名不一样时
 * 该如何进行映射。
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 19, 2014
 * @version 1.0
 */
public class Gson2
{
	private static final String TAG = "JavaDemos.Gson2";

	public static void main(String[] args)
	{
		Gson gson = new Gson();
		User user = new User("swordy", "abc");
		System.out.println(gson.toJson(user));

		String json = "{\"username\":\"swordy\",\"passwd\":\"abc\"}";
		System.out.println(gson.fromJson(json, User.class));
	}

	private static class User
	{
		@SerializedName("username")
		private String account;

		@SerializedName("passwd")
		private String password;

		public User(String account, String password)
		{
			this.account = account;
			this.password = password;
		}

		@Override
		public String toString()
		{
			return "user: [account: " + account + ", password: " + password + "]";
		}
	}
}
