package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Service implementing IFlix interface You can use any Java collection type to
 * store movies
 */
public class MovieService implements IFlix {
	// private static int id=1;
	private static Map<Integer, Movie> movies = new HashMap<Integer, Movie>();

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		// try changing this
		if (movies.isEmpty())
			return null;
		else {
			return new ArrayList<Movie>(movies.values());
		}
	}

	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		List<Movie> movieList = new ArrayList<Movie>();
		for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
			if (entry.getValue().getTitle().contentEquals(name)) {
				movieList.add(entry.getValue());
			}
		}
		if (movieList.isEmpty()) {
			return movieList;
		} else
			return null;
	}

	@Override
	public Movie create(Movie movie) {
		// if movie already exists then avoid adding to the store
		for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
			if (!movie.equals(entry.getValue())) {
				movies.put(movie.getId(), movie);
			}
		}
		return ifExist(movie);

		// TODO Auto-generated method stub

	}

	@Override
	public Movie update(Movie movie) throws IllegalArgumentException {
		for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
			if (movie.getId() == entry.getKey()) {
				movies.replace(movie.getId(), entry.getValue(), movie);
				break;
			}
		}
		if (movies.containsValue(movie))
			return movie;

		else
			throw new IllegalArgumentException();

	}

	@Override
	public Movie delete(int id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Movie deletedMovie = null;

		for (Iterator<Map.Entry<Integer, Movie>> it = movies.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Integer, Movie> entry = it.next();
			if (entry.getKey() == id) {
				deletedMovie = entry.getValue();
				it.remove();
				break;
			}

		}

		if (deletedMovie == null)
			throw new IllegalArgumentException();
		else
			return deletedMovie;

		/*
		 * for (Map.Entry<Integer, Movie> entry : movies.entrySet()) { if(id ==
		 * entry.getKey()){ deletedMovie=entry.getValue();
		 * movies.remove(entry.getKey(),entry.getValue()); } }
		 */

	}

	@Override
	public boolean rentMovie(int movieId, String user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		boolean isRent = false;
		for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
			if (movieId == entry.getKey()) {
				isRent = entry.getValue().isRented();
				break;
			}
		}
		if (isRent == false)
			return true;
		else
			throw new IllegalArgumentException();
	}

	private Movie ifExist(Movie movie) {
		if (movies.containsValue(movie))
			return movie;
		else
			return null;

	}

}
