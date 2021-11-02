package com.qa.main.anotherPack;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReinDeerRepository extends CrudRepository<ReinDeer, Long> {

  List<ReinDeer> findByLastName(String lastName);

  ReinDeer findById(long id);
}

