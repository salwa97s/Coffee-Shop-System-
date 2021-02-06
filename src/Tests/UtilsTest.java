package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.FormUtils;

class UtilsTest {
	private boolean result;
	@Test
	void test() {
		FormUtils junit = new FormUtils();
		
		result = junit.HasNoSpaces(" ");
		assertEquals(false, result);
		result = junit.HasNoSpaces(" k74@#jkjjb");
		assertEquals(false, result);
		result = junit.HasNoSpaces("jbjhbjh ");
		assertEquals(false, result);
		result = junit.HasNoSpaces("uhyug hu");
		assertEquals(false, result);
		result = junit.HasNoSpaces("");
		assertEquals(false, result);
		result = junit.HasNoSpaces("jfj4#@bj");
		assertEquals(true, result);
		
		result = junit.isAlphabet(" ");
		assertEquals(false, result);
		result = junit.isAlphabet("");
		assertEquals(false, result);
		result = junit.isAlphabet("vhgvjg7");
		assertEquals(false, result);
		result = junit.isAlphabet(" 8765");
		assertEquals(false, result);
		result = junit.isAlphabet("jjhjh");
		assertEquals(true, result);
		result = junit.isAlphabet("8jh7");
		assertEquals(false, result);
		result = junit.isAlphabet("hghv 7");
		assertEquals(false, result);
		result = junit.isAlphabet("jjh jh");
		assertEquals(false, result);
		
		result = junit.isAlphaNumeric("7658");
		assertEquals(true, result);
		result = junit.isAlphaNumeric("khjug");
		assertEquals(true, result);
		result = junit.isAlphaNumeric("huyg@#");
		assertEquals(false, result);
		result = junit.isAlphaNumeric("");
		assertEquals(false, result);
		result = junit.isAlphaNumeric(" ");
		assertEquals(false, result);
		result = junit.isAlphaNumeric("hjg76gh");
		assertEquals(true, result);
		result = junit.isAlphaNumeric("hfyt5 #");
		assertEquals(false, result);
		
		result = junit.isNumeric("758875");
		assertEquals(true, result);
		result = junit.isNumeric("");
		assertEquals(false, result);
		result = junit.isNumeric(" ");
		assertEquals(false, result);
		result = junit.isNumeric("767g66");
		assertEquals(false, result);
		result = junit.isNumeric("765$");
		assertEquals(false, result);
		result = junit.isNumeric("&");
		assertEquals(false, result);
		result = junit.isNumeric("67574 36");
		assertEquals(false, result);
	}

}
