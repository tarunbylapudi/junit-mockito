package com.spring.test.MatchersAndSpy;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest_HamcrestCoreMatchers {

	List listMock = mock(List.class);

	@Test
	public void listTest_returningSingleValue() {
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	
	@Test
	public void listTest_returnigMultipleValue() {
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
	}
	
	//nice mock Feature
	@Test
	public void listTest_niceMockFeature() {
		when(listMock.get(0)).thenReturn(2);
		assertEquals(2, listMock.get(0));
		//unstubbed method ---> gives default values
		assertEquals(null, listMock.get(2));
	}

	// Argument Matchers
	@Test
	public void listTest_returningSingleValueForSpecificType() {
		when(listMock.get(anyInt())).thenReturn("zinx");
		assertEquals("zinx", listMock.get(0));
		assertEquals("zinx", listMock.get(1));
		assertEquals("zinx", listMock.get(2));
	}

	

}
