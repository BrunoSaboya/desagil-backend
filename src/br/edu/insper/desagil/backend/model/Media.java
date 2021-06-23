package br.edu.insper.desagil.backend.model;

import java.util.HashMap;
import java.util.Map;

public class Media {
	private String name;
	private int duration;
	private Map<User, Integer> ratings;
	
	public Media (String name, int duration) {
		this.name = name;
		this.duration = duration;
		this.ratings = new HashMap<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDurationString() {
		int seg = 0;
		int min = 0;
		int hora = 0;
		String dur = "";
		if (this.duration < 60) {
			seg = this.duration;
			if (this.duration < 10) {
				dur = "0:00:0" + seg;
			}
			else {
				dur = "0:00:" + seg;
			}
		}
		if (60 <= this.duration && 3600 > this.duration) {
			min = this.duration/60;	
			seg = (this.duration%60)*60;
			dur = "00:" + min + ":" + seg;
		}
		if (this.duration >= 3600) {
			hora = this.duration/3600;
			min = (this.duration%3600)*60;
			int i = (int)min;
			double d = min - i;
			seg = (int) (d*60);
			dur = hora + ":" + min + ":" + seg;
		}
		return dur;
	}
	
	public void putRating(User user, int duration) {
		this.ratings.put(user, duration);
	}
	
	public int numberRatings() {
		return this.ratings.size();
	}
	public double averageRating() {
		double soma = 0;
		for (User nota : this.ratings.keySet()) {
			soma += this.ratings.get(nota);
		}
		double media = soma / this.ratings.size();
		return media;
	}
}
