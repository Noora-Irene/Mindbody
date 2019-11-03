package com.strong.mindbody;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.strong.mindbody.domain.Note;
import com.strong.mindbody.domain.NoteRepository;
import com.strong.mindbody.domain.Power;
import com.strong.mindbody.domain.Workout;


@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryTest {
	@Autowired
    private NoteRepository noterepo;

    @Test
    public void findByWowShouldReturnNote() {
        List<Note> notes = noterepo.findByWow(4);
        Date date = new Date(2019,9,26);
        assertThat(notes).hasSize(1);
        /*
        assertThat(notes.get(0).getDate()).isEqualTo(date);
        Date dateOne = new Date();
        dateOne.setTime(61202516585000L);
        Date dateTwo = new Date();
        dateTwo.setTime(61202516585123L);
         */
        assertEquals(12.9, notes.get(0).getDate(),1000);
  
    }
    
    @Test
    public void createNewNote() {
    	Note note = new Note(1, 14.9, new Workout("Sali 1"), new Power("Voimaharjoittelu"), 90, 400);
    	noterepo.save(note);
    	assertThat(note.getId()).isNotNull();
    }    
    
}

