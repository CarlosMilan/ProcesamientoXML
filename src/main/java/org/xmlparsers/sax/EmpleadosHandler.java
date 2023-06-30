package org.xmlparsers.sax;

import org.xmlparsers.model.Empleado;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class EmpleadosHandler extends DefaultHandler {

    private List<Empleado> empleados = new ArrayList<>();
    private Empleado empleado;
    private static String qualifiedName;


    //Procesa los elementos de apertura <element> junto con sus atributos
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //En este caso solo me interesa el tag de apertura <empleado> porque tiene atributos
        switch (qName) {
            case "empleado":
                empleado = new Empleado();
                empleado.setCodigoEmpleado(Long.parseLong(attributes.getValue("codigoEmpleado")));
                empleado.setCategoria(attributes.getValue("categoria"));
                break;
            default: qualifiedName = qName;    
        }
    }

    //Procesa el contenido de los elementos <element>contenido</element>
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (length > 0) {
            String content = String.valueOf(ch, start, length);
            if (!content.isBlank()){
                switch (qualifiedName) {
                    case "nombre":
                        empleado.setNombre(content);
                        break;
                    case "apellido":
                        empleado.setApellido(content);
                        break;
                    case "edad":
                        empleado.setEdad(Integer.parseInt(content));
                        break;
                    case "salario":
                        empleado.setSalario(Double.parseDouble(content));
                }
            }
        }
    }

    //Procesa los elementos de cierre </element>
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("empleado")) {
            empleados.add(empleado);
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
