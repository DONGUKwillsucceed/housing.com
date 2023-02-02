package housing.com.server.module.property.application;

import housing.com.server.module.updater.application.ApartmentSaleTransactionUpdateService;
import housing.com.server.module.property.infra.ApartmentSaleTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service @Slf4j
@EnableScheduling
public class TransactionUpdateService {
    private final ApartmentSaleTransactionRepository apartmentSaleTransactionRepository;
    private final ApartmentSaleTransactionUpdateService apartmentSaleTransactionGenerator;
    public TransactionUpdateService(ApartmentSaleTransactionRepository apartmentSaleTransactionRepository, ApartmentSaleTransactionUpdateService apartmentSaleTransactionGenerator){
        this.apartmentSaleTransactionRepository = apartmentSaleTransactionRepository;
        this.apartmentSaleTransactionGenerator = apartmentSaleTransactionGenerator;
    }

    @Scheduled(cron = "0/30 * * * * ?")
    void updateApartmentSale() {
        log.info("[cron start]!");
        apartmentSaleTransactionGenerator.update();
        log.info("[cron end]");
    }
}
