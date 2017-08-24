package com.Junit.src.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.full.DeleteData;

public class SearchTestcase {

	@Test
	public void test() {
		DeleteData delete = new DeleteData();
		assertTrue(delete.deleteValidate("dv"));
		assertFalse(delete.deleteValidate(" "));
		assertFalse(delete.deleteValidate(null));
		assertFalse(delete.deleteValidate(""));
	}

}
