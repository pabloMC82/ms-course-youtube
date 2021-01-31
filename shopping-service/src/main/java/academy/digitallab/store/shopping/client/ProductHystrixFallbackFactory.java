package academy.digitallab.store.shopping.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import academy.digitallab.store.shopping.model.Category;
import academy.digitallab.store.shopping.model.Product;

@Component
public class ProductHystrixFallbackFactory implements ProductClient {
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
    	Category category = Category.builder()
    			.id(0L)
    			.name("none").build();
    	
    	Product product = Product.builder()
    			.description("none")
    			.id(0L)
    			.name("none")
    			.price(0d)
    			.stock(1d)
    			.status("none")
    			.category(category).build();
    	
    	return ResponseEntity.ok(product);
    }
    @PutMapping (value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable  Long id ,@RequestParam(name = "quantity", required = true) Double quantity){
    	Category category = Category.builder()
    			.id(0L)
    			.name("none").build();
    	
    	Product product = Product.builder()
    			.description("none")
    			.id(0L)
    			.name("none")
    			.price(0d)
    			.stock(1d)
    			.status("none")
    			.category(category).build();
    	
    	return ResponseEntity.ok(product);
    }

}
