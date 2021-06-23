package br.edu.insper.desagil.backend.model;

import java.util.List;

public class Playlist extends Collection{
	private String user;
	private List<Movie> movies; 

	public Playlist(String title, String user) {
		super(title);
		this.user = user;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public List<Movie> getMovie(){
		return this.movies;
	}
	
	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}
}
