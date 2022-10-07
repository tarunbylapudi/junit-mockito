package com.spring.test.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.test.api.TodoService;

//SUT --> System under Test
public class Todoimpl {

	private TodoService todoService;

	public Todoimpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	public List<?> filterTodosRelatedToSpring(String user) {

		List<String> filteedTodos = new ArrayList<String>();
		List<String> todos = todoService.retriveTodos(user);

		for (String todo : todos) {
			if (todo.contains("Spring"))
				filteedTodos.add(todo);
		}

		return filteedTodos;

	}

	public void deleteTodosNotRelatedToSpring(String user) {

		List<String> filteedTodos = new ArrayList<String>();
		List<String> todos = todoService.retriveTodos(user);

		for (String todo : todos) {
			if (!todo.contains("Spring"))
				todoService.deleteTodos(todo);
		}

	}

}
