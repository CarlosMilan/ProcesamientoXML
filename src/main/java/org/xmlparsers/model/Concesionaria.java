package org.xmlparsers.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


@XmlRootElement(name = "concesionaria")
@XmlType(propOrder = {"nombre", "vehiculos"})
public class Concesionaria {
    private String nombre;
    private List<Vehiculo> vehiculos;

    public Concesionaria() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElementWrapper(name = "vehiculos")
    @XmlElement(name = "vehiculo")
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Concesionaria{" +
                "nombre='" + nombre + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
