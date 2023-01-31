package housing.com.server.module.property.domain;
import housing.com.server.common.service.XMLParser;
import housing.com.server.module.property.domain.type.PropertyType;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Component @Slf4j
public class ApartmentTransactionGenerator {
    @Value("${data.go.kr.apartment.sale.serviceKey}")
    private String serviceKey;
    StringBuilder urlBuilder;
    private final XMLParser xmlParser;
    public ApartmentTransactionGenerator(XMLParser xmlParser){
        urlBuilder = new StringBuilder("http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade");
        this.xmlParser = xmlParser;
    }

    public ArrayList<ApartmentSaleTransaction> generate() throws IOException, ParserConfigurationException, SAXException {
        // 모든 areaCode 배열을 가져온다.
        // for 문을 돌려서 해당 위치를 가져온다.
        // 날짜에 대한 for 문을 돌린다.
        getCurrentDate();
        String url = getUrl("42150", "202211");
        log.info("[URL] " + url);
        Document xml = xmlParser.parse(url);
        log.info("[XML] " + xml);
        xml.getDocumentElement().normalize();
        NodeList nList = xml.getElementsByTagName("list");
        return getTransaction(nList);
    }
    @Contract("_, _ -> new")
    private @NotNull String getUrl(String areaCode, String date){
        String url_decoded = URLDecoder.decode(serviceKey, StandardCharsets.UTF_8);
        urlBuilder.append("?").append(URLEncoder.encode("serviceKey", StandardCharsets.UTF_8)).append("=").append(url_decoded);
        urlBuilder.append("&").append(URLEncoder.encode("LAWD_CD", StandardCharsets.UTF_8)).append("=").append(URLEncoder.encode(areaCode, StandardCharsets.UTF_8));
        urlBuilder.append("&").append(URLEncoder.encode("DEAL_YMD", StandardCharsets.UTF_8)).append("=").append(URLEncoder.encode(date, StandardCharsets.UTF_8));
        return urlBuilder.toString();
    }

    private ArrayList<ApartmentSaleTransaction> getTransaction(NodeList nList){
        ArrayList<ApartmentSaleTransaction> transactions = new ArrayList<>();
        for(int temp = 0; temp < nList.getLength(); temp++){
            Node nNode = nList.item(temp);
            if(nNode.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element eElement = (Element) nNode;

            ApartmentSaleTransaction transaction = mapTransaction(eElement);
            transactions.add(transaction);
        }
        return transactions;
    }
    private ApartmentSaleTransaction mapTransaction(Element eElement){
        return ApartmentSaleTransaction.builder()
                .amount(Integer.parseInt(this.getTagValue("거래금액", eElement)))
                .apartmentName(this.getTagValue("아파트", eElement))
                .apartmentBuildYear(Integer.parseInt(this.getTagValue("건축년도", eElement)))
                .dealYear(Integer.parseInt(this.getTagValue("년", eElement)))
                .dealMonth(Integer.parseInt(this.getTagValue("월", eElement)))
                .dealDay(Integer.parseInt(this.getTagValue("일", eElement)))
                .space(Double.parseDouble(this.getTagValue("전용면적", eElement)))
                .floor(Integer.parseInt(this.getTagValue("층", eElement)))
                .areaCode(Integer.parseInt(this.getTagValue("지역코드",eElement)))
                .dong(this.getTagValue("법정동", eElement))
                .jibun(this.getTagValue("지번", eElement))
                .type(PropertyType.apartment)
                .build();
    }
    private String getTagValue(String tagName, Element element) {
        NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
    private int getCurrentDate(){
        return 0;
    }
}
