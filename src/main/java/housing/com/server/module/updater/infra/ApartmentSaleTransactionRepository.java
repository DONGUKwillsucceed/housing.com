package housing.com.server.module.updater.infra;

import housing.com.server.module.property.domain.entity.ApartmentSaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApartmentSaleTransactionRepository extends JpaRepository<ApartmentSaleTransaction, String> {
   ApartmentSaleTransaction findApartmentSaleTransactionByApartmentName(String name);
   ApartmentSaleTransaction save(ApartmentSaleTransaction transaction);

}
