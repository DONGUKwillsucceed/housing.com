package housing.com.server.module.property.presentation.dto;

import housing.com.server.module.property.application.ApartmentSaleTransactionUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@EnableScheduling
@Controller @Slf4j
public class TransactionUpdateController {
    private final ApartmentSaleTransactionUpdateService apartmentSaleTransactionUpdateService;

    public TransactionUpdateController(ApartmentSaleTransactionUpdateService apartmentSaleTransactionUpdateService){
        this.apartmentSaleTransactionUpdateService = apartmentSaleTransactionUpdateService;
    }

    @Scheduled(cron = "0 0 12 * * *")
    void updateApartmentSale(){
        log.info("[cron start]!");
        apartmentSaleTransactionUpdateService.update();
        log.info("[cron end]");
    }
}
