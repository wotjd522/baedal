package itc.hoseo.baedal.repo;

import itc.hoseo.baedal.domain.Category;

import java.util.HashMap;
import java.util.List;

public interface CategoryRepositoryMem {

    List<Category> findAll();
    public Category save(Category c);
}
