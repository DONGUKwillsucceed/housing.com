package housing.com.server.module.property.application;
import housing.com.server.common.service.XMLParser;
import housing.com.server.module.property.domain.entity.ApartmentSaleTransaction;
import housing.com.server.module.property.domain.entity.AreaCode;
import housing.com.server.module.property.domain.type.PropertyType;
import housing.com.server.module.property.infra.ApartmentSaleTransactionRepository;
import housing.com.server.module.property.infra.AreaCodeRepository;
import housing.com.server.module.property.domain.TransactionUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component @Slf4j
public class ApartmentSaleTransactionUpdateService extends TransactionUpdateService <ApartmentSaleTransaction> {
    @Value("${data.go.kr.apartment.sale.serviceKey}")
    private String serviceKey;
    private ApartmentSaleTransactionRepository apartmentSaleTransactionRepository;
    StringBuilder urlBuilder;
    public ApartmentSaleTransactionUpdateService(XMLParser xmlParser, ApartmentSaleTransactionRepository apartmentSaleTransactionRepository, AreaCodeRepository areaCodeRepository){
        super(xmlParser, areaCodeRepository);
        urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade");
        this.apartmentSaleTransactionRepository = apartmentSaleTransactionRepository;
    }

    public void update(){
        // 모든 areaCode 배열을 가져온다.
        // for 문을 돌려서 해당 위치를 가져온다.
        // 날짜에 대한 for 문을 돌린다.
        List<AreaCode> areaCodeList = areaCodeRepository.findAll();
        for(AreaCode areaCode : areaCodeList){
            String today = getCurrentDate();
            log.info("today " + today);
            String url = getUrl(areaCode.get법정동코드(), today);
            log.info("[URL] " + url);
            Document xml = xmlParser.parse(url);
            log.info("Root : " + xml.getDocumentElement().getNodeName());
            persistTransaction(xml);
        }
    }
    @Contract("_, _ -> new")
    protected @NotNull String getUrl(String areaCode, String date){
        urlBuilder.append("?").append(URLEncoder.encode("serviceKey", StandardCharsets.UTF_8)).append("=").append(serviceKey);
        urlBuilder.append("&").append(URLEncoder.encode("LAWD_CD", StandardCharsets.UTF_8)).append("=").append(URLEncoder.encode(areaCode, StandardCharsets.UTF_8));
        urlBuilder.append("&").append(URLEncoder.encode("DEAL_YMD", StandardCharsets.UTF_8)).append("=").append(URLEncoder.encode(date, StandardCharsets.UTF_8));
        return urlBuilder.toString();
    }

    protected void persistTransaction(Document xml) {
        NodeList nList = xml.getElementsByTagName("item");
        log.info("count " + nList.getLength());
        for(int temp = 0; temp < nList.getLength(); temp++){
            Node nNode = nList.item(temp);
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                ApartmentSaleTransaction transaction = mapTransaction(eElement);
                apartmentSaleTransactionRepository.save(transaction);
            }
        }
    }

    protected ApartmentSaleTransaction mapTransaction(Element eElement){
        AreaCode areaCode = areaCodeRepository.findAreaCodeBy법정동코드(this.getTagValue("지역코드", eElement)+ "00000");
        log.info("지역 코드 " + this.getTagValue("지역코드", eElement) + "00000");
        log.info("지역 코드2 " + areaCode.get법정동코드());

        return ApartmentSaleTransaction.builder()
                .amount(Integer.parseInt(this.getTagValue("거래금액", eElement)))
                .apartmentName(this.getTagValue("아파트", eElement))
                .apartmentBuildYear(Integer.parseInt(this.getTagValue("건축년도", eElement)))
                .dealYear(Integer.parseInt(this.getTagValue("년", eElement)))
                .dealMonth(Integer.parseInt(this.getTagValue("월", eElement)))
                .dealDay(Integer.parseInt(this.getTagValue("일", eElement)))
                .space(Double.parseDouble(this.getTagValue("전용면적", eElement)))
                .floor(Integer.parseInt(this.getTagValue("층", eElement)))
                .areaCode(areaCode)
                .dong(this.getTagValue("법정동", eElement))
                .jibun(this.getTagValue("지번", eElement))
                .type(PropertyType.apartment)
                .build();
    }
}
