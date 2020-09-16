package com.gessica.service02.pojo;

import java.util.Arrays;

public class TestFile {
	private long id;
	private byte[] content;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "TestFile [id=" + id + ", content=" + Arrays.toString(content) + "]";
	}
	
}
