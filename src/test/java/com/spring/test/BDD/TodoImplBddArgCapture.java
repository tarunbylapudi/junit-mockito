package com.spring.test.BDD;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.spring.test.api.TodoService;
import com.spring.test.service.Todoimpl;

public class TodoImplBddArgCapture {

	// given
	TodoService todoService = mock(TodoService.class);
	List<String> allTodos = Arrays.asList("Learn Spring", "Spring is cool", "Learn to Dance");

	Todoimpl todoimpl = new Todoimpl(todoService);

	// Verify method
	@Test
	public void testDeleteTodosNotRealatedToSpring_Verify() {

		// Argument Capture
		// Step 1 - Declare
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// given
		given(todoService.retriveTodos("zinx")).willReturn(allTodos);

		// when
		todoimpl.deleteTodosNotRelatedToSpring("zinx");

		// then
		//verify(todoService, times(1)).deleteTodos("Learn to Dance");
		//then(todoService).should(times(1)).deleteTodos("Learn to Dance");
		
		// Step - 2 -Declare Argument capture on method
		then(todoService).should(times(1)).deleteTodos(stringArgumentCaptor.capture());
		// Step - 3 - validate
		assertThat(stringArgumentCaptor.getValue(),is( "Learn to Dance"));

		
	}

}
