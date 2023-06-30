package org.xmlparsers.stax;

import org.xmlparsers.model.Empleado;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ReadDocuementStAX {

    public List<Empleado> readDocumentStAX(File file) throws XMLStreamException, FileNotFoundException {
        List<Empleado> empleados = new ArrayList<>();
        Empleado empleado = new Empleado();
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(file));
        while (reader.hasNext()) {

            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "empleado":
                        empleado = new Empleado();
                        Attribute categoria = startElement.getAttributeByName(new QName("categoria"));
                        Attribute codigoEmpleado = startElement.getAttributeByName(new QName("codigoEmpleado"));
                        empleado.setCategoria(categoria.getValue());
                        empleado.setCodigoEmpleado(Long.parseLong(codigoEmpleado.getValue()));
                        break;
                    case "nombre":
                        nextEvent = reader.nextEvent();
                        empleado.setNombre(nextEvent.asCharacters().getData());
                        break;
                    case "apellido":
                        nextEvent = reader.nextEvent();
                        empleado.setApellido(nextEvent.asCharacters().getData());
                        break;
                    case "edad":
                        nextEvent = reader.nextEvent();
                        empleado.setEdad(Integer.parseInt(nextEvent.asCharacters().getData()));
                        break;
                    case "salario":
                        nextEvent = reader.nextEvent();
                        empleado.setSalario(Double.parseDouble(nextEvent.asCharacters().getData()));
                        break;
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("empleado")) {
                    empleados.add(empleado);
                }
            }
        }
        return empleados;
    }
}
