public class Plato {

    //Creacion de variables
    private String nombre;
    private float precio;
    private float calorias;
    private int tiempoPreparacion;

    //Constructor
    public Plato(String nombre, float precio, float calorias, int tiempoPreparacion){
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public float getCalorias() {
        return calorias;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    //Override toString con los datos del plato usando saltos de linea por cada variable
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nPrecio: " + precio + "\nCalorias: " + calorias + "\nTiempo de Preparacion: " + tiempoPreparacion;
    }
}
