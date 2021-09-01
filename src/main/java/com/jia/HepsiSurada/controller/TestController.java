package com.jia.HepsiSurada.controller;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.dto.CategoryDTO;
import com.jia.HepsiSurada.dto.ProductDTO;
import com.jia.HepsiSurada.model.Category;
import com.jia.HepsiSurada.service.CategoryService;
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
    }
}
