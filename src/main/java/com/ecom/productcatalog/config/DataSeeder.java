package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner
{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));


        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smartphone");
        phone.setImageURL("https://placehold.co/600x400");
        phone.setPrice(55.55);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Lap1");
        laptop.setDescription("Latest Lap1 ");
        laptop.setImageURL("https://placehold.co/600x400");
        laptop.setPrice(345.55);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jack");
        jacket.setDescription("Latest Winter Jck ");
        jacket.setImageURL("https://placehold.co/600x400");
        jacket.setPrice(35.55);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-speed blender for smoothies");
        blender.setImageURL("https://placehold.co/600x400");
        blender.setPrice(123.11);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));






    }

}
