package com.utility.app.controller;

import com.utility.app._entity.Product;
import com.utility.app._entity.User;
import com.utility.app.service.ProductService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("add")
    public ResponseEntity addProduct(@RequestBody Product product) throws Exception {
        productService.save2(product);
        return new ResponseEntity(product, HttpStatus.ACCEPTED);
    }
}
