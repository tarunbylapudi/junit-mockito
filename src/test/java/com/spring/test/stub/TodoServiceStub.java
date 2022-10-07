package com.spring.test.stub;

import java.util.Arrays;
import java.util.List;

import com.spring.test.api.TodoService;

public class TodoServiceStub implements TodoService{

	public List<String> retriveTodos(String user) {
		
		return Arrays.asList("Learn Spring","Spring is cool","learn to dance");
	}

	public void deleteTodos(String todo) {
		// TODO Auto-generated method stub
		
	}

}
