package org.xmlparsers.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneardorDOM {
    private Document document; // Este documento va a contener el XML

    public GeneardorDOM() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();

    }

    public GeneardorDOM(Document document) {
        this.document = document;
    }

    public void generarDocument() {
        Element productos = document.createElement("productos");
        document.appendChild(productos);

        Element producto = document.createElement("producto");
        productos.appendChild(producto);
        producto.setAttribute("Código", "1");

        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode("Teclado"));
        producto.appendChild(nombre);
    }

    public void generarXML() throws TransformerException, IOException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(); // xml de memoria a disco
        Source source = new DOMSource(document);

        File file = new File("productos.xml");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        Result result = new StreamResult(pw);

        transformer.transform(source, result);
    }

}
