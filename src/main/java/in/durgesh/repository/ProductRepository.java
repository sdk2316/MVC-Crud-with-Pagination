package in.durgesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.durgesh.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
