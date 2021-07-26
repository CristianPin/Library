package Negocio;

import Acceso.LibroDAO;
import Acceso.LibroVO;
import Presentacion.AdminInterface;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class DelegadoLibro {

    public void LlenarComboLibro(JComboBox Combo) {
        ArrayList<LibroVO> Libros = new LibroDAO().ConsultarLibros();
        int i = 0;
        while (i < Libros.size()) {
            Combo.addItem(Libros.get(i));
            i++;
        }
    }

    public void LlenarDatos(AdminInterface AI) {
        LibroVO Libro = (LibroVO) AI.cbLibros.getSelectedItem();
        AI.txtNameBook.setText(Libro.getNombre());
        AI.txtAvailableBook.setText(Integer.toString(Libro.getCantidad()));
        AI.txtReserveBook.setText(Integer.toString(Libro.getCant_Rev()));
        AI.txtPriceBook.setText(Integer.toString(Libro.getPrice()));
    }

    public boolean ModificarLibro(AdminInterface AI) {
        LibroVO Libro = (LibroVO) AI.cbLibros.getSelectedItem();
        LibroVO Libros = new LibroVO();

        Libros.setID_Book(Libro.getID_Book());
        Libros.setNombre(AI.txtNameBook.getText());
        Libros.setPrice(Integer.parseInt(AI.txtPriceBook.getText()));
        Libros.setCantidad(Integer.parseInt(AI.txtAvailableBook.getText()));
        Libros.setCant_Rev(Integer.parseInt(AI.txtReserveBook.getText()));
        if (new LibroDAO().ModificarLibro(Libros.getID_Book(), Libros.getNombre(), Libros.getPrice(), Libros.getCantidad(), Libros.getCant_Rev()) == 1) {
            return true;
        }else{
            return false;
        }

    }

}
