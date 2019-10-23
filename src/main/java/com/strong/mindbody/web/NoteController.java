package com.strong.mindbody.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.strong.mindbody.domain.Note;
import com.strong.mindbody.domain.NoteRepository;
import com.strong.mindbody.domain.PowerRepository;
import com.strong.mindbody.domain.WorkoutRepository;

@Controller
public class NoteController {
	@Autowired
	private NoteRepository noterepo;
	
	@Autowired
	private WorkoutRepository workoutrepo;
	
	@Autowired
	private PowerRepository powerrepo;
	
	@RequestMapping("/notelist")
	public String noteList(Model model) {
		model.addAttribute("notes", noterepo.findAll());
		
		return "notelist";
	}
	@RequestMapping(value = "/add")
	public String addNote(Model model) {
	model.addAttribute("note", new Note());
	model.addAttribute("workouts", workoutrepo.findAll());
	model.addAttribute("powers", powerrepo.findAll());
	
		return "addnote";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNote(@PathVariable("id") long id, Model model) {
		model.addAttribute("note", noterepo.findById(id));
		model.addAttribute("workouts", workoutrepo.findAll());
		model.addAttribute("powers", powerrepo.findAll());
		
		return "editnote";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Note note) {
		noterepo.save(note);
		
		return "redirect:notelist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteNote(@PathVariable("id") long id, Model model) {
		noterepo.deleteById(id);
		
		return "redirect:../notelist";
	}

}
