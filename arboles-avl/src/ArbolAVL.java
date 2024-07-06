
import javax.swing.*;

public class ArbolAVL {
    private Nodo raiz;

    // Método para crear el árbol AVL
    public void crearÁrbol() {
        int infoDeLaRaiz = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la raíz del árbol: "));
        raiz = new Nodo(infoDeLaRaiz);
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar más nodos?");
        while (opcion == JOptionPane.YES_OPTION) {
            int infoNuevoNodo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info del nuevo nodo "));
            insertarNodo(infoNuevoNodo);
            opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar más nodos?");
        }
    }

    // Método para insertar nodos en el árbol AVL
    public void insertarNodo(int info) {
        raiz = insertar(raiz, info);
    }

    private Nodo insertar(Nodo nodo, int info) {
        if (nodo == null) {
            return new Nodo(info);
        }

        if (info < nodo.getInfo()) {
            nodo.setNodoIzquierdo(insertar(nodo.getNodoIzquierdo(), info));
        } else if (info > nodo.getInfo()) {
            nodo.setNodoDerecho(insertar(nodo.getNodoDerecho(), info));
        } else {
            JOptionPane.showMessageDialog(null,
                    "Elemento ya existente: " +
                            "\n\nEn un Árbol AVL, cada nodo " +
                            "\ndebe tener un valor único. Esto significa que no se permiten " +
                            "\nvalores duplicados en el árbol ");
            return nodo;
        }

        nodo.setAltura(1 + Math.max(altura(nodo.getNodoIzquierdo()), altura(nodo.getNodoDerecho())));
        return balancear(nodo);
    }

    // Método para eliminar nodos del árbol AVL
    public void eliminarNodo(int info) {
        raiz = eliminar(raiz, info);
    }

    private Nodo eliminar(Nodo nodo, int info) {
        if (nodo == null) {
            return nodo;
        }

        if (info < nodo.getInfo()) {
            nodo.setNodoIzquierdo(eliminar(nodo.getNodoIzquierdo(), info));
        } else if (info > nodo.getInfo()) {
            nodo.setNodoDerecho(eliminar(nodo.getNodoDerecho(), info));
        } else {
            if ((nodo.getNodoIzquierdo() == null) || (nodo.getNodoDerecho() == null)) {
                Nodo temp = null;
                if (temp == nodo.getNodoIzquierdo()) {
                    temp = nodo.getNodoDerecho();
                } else {
                    temp = nodo.getNodoIzquierdo();
                }

                if (temp == null) {
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                Nodo temp = getNodoConMenorValor(nodo.getNodoDerecho());
                nodo.setInfo(temp.getInfo());
                nodo.setNodoDerecho(eliminar(nodo.getNodoDerecho(), temp.getInfo()));
            }
        }

        if (nodo == null) {
            return nodo;
        }

        nodo.setAltura(1 + Math.max(altura(nodo.getNodoIzquierdo()), altura(nodo.getNodoDerecho())));
        return balancear(nodo);
    }

    private Nodo getNodoConMenorValor(Nodo nodo) {
        Nodo current = nodo;
        while (current.getNodoIzquierdo() != null) {
            current = current.getNodoIzquierdo();
        }
        return current;
    }

    // Método para buscar un nodo dentro del árbol
    public void buscarNodoDentroDelÁrbol(Nodo nodoInicial, int infoABuscar) {
        if (nodoInicial == null) {
            JOptionPane.showMessageDialog(null, "El elemento no se encuentra dentro del árbol");
        } else if (infoABuscar == nodoInicial.getInfo()) {
            JOptionPane.showMessageDialog(null, "El elemento " + infoABuscar + " fue encontrado con éxito." + nodoInicial);
        } else if (infoABuscar < nodoInicial.getInfo()) {
            buscarNodoDentroDelÁrbol(nodoInicial.getNodoIzquierdo(), infoABuscar);
        } else {
            buscarNodoDentroDelÁrbol(nodoInicial.getNodoDerecho(), infoABuscar);
        }
    }

    // Método para balancear el árbol
    private Nodo balancear(Nodo nodo) {
        int balance = getBalance(nodo);

        if (balance > 1 && getBalance(nodo.getNodoIzquierdo()) >= 0) {
            return rotacionDerecha(nodo);
        }

        if (balance > 1 && getBalance(nodo.getNodoIzquierdo()) < 0) {
            nodo.setNodoIzquierdo(rotacionIzquierda(nodo.getNodoIzquierdo()));
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && getBalance(nodo.getNodoDerecho()) <= 0) {
            return rotacionIzquierda(nodo);
        }

        if (balance < -1 && getBalance(nodo.getNodoDerecho()) > 0) {
            nodo.setNodoDerecho(rotacionDerecha(nodo.getNodoDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Métodos de rotación
    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.getNodoIzquierdo();
        Nodo T2 = x.getNodoDerecho();

        x.setNodoDerecho(y);
        y.setNodoIzquierdo(T2);

        y.setAltura(1 + Math.max(altura(y.getNodoIzquierdo()), altura(y.getNodoDerecho())));
        x.setAltura(1 + Math.max(altura(x.getNodoIzquierdo()), altura(x.getNodoDerecho())));

        return x;
    }

    private Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.getNodoDerecho();
        Nodo T2 = y.getNodoIzquierdo();

        y.setNodoIzquierdo(x);
        x.setNodoDerecho(T2);

        x.setAltura(1 + Math.max(altura(x.getNodoIzquierdo()), altura(x.getNodoDerecho())));
        y.setAltura(1 + Math.max(altura(y.getNodoIzquierdo()), altura(y.getNodoDerecho())));

        return y;
    }

    // Métodos auxiliares
    private int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    private int getBalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getNodoIzquierdo()) - altura(nodo.getNodoDerecho());
    }

    public Nodo getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        StringBuilder arbol = new StringBuilder();
        imprimirÁrbolAux(raiz, 0, arbol);
        return arbol.toString();
    }

    // Método auxiliar para imprimir el árbol en forma de texto
    private void imprimirÁrbolAux(Nodo nodo, int nivel, StringBuilder arbol) {
        if (nodo != null) {
            imprimirÁrbolAux(nodo.getNodoDerecho(), nivel + 1, arbol);
            for (int i = 0; i < nivel; i++) {
                arbol.append("                 ");
            }
            arbol.append(nodo.getInfo()).append("\n");
            imprimirÁrbolAux(nodo.getNodoIzquierdo(), nivel + 1, arbol);
        }
    }
}