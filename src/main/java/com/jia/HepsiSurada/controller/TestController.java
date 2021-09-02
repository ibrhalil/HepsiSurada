package com.jia.HepsiSurada.controller;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.dto.CategoryDTO;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.dto.ProductDTO;
import com.jia.HepsiSurada.model.Adress;
import com.jia.HepsiSurada.model.Category;
import com.jia.HepsiSurada.model.Customer;
import com.jia.HepsiSurada.service.CategoryService;
import com.jia.HepsiSurada.service.CustomerService;
import com.jia.HepsiSurada.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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

    private DataResult<List<Category>> categoryList;

    @GetMapping("/add")
    public void addAll()
    {
        ekleCategory();
        ekleProduct();
        ekleCustomer();
        ekleCustomerAddAddress();
    }

    public void ekleCategory()
    {
        categoryService.addCategory(new CategoryDTO("bilgisayar"));
        categoryService.addCategory(new CategoryDTO("telefon"));
        categoryService.addCategory(new CategoryDTO("giyim"));
        categoryService.addCategory(new CategoryDTO("mutfak"));
        categoryService.addCategory(new CategoryDTO("oyun"));

    }

    public void  ekleProduct()
    {

        categoryList = categoryService.getCategoryList();

        Category oyun = categoryList.getData().get(4);
        productService.addProduct(new ProductDTO(110.5,"Rokstar","bu bir oyundur","GTA5",oyun.getId().toString()));
        productService.addProduct(new ProductDTO(210.5,"EA GAMES","bu bir oyundur","MostWanted",oyun.getId().toString()));
        productService.addProduct(new ProductDTO(50.5,"EA SPORTS","bu bir oyundur","FIFA21",oyun.getId().toString()));
    }

    public void ekleCustomer()
    {

        customerService.save(new CustomerDTO("glo","arda","sen","bizimarda@hotmail.com","123123"));
        customerService.save(new CustomerDTO("oga","halil","ip","serseristyle@hotmail.com","123123"));
        customerService.save(new CustomerDTO("qwe","emre","öz","serbestdeli@hotmail.com","123123"));
        customerService.save(new CustomerDTO("asd","mert","tek","kirikkafa@hotmail.com","123123"));
    }

    public void ekleCustomerAddAddress()
    {

        List<Adress> adresses1 = new ArrayList<>(Arrays.asList(new Adress("türkiye","istanbul","mahmutbey"),new Adress("türkiye","ankara","mamak")));
        customerService.updateAdressByNickName("glo",adresses1);

        List<Adress> adresses2 = new ArrayList<>(Arrays.asList(new Adress("türkiye","istanbul","maslak")));
        customerService.updateAdressByNickName("oga",adresses2);

        List<Adress> adresses3 = new ArrayList<>(Arrays.asList(new Adress("abd","califirnia","")));
        customerService.updateAdressByNickName("qwe",adresses3);

        List<Adress> adresses4 = new ArrayList<>(Arrays.asList(new Adress("türkiye","istanbul","ümraniye"),new Adress("türkiye","istanbul","pendik")));
        customerService.updateAdressByNickName("asd",adresses4);
    }
}
