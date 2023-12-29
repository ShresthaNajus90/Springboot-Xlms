package com.SpringbootExceldataAPi.controller;

import com.SpringbootExceldataAPi.entity.Product;
import com.SpringbootExceldataAPi.helper.ExcleHelper;
import com.SpringbootExceldataAPi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("product/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
        if(ExcleHelper.checkExcleFormat(file))
        {
            this.productService.save(file);
            return ResponseEntity.ok(Map.of("Message", "File is uploaded successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please check thr file format");
    }


    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return  this.productService.getAllProducts();
    }
}
