package in.durgesh.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.durgesh.helper.ExcelHelper;
import in.durgesh.model.Product;
import in.durgesh.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public Page<Product> listAll(int pageNum, String sortField, String sortDir) {
		
		Pageable pageable = PageRequest.of(pageNum - 1, 5, 
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
									  : Sort.by(sortField).descending()
		);
		
		return repo.findAll(pageable);
	}
	
	// add excel
	  public void save(MultipartFile file) {
	    try {
	      List<Product> product = ExcelHelper.excelToProduct(file.getInputStream());
	      repo.saveAll(product);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
