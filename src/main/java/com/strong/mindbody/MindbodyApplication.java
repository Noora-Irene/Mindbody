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
import com.strong.mindbody.domain.User;
import com.strong.mindbody.domain.UserRepository;

@SpringBootApplication
public class MindbodyApplication {
	private static final Logger log = LoggerFactory.getLogger(MindbodyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MindbodyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(NoteRepository noterepo, WorkoutRepository workoutrepo, PowerRepository powerrepo, UserRepository userrepo) {
		return (args) -> {
			log.info("tallenna");
			
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
			
			noterepo.save(new Note(1, 14.9, workoutrepo.findByName("Sali 1").get(0), powerrepo.findByName("Voimaharjoittelu").get(0), 90, 400));
			noterepo.save(new Note(1, 16.9, workoutrepo.findByName("Kävely").get(0), powerrepo.findByName("Peruskestävyys").get(0), 60, 500));
			noterepo.save(new Note(2, 19.9, workoutrepo.findByName("Sali 2").get(0),powerrepo.findByName("Voimaharjoittelu").get(0), 90, 300));
			noterepo.save(new Note(3, 22.9, workoutrepo.findByName("Hölkkä").get(0),powerrepo.findByName("Vauhtikestävyys").get(0), 45, 350));
			noterepo.save(new Note(4, 26.9, workoutrepo.findByName("Sali 3").get(0),powerrepo.findByName("Voimaharjoittelu").get(0), 80, 450));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				userrepo.save(user1);
				userrepo.save(user2);
			
			log.info("fetch all notes");
			for (Note note : noterepo.findAll()) {
				log.info(note.toString());
			}	
			
		};
	}

}
