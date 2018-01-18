package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.repositories.ArticleRepository;

@Controller
public class HomePageController {

	@Autowired
	private ArticleRepository articleRepo;

	@GetMapping(path = "/homepage")
	public String hello(Model model) {
		model.addAttribute("articles", articleRepo.getLastFive());
		return "index";
	}
}
