package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Buyer;

import java.util.Collection;
import java.util.Optional;

public interface IBuyerService {
    Collection<Buyer> findAll();

    Optional<Buyer> findBuyerById(Long id);
}
