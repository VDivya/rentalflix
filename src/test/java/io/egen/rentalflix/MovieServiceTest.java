package io.egen.rentalflix;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {

	MovieService service;

	@Before
	public void resource() {
		service = new MovieService();
	}

	/*
	 * // test for checking with no movies in set
	 * 
	 * @Test public void findAllWithoutMovies() { assertEquals(0,
	 * service.findAll().size()); }
	 */

	// test for checking with movies in set
	@Test
	public void creationOfMovies() {
		Movie m3 = new Movie(123, "Polar Express", 2015, "English", true,
				"Harish");
		Movie m1 = new Movie(121, "Avengers", 2014, "English", true, "Divya");
		// Movie m2 = new Movie(122, "Electron", 2014, "English", false,
		// "Admin");
		Movie m2 = service.create(m3);
		service.create(m1);
		assertEquals(m3, m2);

	}

	// test for updating an existing movie
	@Test
	public void updateMovies() {
		Movie m3 = new Movie(123, "Polar Express", 2015, "Japanese", false,
				"Admin");
		// Movie m2 = new Movie(122, "Electron", 2014, "English", false,
		// "Admin");
		Movie m2 = service.update(m3);
		assertEquals(m3, m2);
	}

	// test for updating movie which doesn't exist
	@Test(expected = IllegalArgumentException.class)
	public void updateMoviesWithException() {
		Movie m3 = new Movie(127, "Orange", 2011, "Telugu", false, "Admin");
		// Movie m2 = new Movie(122, "Electron", 2014, "English", false,
		// "Admin");
		service.update(m3);
	}

	// test for deleting an existing movie
	@Test
	public void deleteMovies() {
		Movie m5 = new Movie(125, "Dinosaur", 2011, "Hindi", true, "Admin");
		service.create(m5);
		// Movie m2 = new Movie(122, "Electron", 2014, "English", false,
		// "Admin");
		Movie m2 = service.delete(125);
		assertEquals(m5, m2);
	}

	// test for deleting a movie which doesn't exist
	@Test(expected = IllegalArgumentException.class)
	public void deleteMoviesWithException() {
		// Movie m2 = new Movie(122, "Electron", 2014, "English", false,
		// "Admin");
		service.delete(129);
	}

	// test for a movie if it can be rented : true if it can be returned else
	// false
	@Test
	public void forRent() {

		assertEquals(true, service.rentMovie(123, "Divya"));
	}

	// test for a movie if it can be rented
	@Test
	public void forNotRent() {

		assertEquals(false, service.rentMovie(121, "Jon"));
	}

	// test for finding a movie particular name
	@Test
	public void findMovieByName() {
		Movie m1 = new Movie(121, "Avengers", 2014, "English", true, "Divya");
		List<Movie> s = service.findByName("Avengers");
		assertEquals(m1, s.get(0));
	}

	@Test
	public void findMovieByNameNotExisting() {
		List<Movie> s = service.findByName("Star Wars");
		assertEquals(0, s.size());
	}

	// test for getting all movies
	@Test
	public void findAllWithMovies() {

		assertEquals(2, service.findAll().size());
	}

}
