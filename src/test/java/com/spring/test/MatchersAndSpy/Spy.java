package com.spring.test.MatchersAndSpy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Test;

public class Spy {

	@Test
	public void test() {
		
		ArrayList arrayListSpy = spy(ArrayList.class);
		
		arrayListSpy.add("dummy");
		
		verify(arrayListSpy).add("dummy");
		
		verify(arrayListSpy,never()).clear();
		
		
	}

}
