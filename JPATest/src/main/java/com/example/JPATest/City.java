package com.example.JPATest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class City {
	
	private List<Person> persons = new ArrayList<Person>();
	
	private long id;
	private String name;

	public City() {
		super();
	}

	public City(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="city", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "City [persons=" + persons + ", id=" + id + ", name=" + name + "]";
	}
	
}