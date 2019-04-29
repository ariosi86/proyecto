package modelo;

public class Productos {
private static String nombre;
private static Float precio;
private static String descripcion;


public Productos(String n, String d, String i,Float p){
    nombre = n;
    precio = p;
    descripcion = d;

}

public String getNombre(){
    return nombre;
}

public Float getPrecio(){
    return precio;
}

public String getDescripcion(){
    return descripcion;
}
}