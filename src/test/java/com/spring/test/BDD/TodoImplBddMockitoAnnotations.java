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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.spring.test.api.TodoService;
import com.spring.test.service.Todoimpl;

// @RunWith(MockitoJUnitRunner.class)
public class TodoImplBddMockitoAnnotations {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	Todoimpl todoimpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	
	List<String> allTodos = Arrays.asList("Learn Spring","Spring is cool", "Learn to Dance");
	
	@Test
	public void testFilteredTodosRealatedToSpring_Size() {
		
		//given
		given(todoServiceMock.retriveTodos("zinx")).willReturn(allTodos);
		
		//when
		List<?> filteredTodos = todoimpl.filterTodosRelatedToSpring("zinx");
		int filteredTodosSize=filteredTodos.size();
		
		//then
		assertThat(filteredTodosSize, is(2));
	}

	@Test
	public void testFilteredTodosRealatedToSpring_content() {
		
		//given
		given(todoServiceMock.retriveTodos("zinx")).willReturn(allTodos);
		
		//when
		List<?> expectedFilteredTodos = todoimpl.filterTodosRelatedToSpring("zinx");
		List<?> actualFilteredTodos = Arrays.asList("Learn Spring", "Spring is cool");
		
		//then
		assertEquals(expectedFilteredTodos,  actualFilteredTodos);
	}
	
	//Verify method
	@Test
	public void testDeleteTodosNotRealatedToSpring_Verify() {

		// Argument Capture
		// given
		given(todoServiceMock.retriveTodos("zinx")).willReturn(allTodos);

		// when
		todoimpl.deleteTodosNotRelatedToSpring("zinx");

		// then
		then(todoServiceMock).should(times(1)).deleteTodos(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getValue(),is( "Learn to Dance"));

		
	}
	

}
