package housing.com.server.module.property.service;

import housing.com.server.module.property.domain.ApartmentSaleTransaction;
import housing.com.server.module.property.domain.ApartmentTransactionGenerator;
import housing.com.server.module.property.repository.ApartmentSaleTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

@Service @Slf4j
@EnableScheduling
public class TransactionUpdateService {
    private final ApartmentSaleTransactionRepository apartmentSaleTransactionRepository;
    private final ApartmentTransactionGenerator apartmentTransactionGenerator;
    public TransactionUpdateService(ApartmentSaleTransactionRepository apartmentSaleTransactionRepository, ApartmentTransactionGenerator apartmentTransactionGenerator){
        this.apartmentSaleTransactionRepository = apartmentSaleTransactionRepository;
        this.apartmentTransactionGenerator = apartmentTransactionGenerator;
    }

    @Scheduled(cron = "0/30 * * * * ?")
    void updateApartmentSale() throws IOException, ParserConfigurationException, SAXException {
        log.info("[cron start]!");
        ArrayList<ApartmentSaleTransaction> transactions = apartmentTransactionGenerator.generate();
        log.info("[Is Tranactions generated??] " + transactions.size());
        for(ApartmentSaleTransaction transaction : transactions){
            ApartmentSaleTransaction result = apartmentSaleTransactionRepository.findApartmentSaleTransactionByApartmentName(transaction.getApartmentName());
            if(result == null)
                continue;

            apartmentSaleTransactionRepository.save(transaction);
        }
        log.info("[cron end]");
    }
}
