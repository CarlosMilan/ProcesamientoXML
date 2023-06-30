package org.xmlparsers.model;

public class Empleado {

    private String categoria;
    private Long codigoEmpleado;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Double salario;

    public Empleado() {
    }

    public Empleado(String categoria, Long codigoEmpleado, String nombre, String apellido, Integer edad, Double salario) {
        this.categoria = categoria;
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Long codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "categoria='" + categoria + '\'' +
                ", codigoEmpleado=" + codigoEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
