package io.egen.rentalflix;

/**
 * Entity representing a movie. Fields: id, title, year, language
 */

// Assumption: If IsRent is false, then we can rent it.
public class Movie {
	// POJO IMPLEMENTATION GOES HERE
	private int id;
	private String title;
	private int year;
	private String language;
	private boolean isRent;
	private String user;

	Movie(int id, String title, int year, String language, boolean isRent,
			String user) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.language = language;
		this.isRent = isRent;
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isRented() {
		return isRent;
	}

	public void setRented(boolean isRented) {
		this.isRent = isRented;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isRent ? 1231 : 1237);
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		if (isRent != other.isRent)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
