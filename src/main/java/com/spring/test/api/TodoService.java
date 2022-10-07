package com.spring.test.api;

import java.util.List;
//Dependency
//Created a stub
public interface TodoService {
	
	public List<String> retriveTodos(String user);
	
	public void deleteTodos(String todo);

}
