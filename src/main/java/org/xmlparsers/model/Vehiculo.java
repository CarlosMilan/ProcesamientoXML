package org.xmlparsers.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "vehiculo")
@XmlType(propOrder = {"id", "segmento", "marca", "modelo"})
public class Vehiculo {


    private Long id;
    private String segmento;
    private String marca;
    private String modelo;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String segmento, String marca, String modelo) {
        this.id = id;
        this.segmento = segmento;
        this.marca = marca;
        this.modelo = modelo;
    }

    @XmlAttribute(name = "codigoVehiculo")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", segmento='" + segmento + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
