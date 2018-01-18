package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entities.Author;
import pl.coderslab.repositories.AuthorRepository;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;

	@GetMapping(path = "/all")
	public String showAll(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "showAuthors";
	}

	@GetMapping(path = "/add")
	public String addAuthor(Model model) {
		model.addAttribute("author", new Author());
		return "addAuthor";
	}

	@PostMapping(path = "/add")
	public String addAuthorPost(Model model, @ModelAttribute Author author) {
		authorRepo.save(author);
		return "redirect:all";
	}

	@GetMapping(path = "/edit/{id}")
	public String editAuthor(Model model, @PathVariable("id") long id) {
		model.addAttribute("author", authorRepo.findOne(id));
		return "editAuthor";
	}

	@PostMapping(path = "/edit/{id}")
	public String editAuthorPost(Model model, @PathVariable("id") long id, @ModelAttribute Author author) {
		authorRepo.save(author);
		return "redirect:/author/all";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteAuthor(@PathVariable("id") long id) {
		authorRepo.delete(id);
		return "redirect:/author/all";
	}
}
