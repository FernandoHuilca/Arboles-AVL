
public class Nodo {
    private int info;
    private int altura;
    private Nodo nodoDerecho;
    private Nodo nodoIzquierdo;

    // Constructor sin parámetros
    public Nodo() {
        nodoDerecho = null;
        nodoIzquierdo = null;
        info = 0;
        altura = 1;
    }

    // Constructor con información del nodo
    public Nodo(int infoNuevoNodo) {
        nodoDerecho = null;
        nodoIzquierdo = null;
        info = infoNuevoNodo;
        altura = 1;
    }

    // Getters y Setters
    public void setInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "\nInfo " + info +
                "\nNodoDerecho " + (nodoDerecho != null ? nodoDerecho.getInfo() : "null") +
                "\nNodoIzquierdo " + (nodoIzquierdo != null ? nodoIzquierdo.getInfo() : "null");
    }
}