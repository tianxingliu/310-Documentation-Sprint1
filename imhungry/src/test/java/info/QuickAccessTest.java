package info;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickAccessTest {

	@Test
	public void test() {
		QuickAccess obj = new QuickAccess("abc");
		assertEquals("abc",obj.item);
		QuickAccess obj2 = new QuickAccess("abc");
		QuickAccess obj3 = new QuickAccess("def");
		Object obj4 = null;
		assertEquals(false, obj.equals(obj4));
		assertEquals(true, obj.equals(obj));
		assertEquals(true, obj.equals(obj2));
		assertEquals(false, obj.equals(obj3));
	}

}
