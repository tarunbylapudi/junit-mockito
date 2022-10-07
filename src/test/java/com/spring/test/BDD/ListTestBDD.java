package com.spring.test.BDD;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTestBDD {

	// given
	List listMock = mock(List.class);

	@Test
	public void listTest_returvningSingleValue() {

		// given
		given(listMock.size()).willReturn(2);

		// when
		int returnedSize = listMock.size();

		// then
		assertThat(returnedSize, is(2));
	}

	@Test
	public void listTest_returnigMultipleValue() {

		// given
		given(listMock.size()).willReturn(2).willReturn(3).willReturn(4);

		// when
		int firstReturnedValue = listMock.size();
		int secondReturnedValue = listMock.size();
		int thirdReturnedValue = listMock.size();

		// then
		assertThat(firstReturnedValue, is(2));
		assertThat(secondReturnedValue, is(3));
		assertThat(thirdReturnedValue, is(4));
	}

	// nice mock Feature
	@Test
	public void listTest_niceMockFeature() {

		// given
		given(listMock.get(0)).willReturn(2);
		// when
		int returnedValue = (Integer) listMock.get(0);

		// then
		assertThat(returnedValue, is(2));
		// unstubbed method ---> gives default values
		assertEquals(null, listMock.get(2));
	}

	// Argument Matchers
	@Test
	public void listTest_returningSingleValueForSpecificType() {
		
		//given
		given(listMock.get(anyInt())).willReturn("zinx");

		// when
		String firstReturnedValue = (String) listMock.get(0);
		String secondReturnedValue = (String) listMock.get(1);
		String thirdReturnedValue = (String) listMock.get(2);

		//then
		assertThat(firstReturnedValue, is("zinx"));
		assertThat(secondReturnedValue, is("zinx"));
		assertThat(thirdReturnedValue, is("zinx"));
		
	}

	// Exception
	@Test(expected = RuntimeException.class)
	public void listTest_exception() {
		when(listMock.size()).thenThrow(new RuntimeException("An Exception has occured"));
		listMock.size();
	}

}
