package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Review;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/products")
public class ProductController {
//    @Autowired
//    private IProductService productService;


    @GetMapping("")
    public @ResponseBody
    List<Product> getAllProducts() {
        List<Product> products = null;//productService.getAll();
        return products;
    }

    @GetMapping("/{productId}")
    public @ResponseBody
    Product getProductById(@PathVariable Long productId) {
        Optional<Product> productOptional = null; //productService.getProductById(productId);
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

//    @PostMapping("/new")
//    @PreAuthorize("hasAutority('SELLER')")
//    public Boolean createProduct(@RequestBody Product product) {
//        Product product = modelMapper.map(product, Product.class);
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        return productService.createProduct(product, userdetails.getUser().getId());
//    }

//    @PutMapping("")
//    public void updateProduct(@RequestBody Product product) {
////        Product product = modelMapper.map(product, Product.class);
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        productService.updateProduct(product); //, userdetails.getUser().getId());
//    }


    @DeleteMapping(value = "/{productId}")
    public Boolean deleteProduct(@PathVariable Long productId) throws Exception {
        Optional<Product> product = null; //productService.getProductById(productId);
        try {
            if (product.isPresent()) {
                //productService.deleteProduct(productId);
                return true;
            } else {
                throw new EntityNotFoundException("Product does not exist!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Get approved reviews by product id
    @GetMapping("{productId}/reviews")
    public @ResponseBody
    List<Review> getApprovedReviewsByProductId(@PathVariable Long productId) {
        List<Review> reviews = null; //productService.getApprovedReviewsByProductId(productId);
        return reviews;
    }

}