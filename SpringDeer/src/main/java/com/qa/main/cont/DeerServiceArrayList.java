package com.qa.main.cont;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeerServiceArrayList implements DeerService{
	private List<Deer> herd = new ArrayList<>();
	
	@Override
	public Deer createDeer(Deer newDeer) {
		this.herd.add(newDeer);
		return this.herd.get(this.herd.size() - 1);
		
	}

	@Override
	public List<Deer> getDeer() {
		return this.herd;
	}

	@Override
	public Deer getDeer(Integer id) {
		return this.herd.get(id);
	}

	@Override
	public Deer replaceDeer(Integer id, Deer newDeer) {
		return this.herd.set(id, newDeer); // replaces the puppy at that index
		
	}

	@Override
	public boolean removeDeer(Integer id) {
		Deer toRemove = this.herd.get(id);
		this.herd.remove(id.intValue());
		return !this.herd.contains(toRemove);
	}
}
