package org.xmlparsers.stax;

import org.xmlparsers.model.Vehiculo;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class WriteDocumentStAX {

    private XMLStreamWriter writer;

    public WriteDocumentStAX(File file) throws FileNotFoundException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        writer = factory.createXMLStreamWriter(new FileOutputStream(file));
    }

    public void writeInXMLFile(List<Vehiculo> vehiculos) throws Exception {

        writer.writeStartDocument("utf-8","1.0");

        writer.writeStartElement("vehiculos");
        vehiculos.forEach(v -> {
            try {
                writer.writeStartElement("vehiculo");
                writer.writeAttribute("codigoVehiculo", v.getId().toString());
                writer.writeStartElement("marca");
                writer.writeCharacters(v.getMarca());
                writer.writeEndElement();
                writer.writeStartElement("modelo");
                writer.writeCharacters(v.getModelo());
                writer.writeEndElement();
                writer.writeEndElement();
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            }
        });

        writer.writeEndElement();
        writer.flush();
        writer.close();
    }
}
