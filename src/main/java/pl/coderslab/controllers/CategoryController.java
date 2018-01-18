package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entities.Category;
import pl.coderslab.repositories.CategoryRepository;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping(path="/all")
	public String showAll(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "showCategories";
	}
	
	@GetMapping(path="/add")
	public String addCat(Model model) {
		model.addAttribute("category", new Category());
		return "addCategory";
	}
	
	@PostMapping(path="/add")
	public String addCatPost(Model model, @ModelAttribute Category category) {
		categoryRepo.save(category);
		return "redirect:all";
	}
	
	@GetMapping(path="/edit/{id}")
	public String editCat(Model model, @PathVariable("id") long id) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "editCategory";
	}
	
	@PostMapping(path="/edit/{id}")
	public String editCatPost(Model model, @PathVariable("id") long id, @ModelAttribute Category category) {
		categoryRepo.save(category);
		return "redirect:/category/all";
	}
	
	@GetMapping(path="/delete/{id}")
	public String deleteCat(@PathVariable("id") long id) {
		categoryRepo.delete(id);
		return "redirect:/category/all";
	}
	

}


