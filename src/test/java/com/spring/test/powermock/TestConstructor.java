package com.spring.test.powermock;

 /* import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class TestConstructor {
	
	
  @Mock
  Dependency dependency;
  
  @InjectMocks
  SystemUnderTest systemUnderTest;
  
  @Test
	public void powerMockito_MockingAPrivateMethodCall() throws Exception {

		when(dependency.retrieveAllStats()).thenReturn(
				Arrays.asList(1, 2, 3));

		int result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");

		assertEquals(6, result);

		

	}
  
} */
