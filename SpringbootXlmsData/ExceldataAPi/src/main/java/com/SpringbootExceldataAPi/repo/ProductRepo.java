package com.SpringbootExceldataAPi.repo;

import com.SpringbootExceldataAPi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {


}
