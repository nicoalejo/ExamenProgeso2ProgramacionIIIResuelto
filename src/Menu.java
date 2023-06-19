import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu {

    List<Plato> menuPlatos = new ArrayList<>();

    //Check if Plato.nombre exists using a for and returns -1 if it doesn't if exists returns index
    public int existePlato(String nombre){
        for (int i = 0; i < menuPlatos.size(); i++) {
            if (menuPlatos.get(i).getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public String agregarPlato(Plato plato){
        if(existePlato(plato.getNombre()) == -1){
            menuPlatos.add(plato);
            return plato.toString();
        }

        //Show Message that plato already exists
        return "El plato ya existe";
    }

    //Modify Plato
    public String modificarPlato(Plato plato){
        int indexPlato = existePlato(plato.getNombre());
        if(indexPlato != -1){
            menuPlatos.set(indexPlato, plato);
            return menuPlatos.get(indexPlato).toString();
        }
        else{
            //Show Message that plato already exists
            return "El plato no existe";
        }
    }

    public String eliminarPlato(Plato plato){
        int indexPlato = existePlato(plato.getNombre());
        if(indexPlato != -1){
            menuPlatos.remove(indexPlato);
            return "El plato se ha eliminado";
        }

        return "El plato no existe";
    }

    public Plato buscarPlato(String nombre){
        int indexPlato = existePlato(nombre);
        if(indexPlato != -1){
            return menuPlatos.get(indexPlato);
        }
        return null;
    }

    public Plato buscarPlatoBinario(String dato, int selectedIndex){
        Plato retornarPlato = null;
        MostrarPlatos(selectedIndex);

        switch (selectedIndex){
            case 0:
                //Ordenar por nombre
                retornarPlato = Ordenamiento.binarySearch(menuPlatos, Comparator.comparing(Plato::getNombre), new Plato(dato, 0, 0, 0));
                break;
            case 1:
                //Ordenar por precio
                float precio = Float.parseFloat(dato);
                retornarPlato = Ordenamiento.binarySearch(menuPlatos, Comparator.comparing(Plato::getPrecio), new Plato("", precio, 0, 0));
                break;
            case 2:
                //Ordenar por calorias
                float calorias = Float.parseFloat(dato);
                retornarPlato = Ordenamiento.binarySearch(menuPlatos, Comparator.comparing(Plato::getCalorias), new Plato("", 0, calorias, 0));
                break;
            case 3:
                //Ordenar por tiempo de preparacion
                int tiempoPreparacion = Integer.parseInt(dato);
                retornarPlato = Ordenamiento.binarySearch(menuPlatos, Comparator.comparing(Plato::getTiempoPreparacion), new Plato("", 0, 0, tiempoPreparacion));
                break;
        }

        return retornarPlato;
    }



    public String QuemarPlatos(){
        //Initialize 5 plates and returns a string with all the plates
        Plato plato1 = new Plato("Plato1", 100, 100, 5);
        Plato plato2 = new Plato("Plato2", 200, 500, 2);
        Plato plato3 = new Plato("Plato3", 300, 300, 3);
        Plato plato4 = new Plato("Plato4", 400, 200, 4);
        Plato plato5 = new Plato("Plato5", 500, 150, 5);

        agregarPlato(plato1);
        agregarPlato(plato2);
        agregarPlato(plato3);
        agregarPlato(plato4);
        agregarPlato(plato5);

        String platos = "";
        for (int i = 0; i < menuPlatos.size(); i++) {
            platos += menuPlatos.get(i).toString() + "\n";
        }

        return platos;
    }

    public String MostrarPlatos(int selectedIndex) {
        switch (selectedIndex){
            case 0:
                //Ordenar por nombre
                Ordenamiento.Burbuja(menuPlatos, Comparator.comparing(Plato::getNombre));
                break;
            case 1:
                //Ordenar por precio
                Ordenamiento.Burbuja(menuPlatos, Comparator.comparing(Plato::getPrecio));
                break; 
            case 2:
                //Ordenar por calorias
                Ordenamiento.Insercion(menuPlatos, Comparator.comparing(Plato::getCalorias));
                break;
            case 3:
                //Ordenar por tiempo de preparacion
                Ordenamiento.Insercion(menuPlatos, Comparator.comparing(Plato::getTiempoPreparacion));
                break;
        }
        String platos = "";

        for (int i = 0; i < menuPlatos.size(); i++) {
            platos += menuPlatos.get(i).toString() + "\n";
        }

        return platos;
    }

}
