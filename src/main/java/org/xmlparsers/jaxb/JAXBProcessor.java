package org.xmlparsers.jaxb;

import org.xmlparsers.model.Concesionaria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBProcessor {

    public Concesionaria readXML(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Concesionaria.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Concesionaria) unmarshaller.unmarshal(file);
    }

    public void writeXML(Concesionaria concesionaria, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Concesionaria.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(concesionaria,file);
    }
}
