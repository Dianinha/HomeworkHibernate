package pl.coderslab.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.repositories.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Category convert(String source) {
		Long id = Long.parseLong(source);
		return categoryRepo.getOne(id);
	}

}
