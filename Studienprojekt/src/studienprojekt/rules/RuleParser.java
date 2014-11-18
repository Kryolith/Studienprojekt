/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studienprojekt.rules;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import studienprojekt.rules.data.Data;

/**
 *
 * @author Sebastian
 */
public class RuleParser {
    
    public static Rule parseFile(File fileToParse) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fileToParse);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        Rule result = new Rule();
        
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            result.addInformation(parseNode(currentNode));
        }
        
        return result;
    }
    
    public static Data parseNode(Node node) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        
        NamedNodeMap attributes = node.getAttributes();
        
        if(attributes != null && attributes.getNamedItem("type") != null) {
            Class currentNodeClass = Class.forName(attributes.getNamedItem("type").getNodeValue());
            Constructor constructor = currentNodeClass.getConstructor(Node.class);
            return (Data)constructor.newInstance(node);
        }
        
        return new Data(node.getNodeName());
    }   
}
