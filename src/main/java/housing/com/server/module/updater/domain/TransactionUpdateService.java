package housing.com.server.module.updater.domain;

import housing.com.server.common.service.XMLParser;
import housing.com.server.module.property.infra.AreaCodeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class TransactionUpdateService <T> {
    @Value("${data.go.kr.apartment.sale.serviceKey}")
    protected String serviceKey;
    protected final AreaCodeRepository areaCodeRepository;
    protected final XMLParser xmlParser;

    public TransactionUpdateService(XMLParser xmlParser, AreaCodeRepository areaCodeRepository) {
        this.areaCodeRepository = areaCodeRepository;
        this.xmlParser = xmlParser;
    }

    abstract public void update();
    abstract protected String getUrl(String areaCode, String date);
    abstract protected void persistTransaction(Document xml);
    abstract protected T mapTransaction(Element eElement);
    protected String getTagValue(String tagName, Element element) {
        return element.getElementsByTagName(tagName).item(0).getTextContent().trim().replace(",","");
    }
    protected String getCurrentDate(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        return formatter.format(now);
    }
}
