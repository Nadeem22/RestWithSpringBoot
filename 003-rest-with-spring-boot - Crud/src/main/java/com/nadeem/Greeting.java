package com.nadeem;

public class Greeting {
	private final long id;
	private final String constant;

	public Greeting(long id, String constant) {
		this.id = id;
		this.constant = constant;
	}

	public long getId() {
		return id;
	}

	public String getConstant() {
		return constant;
	}
}
