package com.qa.main.cont;

public class Deer {
private String name;
private String species;
private Integer height;

//constructor
public Deer(String name, String species, Integer height) {
	super();
	this.name = name;
	this.species = species;
	this.height = height;
}

//getters and setters
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSpecies() {
	return species;
}

public void setSpecies(String species) {
	this.species = species;
}

public Integer getHeight() {
	return height;
}

public void setHeight(Integer height) {
	this.height = height;
}

void shedAntlers() {
	
}


}
