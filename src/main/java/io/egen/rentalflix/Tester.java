package io.egen.rentalflix;

import java.util.List;

public class Tester {
	MovieService movieService=new MovieService();
	Movie m1=new Movie(121,"Avengers",2014,"English",false,"Divya");
	Movie m2=new Movie(122,"Electron",2014,"English",false,"Divya");
	/*Movie m3=new Movie(121,"Avengers",2014,"English",false,"Divya");
	Movie m4=new Movie(121,"Avengers",2014,"English",false,"Divya");
	Movie m5=new Movie(121,"Avengers",2014,"English",false,"Divya");
	*/
	List<Movie> movies=movieService.findAll();
	
	
	
}
