package com.example.coffeshop.services;

import com.example.coffeshop.model.entity.Category;
import com.example.coffeshop.model.enums.CategoryNameEnum;
import com.example.coffeshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
// todo сетваме категориите в инит метода ...
    public void initCategories() {
        if (categoryRepository.count()!= 0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum ->  {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum){


                        case COFFEE -> {category.setNeededTime(2);
                        }
                        case CAKE -> {category.setNeededTime(10);
                        }
                        case DRINK -> {category.setNeededTime(1);
                        }
                        case OTHER -> {category.setNeededTime(5);
                        }
                    }
                    categoryRepository.save(category);
                });


    }
}
