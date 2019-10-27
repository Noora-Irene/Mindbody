package com.strong.mindbody;

import static org.assertj.core.api.Assertions.assertThat;
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
        List<Note> notes = noterepo.findByWow("4");
        
        assertThat(notes).hasSize(1);
        assertThat(notes.get(0).getDate()).isEqualTo("30.11");
    }
    
    @Test
    public void createNewStudent() {
    	Note note = new Note(1, 14.9, new Workout("Sali 1"), new Power("Voimaharjoittelu"), 90, 400);
    	noterepo.save(note);
    	assertThat(note.getId()).isNotNull();
    }    
    
}

