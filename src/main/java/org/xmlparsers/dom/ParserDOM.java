package org.xmlparsers.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

public class ParserDOM {
    private Document document;

    public ParserDOM(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.document = builder.parse(file);
    }

    public void parseXML(){

        System.out.println("URI del XML: " + document.getDocumentURI());

        System.out.println("Versión: " + document.getXmlVersion());
        System.out.println("Encoding: " + document.getXmlEncoding());
        System.out.println("Cantidad de nodos: " + document.getChildNodes().getLength());

        NodeList empleados = document.getElementsByTagName("empleado");
        mostrarListaNodos(empleados);

    }

    private void mostrarListaNodos(NodeList empleados) {
        long cantidad = IntStream.range(0, empleados.getLength())
                .mapToObj(empleados::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .peek(this::mostrarDatos)
                .count();
        if (cantidad != 0) {
            System.out.println("Nodos procesados: " + cantidad);
        }
    }

    private void mostrarDatos(Node node) {
        if (!node.getNodeName().equals("empleado")) {
            System.out.println(node.getNodeName() + " : " + node.getTextContent());
        } else {
            System.out.println();
        }

        mostrarAtributos(node.getAttributes());
        //Uso recursividad para mostrar los nodos hijos
        mostrarListaNodos(node.getChildNodes());
    }

    private void mostrarAtributos(NamedNodeMap attributes) {
        if (attributes != null) {
            IntStream.range(0, attributes.getLength())
                    .mapToObj(attributes::item)
                    .forEach(a -> System.out.println(a.getNodeName() + " : " + a.getTextContent()));
        }
    }
}
