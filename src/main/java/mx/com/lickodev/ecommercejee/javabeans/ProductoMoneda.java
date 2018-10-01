package mx.com.lickodev.ecommercejee.javabeans;

/**
 *
 * @author Santa Cecilia
 */
public class ProductoMoneda {

    private String moneda;
    private float precio;
    private float precionuevo;
    private int webid;

    public ProductoMoneda() {
    }

    public ProductoMoneda(String moneda, float precio, float precionuevo, int webid) {
        this.moneda = moneda;
        this.precio = precio;
        this.precionuevo = precionuevo;
        this.webid = webid;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecionuevo() {
        return precionuevo;
    }

    public void setPrecionuevo(float precionuevo) {
        this.precionuevo = precionuevo;
    }

    public int getWebid() {
        return webid;
    }

    public void setWebid(int webid) {
        this.webid = webid;
    }

    @Override
    public String toString() {
        return "ProductoMoneda{" + "moneda=" + moneda + ", precio=" + precio + ", precionuevo=" + precionuevo + ", webid=" + webid + '}';
    }

}
