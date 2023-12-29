package com.SpringbootExceldataAPi.service;


import com.SpringbootExceldataAPi.entity.Product;
import com.SpringbootExceldataAPi.helper.ExcleHelper;
import com.SpringbootExceldataAPi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
     private ProductRepo productRepo;
    public void save(MultipartFile file)  {

          try{
              List<Product> products = ExcleHelper.convertExcelToListOfProduct(file.getInputStream());
              this.productRepo.saveAll(products);
          } catch (Exception e){
              e.printStackTrace();
          }
    }

    public List<Product> getAllProducts(){
    return  this.productRepo.findAll();
    }
}
