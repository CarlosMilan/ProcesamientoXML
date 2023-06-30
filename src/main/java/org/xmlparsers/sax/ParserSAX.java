package org.xmlparsers.sax;

import org.xmlparsers.model.Empleado;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParserSAX {

    private List<Empleado> empleados;


    public ParserSAX(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        EmpleadosHandler handler = new EmpleadosHandler();
        saxParser.parse(file, handler);
        this.empleados = handler.getEmpleados();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
