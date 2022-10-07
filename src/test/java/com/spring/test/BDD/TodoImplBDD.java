package com.spring.test.BDD;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.spring.test.api.TodoService;
import com.spring.test.service.Todoimpl;

public class TodoImplBDD {
	
	//given
	TodoService todoService = mock(TodoService.class);
	List<String> allTodos = Arrays.asList("Learn Spring","Spring is cool", "Learn to Dance");
	
	Todoimpl todoimpl = new Todoimpl(todoService);

	@Test
	public void testFilteredTodosRealatedToSpring_Size() {
		//given
		given(todoService.retriveTodos("zinx")).willReturn(allTodos);
		
		//Todoimpl todoimpl = new Todoimpl(todoService);
		//when
		List<?> filteredTodos = todoimpl.filterTodosRelatedToSpring("zinx");
		int filteredTodosSize=filteredTodos.size();
		
		//then
		assertThat(filteredTodosSize, is(2));
	}

	@Test
	public void testFilteredTodosRealatedToSpring_content() {
		
		//given
		given(todoService.retriveTodos("zinx")).willReturn(allTodos);
		
		//when
		List<?> expectedFilteredTodos = todoimpl.filterTodosRelatedToSpring("zinx");
		List<?> actualFilteredTodos = Arrays.asList("Learn Spring", "Spring is cool");
		
		//then
		assertEquals(expectedFilteredTodos,  actualFilteredTodos);
	}
	
	//Verify method
	@Test
	public void testDeleteTodosNotRealatedToSpring_Verify() {
		//given
		given(todoService.retriveTodos("zinx")).willReturn(allTodos);
		
		//Todoimpl todoimpl = new Todoimpl(todoService);
		//when
		todoimpl.deleteTodosNotRelatedToSpring("zinx");

		
		//then
		verify(todoService,times(1)).deleteTodos("Learn to Dance");
		
		verify(todoService,never()).deleteTodos("Learn Spring");
	}
	
	

}
