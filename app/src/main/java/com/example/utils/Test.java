package com.example.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Test {
    static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    static DocumentBuilder documentBuilder = null;
    public static void test(String productName, String value){

            try {
                documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(new File("C:\\Users\\MI\\Desktop\\Cameraadapter\\camera_config.xml"));
                document.getDocumentElement().normalize();
                NodeList nodeList = document.getElementsByTagName("product");
                for(int i = 0;i<nodeList.getLength();i++){
                    Element element = (Element) nodeList.item(i);
                    if(element.getAttribute("name").equals(productName)){
                        Element element1 = document.createElement("Feature");
                        element1.setAttribute("name","project");
                        element1.setAttribute("value",value);
                        element.appendChild(element1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        test("lmiin","LMI");
    }

}
