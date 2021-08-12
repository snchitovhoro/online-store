package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Buyer;
import edu.miu.cs545.project.onlinestore.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements IBuyerService {
    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public Collection<Buyer> findAll() {
        return (Collection<Buyer>)  buyerRepository.findAll();
    }

    @Override
    public Optional<Buyer> findBuyerById(Long id) {
        return buyerRepository.findById(id);
    }
}
