package com.spring.test.MatchersAndSpy;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest_Exception {

	List listMock = mock(List.class);

	
	
	//nice mock Feature
	@Test
	public void listTest_niceMockFeature() {
		when(listMock.get(0)).thenReturn(2);
		assertEquals(2, listMock.get(0));
		//unstubbed method ---> gives default values
		assertEquals(null, listMock.get(2));
	}

	

	// Exception
	@Test(expected = RuntimeException.class)
	public void listTest_exception() {
		when(listMock.size()).thenThrow(new RuntimeException("An Exception has occured"));
		listMock.size();
	}

}
