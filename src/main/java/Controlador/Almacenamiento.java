package Controlador;
import Modelo.Camisas;
import Modelo.Usuarios;
import Modelo.Catalogos;

import java.util.ArrayList;

public class Almacenamiento {
    public static ArrayList<Usuarios> poolusuarios = new ArrayList<>();
    public static  ArrayList<Camisas> poolcamisas = new ArrayList<>();
    public  static  ArrayList<Catalogos> poolcatalogos = new ArrayList<>();

    public static boolean RevisarID(int id){
        boolean DobleID = false;
        for(int i = 0; i< poolusuarios.size(); i++){
            if(id == poolusuarios.get(i).getID()){
                DobleID = true;
            }
        }
        return DobleID;
    }

    public static boolean agregarCliente (String nombre, String primerApellido, String segundoApellido, String direccion, String correo, int id) {
        boolean hayError = false;
        Usuarios usuarionew = new Usuarios(nombre, primerApellido, segundoApellido, direccion, correo, id);
        if (poolusuarios.size() == 0){
            poolusuarios.add(usuarionew);

        } else if (!RevisarID(id)) {
            poolusuarios.add(usuarionew);
        }else{
            hayError = true;
        }
        return hayError;
    }

    public static boolean agregarCamisa (String nombre, float precios, String Descripcion, String Tamannio, String Img, int Id) {
        Camisas camisanueva = new Camisas(nombre, precios, Descripcion, Tamannio, Img,  Id);
        poolcamisas.add(camisanueva);
        return false;
    }
    public static boolean agregarCatalogo (String nombre, String FechaCreacion, int Id){
        Catalogos catalogonuevo = new Catalogos(nombre, FechaCreacion, Id);
        poolcatalogos.add(catalogonuevo);
        return false;
    }
    public static int FindCami ( int IdCami){
        int CamiFound = 0;
        for (Camisas poolcamisa : poolcamisas) {
            if (poolcamisa.getID() == IdCami) {
                CamiFound = IdCami;

            }
        }
        return CamiFound;
    }
    public static boolean agregarCamisetaCatalogo (int IdCami,int IdCat) {
        boolean Error = false;
        int CamienCat;
        CamienCat = FindCami(IdCami);
        if (CamienCat == 0) {
            Error = true;

        } else {
            for (int i = 0; i < poolcatalogos.size(); i++) {
                if (poolcatalogos.get(i).getID()==IdCat) {
                    poolcatalogos.get(i).getCamisas().add(CamienCat);
                } else {
                    Error = true;
                }
            }

        }

        return Error;
    }


}
