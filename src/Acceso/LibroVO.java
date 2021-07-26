package Acceso;

public class LibroVO {

    public int getID_Book() {
        return ID_Book;
    }

    public void setID_Book(int ID_Book) {
        this.ID_Book = ID_Book;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getCant_Rev() {
        return Cant_Rev;
    }

    public void setCant_Rev(int Cant_Rev) {
        this.Cant_Rev = Cant_Rev;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int ID_Price) {
        this.Price = ID_Price;
    }

    @Override
    public String toString() {
        return Nombre;
    }
    
    
    private int ID_Book;
    private String Nombre;
    private int Cantidad;
    private int Cant_Rev;
    private int Price;
    
}
