package io.egen.rentalflix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {

	MovieService service=new MovieService();
	
	//test for checking with no movies in set
	@Test
	public void findAll(){
		assertEquals(null,service.findAll());
	}
}
