package housing.com.server.common.service;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class XMLParser {
    DocumentBuilderFactory dbFactory;
    public XMLParser() {
        this.dbFactory = DocumentBuilderFactory.newInstance();
    }
    public Document parse(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(url);
    }
}
