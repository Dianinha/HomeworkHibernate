package pl.coderslab.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entities.Article;
import pl.coderslab.repositories.ArticleRepository;
import pl.coderslab.repositories.AuthorRepository;
import pl.coderslab.repositories.CategoryRepository;

@Controller
@RequestMapping(path = "article")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepo;
	@Autowired
	private AuthorRepository authorRepo;
	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping(path = "/all")
	public String showAll(Model model) {
		model.addAttribute("articles", articleRepo.findAll());
		return "showArticles";
	}

	@GetMapping(path = "/add")
	public String addArticle(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "addArticle";
	}

	@PostMapping(path = "/add")
	public String addArticlePost(Model model, @ModelAttribute Article article) {
		article.setCreated(LocalDateTime.now());
		articleRepo.save(article);
		return "redirect:all";
	}

	@GetMapping(path = "/edit/{id}")
	public String editArticle(Model model, @PathVariable("id") long id) {
		model.addAttribute("article", articleRepo.findOne(id));
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "editArticle";
	}

	@PostMapping(path = "/edit/{id}")
	public String editArticlePost(Model model, @PathVariable("id") long id, @ModelAttribute Article article) {
		article.setUpdated(LocalDateTime.now());
		articleRepo.save(article);
		return "redirect:all";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteArticle(@PathVariable("id") long id) {
		articleRepo.delete(id);
		return "redirect:all";
	}

}
