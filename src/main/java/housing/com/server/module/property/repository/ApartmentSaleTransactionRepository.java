package housing.com.server.module.property.repository;

import housing.com.server.module.property.domain.ApartmentSaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApartmentSaleTransactionRepository extends JpaRepository<ApartmentSaleTransaction, String> {
   ApartmentSaleTransaction findApartmentSaleTransactionByApartmentName(String name);
   ApartmentSaleTransaction save(ApartmentSaleTransaction transaction);

}
