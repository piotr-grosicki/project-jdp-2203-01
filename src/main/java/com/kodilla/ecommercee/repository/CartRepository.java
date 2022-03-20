package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Override
    Optional<Cart> findById(Long id);

    @Override
    boolean existsById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    void delete(Cart cart);

}
