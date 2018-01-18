package pl.coderslab.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.repositories.ArticleRepository;

public class ArticleConverter implements Converter<String, Article> {

	@Autowired
	private ArticleRepository articleRepo;

	@Override
	public Article convert(String source) {
		Long id = Long.parseLong(source);
		return articleRepo.getOne(id);
	}

}
