package com.strong.mindbody.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NoteRepository extends CrudRepository <Note, Long> {
	
	List<Note> findByWow(int wow);
}
