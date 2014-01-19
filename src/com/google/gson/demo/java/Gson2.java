package com.google.gson.demo.java;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

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
