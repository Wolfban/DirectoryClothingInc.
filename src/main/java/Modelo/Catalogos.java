package Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Catalogos {
    private String Nombre;

    private String FechaCreacion;

    private int ID;

    private ArrayList<Integer> Camisas;



    public Catalogos(String nombre, String Fecha, int Id, ArrayList<Integer> camisas){
        Nombre = nombre;
        FechaCreacion = Fecha;
        ID=Id;
        Camisas =camisas;
    }

    public Catalogos(String nombre, String Fecha, int id){
        Nombre = nombre;
        FechaCreacion = Fecha;
        ID=id;
        Camisas = new ArrayList<>();

    }

    public ArrayList<Integer> getCamisas() {
        return Camisas;
    }

    public void setCamisas(ArrayList<Integer> camisas) {
        Camisas = camisas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalogos)) return false;
        Catalogos catalogos = (Catalogos) o;
        return getFechaCreacion() == catalogos.getFechaCreacion() && getID() == catalogos.getID() && Objects.equals(getNombre(), catalogos.getNombre());
    }

    @Override
    public String toString() {
        return "Catalogos{" +
                "Nombre='" + Nombre + '\'' +
                ", FechaCreacion=" + FechaCreacion +
                ", ID=" + ID +
                ", Camisas=" + Camisas +
                '}';
    }
}
