package com.jia.HepsiSurada.controller;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.dto.CategoryDTO;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.dto.ProductDTO;
import com.jia.HepsiSurada.model.Category;
import com.jia.HepsiSurada.model.Customer;
import com.jia.HepsiSurada.service.CategoryService;
import com.jia.HepsiSurada.service.CustomerService;
import com.jia.HepsiSurada.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/test")
public class TestController
{
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;


    @GetMapping("/category")
    public void ekleCategory()
    {
        categoryService.addCategory(new CategoryDTO("bilgisayar"));
        categoryService.addCategory(new CategoryDTO("telefon"));
        categoryService.addCategory(new CategoryDTO("giyim"));
        categoryService.addCategory(new CategoryDTO("mutfak"));
        categoryService.addCategory(new CategoryDTO("oyun"));
    }

    @GetMapping("/product")
    public void  ekleProduct()
    {
        DataResult<List<Category>> categoryList = categoryService.getCategoryList();
        productService.addProduct(new ProductDTO(110.5,"Rokstar","bu bir oyundur","GTA5",""));
        productService.addProduct(new ProductDTO(210.5,"EA GAMES","bu bir oyundur","MostWanted",""));
        productService.addProduct(new ProductDTO(50.5,"EA SPORTS","bu bir oyundur","FIFA21",""));
    }

    @GetMapping("/customer")
    public void ekleCustomer(){
        DataResult<List<Customer>> customerList = customerService.getListCustomer();
        customerService.save(new CustomerDTO("glo","arda","sen","bizimarda@hotmail.com","123123"));
        customerService.save(new CustomerDTO("oga","halil","ip","serseristyle@hotmail.com","123123"));
        customerService.save(new CustomerDTO("qwe","emre","öz","serbestdeli@hotmail.com","123123"));
        customerService.save(new CustomerDTO("asd","mert","tek","kirikkafa@hotmail.com","123123"));
    }
}
