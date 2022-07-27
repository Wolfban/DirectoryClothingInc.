package Controlador;
import Modelo.Camisas;
import Modelo.Usuarios;
import Modelo.Catalogos;

import java.util.ArrayList;


public class Almacenamiento {

    public static ArrayList<Usuarios> poolusuarios = new ArrayList<>();
    public static  ArrayList<Camisas> poolcamisas = new ArrayList<>();
    public  static  ArrayList<Catalogos> poolcatalogos = new ArrayList<>();

    /**
     * La funcion RevisarID recibe los datos de la ID para compararla en el pool de usuarios para saber si no se repite
     * @author Esteban Barrera
     * @param id recibe un Integer
     * @return retorna un dato tipo Boolean
     */
    public static boolean RevisarID(int id){
        boolean DobleID = false;
        for(int i = 0; i< poolusuarios.size(); i++){
            if(id == poolusuarios.get(i).getID()){
                DobleID = true;
            }
        }
        return DobleID;
    }

    /**
     * La funcion agregarCliente agrega los clientes a los pool de usuarios
     * @author Esteban Barrera
     * @param nombre recibe un parametro tipo String
     * @param primerApellido recibe un parametro tipo String
     * @param segundoApellido recibe un parametro tipo String
     * @param direccion recibe un parametro tipo String
     * @param correo recibe un parametro tipo String
     * @param id recibe un parametro tipo Integer
     * @return retorna un dato Boolean
     */
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

    /**
     * La funcion agregarCamisa agrega las camisas en el pool de camisas
     * @author Esteban Barrera
     * @param nombre recibe un tipo de dato String
     * @param precios recibe un tipo de dato float
     * @param Descripcion recibe un tipo de dato  String
     * @param Tamannio recibe un tipo de dato String
     * @param Img recibe un tipo de dato String
     * @param Id recibe un tipo de dato Integer
     * @return retorna un tipo de dato Boolean
     */
    public static boolean agregarCamisa (String nombre, float precios, String Descripcion, String Tamannio, String Img, int Id) {
        Camisas camisanueva = new Camisas(nombre, precios, Descripcion, Tamannio, Img,  Id);
        poolcamisas.add(camisanueva);
        return false;
    }

    /**
     * La funcion agregarCatalogo agrega los Catalogos en el pool de los catalogos
     * @author Esteban Barrera
     * @param nombre recibe un dato tipo String
     * @param FechaCreacion recibe un dato tipo String
     * @param Id recibe un dato tipo Integer
     * @return retorna un dato tipo boolean
     */
    public static boolean agregarCatalogo (String nombre, String FechaCreacion, int Id){
        Catalogos catalogonuevo = new Catalogos(nombre, FechaCreacion, Id);
        poolcatalogos.add(catalogonuevo);
        return false;
    }

    /**
     * La funcion FindCami sirve para buscar los ID de las camisas encontrar a la camisa que se esta buscando o se esta utilizando en alguna otra funcion
     * @author Esteban Barrera
     * @param IdCami recibe un dato tipo Integer
     * @return retorna un dato tipo Integer
     */
    public static int FindCami ( int IdCami){
        int CamiFound = 0;
        for (Camisas poolcamisa : poolcamisas) {
            if (poolcamisa.getID() == IdCami) {
                CamiFound = IdCami;

            }
        }
        return CamiFound;
    }

    /**
     * La funcion agregarCamisetaCatalogo sirve para agregar la camisa al catalogo, busca los dos ID y agrega la camisa al catalogo
     * @author Esteban Barrera
     * @param IdCami recibe un dato tipo Integer
     * @param IdCat recibe un dato tipo Integer
     * @return retorna un dato tipo Boolean
     */
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
