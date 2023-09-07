package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.SearchResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;

@Controller
public class ProductController {

    public ProductController(){
        Product p1 = new Product(101,"Samsung");
        Product p2 = new Product(102,"Apple");
        Product p3 = new Product(103,"Nothing");
        index.put(p1.getName(), p1);
        index.put(p2.getName(), p2);
        index.put(p3.getName(), p3);
    }
    HashMap<String, Product> index = new HashMap<>();

    @GetMapping(path = {"/","/search"})
    public String search(Model model, String keyword) {
        SearchResultDTO results = new SearchResultDTO();
        if(keyword!=null) {
            if(index.get(keyword)!=null){
                results.setSearchResultDTO(Arrays.asList(index.get(keyword)));
                model.addAttribute("list", results.getSearchResultDTO());
                model.addAttribute("icon", "fa fa-shopping-cart");
                model.addAttribute("keyword", keyword);
            }else{
                results.setSearchResultDTO(Arrays.asList(new Product(0,"No results found..")));
                model.addAttribute("list", results.getSearchResultDTO());
                model.addAttribute("icon", "");
                model.addAttribute("keyword", keyword);
            }
        }else{
            results.setSearchResultDTO(Arrays.asList(new Product(0,"..")));
            model.addAttribute("list", results.getSearchResultDTO());
            model.addAttribute("icon", "");
        }
        return "index";
    }
    @GetMapping(path = {"/get"})
    public String get(ModelMap map, String keyword){
        SearchResultDTO results = new SearchResultDTO();
        if(keyword!=null) {
            if(index.get(keyword)!=null){
                results.setSearchResultDTO(Arrays.asList(index.get(keyword)));
                map.addAttribute("list", results.getSearchResultDTO());
                map.addAttribute("icon", "");
            }else{
                results.setSearchResultDTO(Arrays.asList(new Product(0,"No results found..")));
                map.addAttribute("list", results.getSearchResultDTO());
                map.addAttribute("icon", "");
            }
        }else{
            results.setSearchResultDTO(Arrays.asList(new Product(0,"")));
            map.addAttribute("list", results.getSearchResultDTO());
            map.addAttribute("icon", "");
        }
        return "fragments :: search-results";
    }
}
