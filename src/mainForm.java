import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;

    Plato platoEliminar;
    Menu menu;

    public mainForm() {

        menu = new Menu();

        InitComboBox();
        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //The data should be validated first if it is empty or not
                String nombre = textIngresoNombre.getText();
                float precio = textIngresoPrecio.getText().equals("") ? 0 : Float.parseFloat(textIngresoPrecio.getText());
                float calorias = textIngresoCalorias.getText().equals("") ? 0 : Float.parseFloat(textIngresoCalorias.getText());
                int preparacion = textIngresoPreparacion.getText().equals("") ? 0 : Integer.parseInt(textIngresoPreparacion.getText());

                if(nombre.equals("") || precio <= 0 || calorias <= 0 || preparacion <= 0) {
                    textAIngresoPlatos.setText("Faltan datos o datos mal ingresados");
                }
                else{
                    String plato = menu.agregarPlato(new Plato(nombre, precio, calorias, preparacion));
                    textAIngresoPlatos.setText(plato);
                }
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAIngresoPlatos.setText(menu.QuemarPlatos());
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato platoModificar = menu.buscarPlato(textoModifNombre.getText());

                if(platoModificar == null) {
                    textAModif.setText("No se encontro el plato");
                }
                else{
                    textAModif.setText("Plato encontrado");

                    textoModifPrecio.setText(String.valueOf(platoModificar.getPrecio()));
                    textoModifPrecio.setEditable(true);
                    textoModifCalorias.setText(String.valueOf(platoModificar.getCalorias()));
                    textoModifCalorias.setEditable(true);
                    textoModifPreparacion.setText(String.valueOf(platoModificar.getTiempoPreparacion()));
                    textoModifPreparacion.setEditable(true);
                }
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Gets all data from fields
                String nombre = textoModifNombre.getText();
                float precio = textoModifPrecio.getText().equals("") ? 0 : Float.parseFloat(textoModifPrecio.getText());
                float calorias = textoModifCalorias.getText().equals("") ? 0 : Float.parseFloat(textoModifCalorias.getText());
                int preparacion = textoModifPreparacion.getText().equals("") ? 0 : Integer.parseInt(textoModifPreparacion.getText());

                if(nombre.equals("") || precio <= 0 || calorias <= 0 || preparacion <= 0) {
                    textAModif.setText("Faltan datos o datos mal ingresados");
                }
                else{
                    Plato platoModificado = new Plato(nombre, precio, calorias, preparacion);
                    textAModif.setText(menu.modificarPlato(platoModificado));
                    textoModifNombre.setText("");
                    textoModifPrecio.setText("");
                    textoModifPrecio.setEditable(false);
                    textoModifCalorias.setText("");
                    textoModifCalorias.setEditable(false);
                    textoModifPreparacion.setText("");
                    textoModifPreparacion.setEditable(false);
                }
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                platoEliminar = menu.buscarPlato(textNombreEliminar.getText());

                if(platoEliminar == null) {
                    textAEliminar.setText("No se encontro el plato");
                }
                else{
                    textAEliminar.setText(platoEliminar.toString());
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(platoEliminar != null){
                    textAEliminar.setText(menu.eliminarPlato(platoEliminar));
                }
                else{
                    textAEliminar.setText("No se encontro el plato");
                }
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAMostrar.setText(menu.MostrarPlatos(comboBoxOrder.getSelectedIndex()));
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAMostrar.setText(menu.MostrarPlatos(comboBoxOrder.getSelectedIndex()));
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textBuscarPlatoOrden.getText().equals("")) {
                    textAMostrar.setText("Ingrese un dato a buscar");
                    return;
                }

                Plato plato = menu.buscarPlatoBinario(textBuscarPlatoOrden.getText(), comboBoxOrder.getSelectedIndex());

                if(plato == null) {
                    textAMostrar.setText("No se encontro el plato");
                }
                else{
                    textAMostrar.setText(plato.toString());
                }
            }
        });
    }

    private void InitComboBox() {
        comboBoxOrder.addItem("Nombre");
        comboBoxOrder.addItem("Precio");
        comboBoxOrder.addItem("Calorias");
        comboBoxOrder.addItem("Tiempo de preparacion");

        comboBoxOrder.setSelectedIndex(0);
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
