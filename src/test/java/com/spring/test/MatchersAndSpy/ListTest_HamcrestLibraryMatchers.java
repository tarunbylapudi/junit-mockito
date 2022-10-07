package com.spring.test.MatchersAndSpy;


import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListTest_HamcrestLibraryMatchers {

	@Test
	public void test_HamcrestLibraryMatchers() {
		
		List<Integer> scores = Arrays.asList(90,95,100,105,110);
		
		assertThat(scores, hasSize(5));
		assertThat(scores, hasItems(100,110));
		
		//String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		//arrays
		
		Integer marks [] = {1,2,3,4,5};
		
		assertThat(marks, arrayWithSize(5));
		assertThat(marks,arrayContaining(1,2,3,4,5));
		assertThat(marks, arrayContainingInAnyOrder(5,1,4,3,2));
		
		

	}
}
