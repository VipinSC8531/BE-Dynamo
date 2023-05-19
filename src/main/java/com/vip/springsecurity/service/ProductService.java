package com.vip.springsecurity.service;

import com.vip.springsecurity.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    private static List<Product> listProducts = IntStream.range(1,100)
            .mapToObj(i->Product.builder().productId(i).name("Product"+i).quantity(i*2).price(i*3d).build())
            .collect(Collectors.toList());
    
    public List<Product> getAll(){
        return listProducts;
    }
    
    public Product getProduct(int id){
        return listProducts.stream()
                .filter(p->p.getProductId()==id)
                .findAny()
                .orElseThrow();
    }
}
