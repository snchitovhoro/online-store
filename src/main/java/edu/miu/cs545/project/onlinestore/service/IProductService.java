package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Review;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAll();

    Optional<Product> getProductById(Long productId);

    Boolean createProduct(Product product);

    void deleteProduct(Long productId);

    List<Review> getApprovedReviewsByProductId(Long productId);

    Boolean updateProduct(Product product, Long userId);
}
