package com.strong.mindbody.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PowerRepository extends CrudRepository<Power, Long> {
	
	List<Power> findByName(String name);
}
