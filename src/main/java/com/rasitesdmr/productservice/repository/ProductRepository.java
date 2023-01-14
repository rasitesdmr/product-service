package com.rasitesdmr.productservice.repository;

import com.rasitesdmr.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getByProductIdAndDeletedFalse(Long productId); // productId parametresi ile DB git ve deleted false olanları getir.

    List<Product> getAllByDeletedFalse(); // Deleted'i false olan bütün ürünleri geti.

}
