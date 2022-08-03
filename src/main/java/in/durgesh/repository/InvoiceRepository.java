package in.durgesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.durgesh.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}