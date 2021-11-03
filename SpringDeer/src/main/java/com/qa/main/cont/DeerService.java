package com.qa.main.cont;

import java.util.List;

public interface DeerService {
	Deer createDeer(Deer newDeer);

	List<Deer> getDeer();

	Deer getDeer(Integer id);

	Deer replaceDeer(Integer id, Deer newDeer);

	boolean removeDeer(Integer id);
}
