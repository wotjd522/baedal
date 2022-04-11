package itc.hoseo.baedal.repo.imp;

import itc.hoseo.baedal.domain.Category;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRepositoryMem implements itc.hoseo.baedal.repo.CategoryRepositoryMem {

    private HashMap<String, Category> categories = new HashMap<>();

    @Override
    public List<Category> findAll() {return categories.values().stream().collect(Collectors.toList());}
    public Category save(Category c) {return categories.put(c.getName(), c);}

}
