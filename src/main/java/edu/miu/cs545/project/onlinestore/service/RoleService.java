package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Product;
import edu.miu.cs545.project.onlinestore.domain.Seller;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Seller> getAll();

    Optional<Seller> getSellerByID(Long id);

    List<Product> getProductsBySellerId(Long id);
}
