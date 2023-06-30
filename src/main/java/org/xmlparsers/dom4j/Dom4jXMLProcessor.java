package org.xmlparsers.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.xmlparsers.model.Empleado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Dom4jXMLProcessor {

    public void generateXML(List<Empleado> empleados, File file) throws IOException {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("utf-8");
        Element element = document.addElement("empleados");
        empleados.forEach(e -> addEmpleado(element, e));
        FileWriter out = new FileWriter(file);
        document.write(out);
        out.close();

    }

    private void addEmpleado(Element rootElement, Empleado empleado) {
        Element empleadoElement = rootElement.addElement("empleado")
                .addAttribute(new QName("categoria"), empleado.getCategoria())
                .addAttribute(new QName("codigoEmpleado"), empleado.getCodigoEmpleado().toString());
        empleadoElement.addElement("nombre").setText(empleado.getNombre());
        empleadoElement.addElement("apellido").setText(empleado.getApellido());
        empleadoElement.addElement("edad").setText(empleado.getEdad().toString());
        empleadoElement.addElement("salario").setText(empleado.getSalario().toString());
    }

    public void parseXML(File file) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element rootElement = document.getRootElement();
        List<Node> nodes = document.selectNodes("/empleados/empleado");
        for (Node node: nodes) {
            System.out.println();
            System.out.println("Categoria: " + node.valueOf("@categoria"));
            System.out.println("Codigo Empleado: " + node.valueOf("@codigoEmpleado"));
            System.out.println("Nombre: " + node.selectSingleNode("nombre").getText());
            System.out.println("Apellido: " + node.selectSingleNode("apellido").getText());
            System.out.println("Edad: " + node.selectSingleNode("edad").getText());
            System.out.println("Salario: " + node.selectSingleNode("salario").getText());

        }
    }
}
