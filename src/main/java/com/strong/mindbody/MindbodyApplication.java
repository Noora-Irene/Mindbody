package com.strong.mindbody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.strong.mindbody.domain.Note;
import com.strong.mindbody.domain.NoteRepository;
import com.strong.mindbody.domain.Power;
import com.strong.mindbody.domain.PowerRepository;
import com.strong.mindbody.domain.Workout;
import com.strong.mindbody.domain.WorkoutRepository;

@SpringBootApplication
public class MindbodyApplication {
	private static final Logger log = LoggerFactory.getLogger(MindbodyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MindbodyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(NoteRepository noterepo, WorkoutRepository workoutrepo, PowerRepository powerrepo) {
		return (args) -> {
			log.info("save a couple of notes");
			
			workoutrepo.save(new Workout("Sali 1"));
			workoutrepo.save(new Workout("Sali 2"));
			workoutrepo.save(new Workout("Sali 3"));
			workoutrepo.save(new Workout("Sali 4"));
			workoutrepo.save(new Workout("Kävely"));
			workoutrepo.save(new Workout("Hölkkä"));
			workoutrepo.save(new Workout("Spinning"));
			workoutrepo.save(new Workout("Venyttely"));
			
			powerrepo.save(new Power("Peruskestävyys"));
			powerrepo.save(new Power("Vauhtikestävyys"));
			powerrepo.save(new Power("Maximikestävyys"));
			powerrepo.save(new Power("Voimaharjoittelu"));
			
			noterepo.save(new Note("la", 14.9, workoutrepo.findByName("Sali 1").get(0), powerrepo.findByName("Voimaharjoittelu").get(0), 90, 400));
			noterepo.save(new Note("ma", 16.9, workoutrepo.findByName("Kävely").get(0), powerrepo.findByName("Peruskestävyys").get(0), 60, 500));
			noterepo.save(new Note("to", 19.9, workoutrepo.findByName("Sali 2").get(0),powerrepo.findByName("Voimaharjoittelu").get(0), 90, 300));
			noterepo.save(new Note("su", 22.9, workoutrepo.findByName("Hölkkä").get(0),powerrepo.findByName("Vauhtikestävyys").get(0), 45, 350));
			noterepo.save(new Note("to", 26.9, workoutrepo.findByName("Sali 3").get(0),powerrepo.findByName("Voimaharjoittelu").get(0), 80, 450));
			
			log.info("fetch all notes");
			for (Note note : noterepo.findAll()) {
				log.info(note.toString());
			}	
			
		};
	}

}