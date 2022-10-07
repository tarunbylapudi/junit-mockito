package com.spring.test.MockVsStub;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.spring.test.service.Todoimpl;
import com.spring.test.stub.TodoServiceStub;

public class TodoImplStubTest {
	
	TodoServiceStub todoServiceStub=new TodoServiceStub();
	Todoimpl todoimpl=new Todoimpl(todoServiceStub);

	@Test
	public void testFilteredTodosRealatedToSpring_Size() {
		
		List<?>filteredTodos= todoimpl.filterTodosRelatedToSpring("zinx");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testFilteredTodosRealatedToSpring_content() {
		
		List<?>expectedFilteredTodos= todoimpl.filterTodosRelatedToSpring("zinx");
		List<?>actualFilteredTodos=Arrays.asList("Learn Spring","Spring is cool");
		assertEquals(actualFilteredTodos, expectedFilteredTodos);
	}

}
