package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        for (CategoryDTO categoryDTO : dto.getCategories()) {

            // Modo onde nós instanciamos um novo objeto Java manualmente
            // Category category = new Category();
            // category.setId(categoryDTO.getId());
            // category.setName(categoryDTO.getName());

            // Modo onde obtemos uma referência da entidade existente através do JPA/Spring Data
            product.getCategories().add(
                    categoryRepository.getReferenceById(categoryDTO.getId())
            );
        }

        productRepository.save(product);
        return new ProductDTO(product);
    }
}
