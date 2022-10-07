package com.spring.test.MockVsStub;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.spring.test.api.TodoService;
import com.spring.test.service.Todoimpl;

public class TodoImplMockTest {

	TodoService todoService = mock(TodoService.class);
	List<String> allTodos = Arrays.asList("Learn Spring","Spring is cool", "Learn to Dance");

	
	
	Todoimpl todoimpl = new Todoimpl(todoService);

	@Test
	public void testFilteredTodosRealatedToSpring_Size() {
		when(todoService.retriveTodos("zinx")).thenReturn(allTodos);
		
		//Todoimpl todoimpl = new Todoimpl(todoService);

		List<?> filteredTodos = todoimpl.filterTodosRelatedToSpring("zinx");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testFilteredTodosRealatedToSpring_content() {
		when(todoService.retriveTodos("zinx")).thenReturn(allTodos);
		List<?> expectedFilteredTodos = todoimpl.filterTodosRelatedToSpring("zinx");
		List<?> actualFilteredTodos = Arrays.asList("Learn Spring", "Spring is cool");
		assertEquals(expectedFilteredTodos,  actualFilteredTodos);
	}
	
	

}
