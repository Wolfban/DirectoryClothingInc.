package Modelo;


public class Camisas {
    private String Color;

    private float Precio;

    private String Desc;

    private String Tamannio;

    private String Imagen;

    private int ID;

    public Camisas(String color, float precio, String desc, String tamannio, String img, int Id) {
        Color = color;
        Precio = precio;
        Desc = desc;
        Tamannio = tamannio;
        Imagen = img;
        ID = Id;

    }
    public Camisas(String color, String desc, float precios, String tamannio, String Img, int id){
        Color = color;
        Desc = desc;
        Precio = precios;
        Tamannio = tamannio;
        Imagen = Img;
        ID = id;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int    ID) {
        this.ID = ID;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String nombre) {
        Color = nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getTamannio() {
        return Tamannio;
    }

    public void setTamannio(String tamannio) {
        Tamannio = tamannio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camisas)) return false;
        Camisas camisas = (Camisas) o;
        return Float.compare(camisas.getPrecio(), getPrecio()) == 0 && getColor().equals(camisas.getColor()) && getDesc().equals(camisas.getDesc());

    }

    @Override
    public String toString() {
        return "Camisas{" +
                "Color='" + Color + '\'' +
                ", Precio=" + Precio +
                ", Desc='" + Desc + '\'' +
                ", Tamannio='" + Tamannio + '\'' +
                ", Imagen='" + Imagen + '\'' +
                ", ID=" + ID +
                '}';
    }
}

