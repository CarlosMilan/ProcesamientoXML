package org.xmlparsers;

import org.dom4j.DocumentException;
import org.xmlparsers.dom.GeneardorDOM;
import org.xmlparsers.dom.ParserDOM;
import org.xmlparsers.dom4j.Dom4jXMLProcessor;
import org.xmlparsers.jaxb.JAXBProcessor;
import org.xmlparsers.model.Concesionaria;
import org.xmlparsers.model.Empleado;
import org.xmlparsers.model.Vehiculo;
import org.xmlparsers.sax.ParserSAX;
import org.xmlparsers.stax.ReadDocuementStAX;
import org.xmlparsers.stax.WriteDocumentStAX;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final File EMPLEADOS_XML_FILE = new File("Empleados.xml");

    public static void main(String[] args) throws Exception {
        //probarDOM();
        //probarSAX();
        //probarSTAX();
        //probarDOM4J();
        probarJAXB();
    }
    public static void probarDOM() throws Exception {
        ParserDOM parserDOM = new ParserDOM(EMPLEADOS_XML_FILE);
        parserDOM.parseXML();

        GeneardorDOM geneardorDOM = new GeneardorDOM();
        geneardorDOM.generarDocument();
        geneardorDOM.generarXML();
    }

    public static void probarSAX() throws Exception {
        ParserSAX parserSAX = new ParserSAX(EMPLEADOS_XML_FILE);
        parserSAX.getEmpleados().forEach(System.out::println);
    }

    public static void probarSTAX() throws Exception {
        List<Vehiculo> vehiculos = Arrays.asList(
                new Vehiculo(1L, "ABC 123", "Mercedes Benz", "Atego"),
                new Vehiculo(2L, "RTF 653", "Renault", "Kangoo")
        );

        File file = new File("vehiculos.xml");
        WriteDocumentStAX writeDocumentStAX = new WriteDocumentStAX(file);
        writeDocumentStAX.writeInXMLFile(vehiculos);

        ReadDocuementStAX readDocuementStAX = new ReadDocuementStAX();
        List<Empleado> empleados = readDocuementStAX.readDocumentStAX(EMPLEADOS_XML_FILE);
        System.out.println("Empleados: ");
        empleados.forEach(System.out::println);
    }

    private static void probarDOM4J() throws IOException, DocumentException {
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Operario", 10L, "Pepe", "Gonzales", 31, 200000d),
                new Empleado("Seguridad", 86L, "Pedro", "Lima", 29, 190000d)
        );
        File file = new File("empleados2.xml");
        Dom4jXMLProcessor processor = new Dom4jXMLProcessor();
        processor.generateXML(empleados, file);

        processor.parseXML(file);

    }

    private static void probarJAXB() throws JAXBException {
        File file = new File("concesionaria.xml");
        JAXBProcessor jaxbProcessor = new JAXBProcessor();
        Concesionaria concesionaria = jaxbProcessor.readXML(file);
        System.out.println("Concesionaria : " + concesionaria.getNombre());
        concesionaria.getVehiculos().forEach(System.out::println);


        File file2 = new File("concesionaria2.xml");
        Concesionaria concesionaria2 = new Concesionaria();
        concesionaria2.setNombre("Paris Motors S.A.");
        List<Vehiculo> vehiculos = Arrays.asList(
                new Vehiculo(23L, "C", "Peugeot", "208"),
                new Vehiculo(45L, "C", "Citroen", "C3"),
                new Vehiculo(78L, "B", "Peugeot", "408")
        );
        concesionaria2.setVehiculos(vehiculos);
        jaxbProcessor.writeXML(concesionaria2, file2);
    }
}