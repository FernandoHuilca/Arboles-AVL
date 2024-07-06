
import javax.swing.JOptionPane;

public class ArbolAVL {
    private Nodo raiz;

    // Método para crear el árbol AVL
    /**
     * AlgoritmocrearÁrbol
        infoDeLaRaiz como Entero
        infoNuevoNodo como Entero
        opcion como Entero

        infoDeLaRaiz = PedirDatos("Ingrese la raíz del árbol: ")
        raiz = CrearNodo(infoDeLaRaiz)

        opcion = Preguntar("¿Desea ingresar más nodos?")

        Mientras opcion == SI
            infoNuevoNodo = PedirDatos("Ingrese la info del nuevo nodo ")
            Llamar a insertarNodo(infoNuevoNodo)
            opcion = Preguntar("¿Desea ingresar más nodos?")
        FinMientras
    FinAlgoritmo
     */
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

    /**
     * 
     * @param nodo
     * @param info
     * @return
     * AlgoritmoInsertar(nodo, info) 
        Si (nodo == NULO) Entonces
        Retornar CrearNodo(info)
        FinSi

        Si (info < nodo.info) Entonces
            nodo.nodoIzquierdo = Llamar a insertar(nodo.nodoIzquierdo, info)
        Sino 
            Si (info > nodo.info) Entonces
                nodo.nodoDerecho = Llamar a insertar(nodo.nodoDerecho, info)
            Sino
            MostrarMensaje("Elemento ya existente: En un Árbol AVL, cada nodo debe tener un valor único.")
        Retornar nodo
    FinSi

    nodo.altura = 1 + Máximo(altura(nodo.nodoIzquierdo), altura(nodo.nodoDerecho))
    Retornar Llamar a balancear(nodo)
FinAlgoritmo
     */
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
    /** 
     * AlgoritmoEliminar(nodo, info) 
        Si (nodo == NULO) Entonces
        Retornar nodo
        FinSi

        Si (info < nodo.info) Entonces
            nodo.nodoIzquierdo = Llamar a eliminar(nodo.nodoIzquierdo, info)
        Sino 
            Si (info > nodo.info) Entonces
                nodo.nodoDerecho = Llamar a eliminar(nodo.nodoDerecho, info)
            Sino
                Si (nodo.nodoIzquierdo == NULO O nodo.nodoDerecho == NULO) Entonces
                    Definir temp como Nodo
                        Si (temp == nodo.nodoIzquierdo) Entonces
                            temp = nodo.nodoDerecho
                        Sino
                    temp = nodo.nodoIzquierdo
            FinSi
            Si (temp == NULO) Entonces
                nodo = NULO
            Sino
                nodo = temp
            FinSi
        Sino
            temp = Llamar a getNodoConMenorValor(nodo.nodoDerecho)
            nodo.info = temp.info
            nodo.nodoDerecho = Llamar a eliminar(nodo.nodoDerecho, temp.info)
        FinSi
    FinSi
    Si (nodo == NULO) Entonces
        Retornar nodo
    FinSi
    nodo.altura = 1 + Máximo(altura(nodo.nodoIzquierdo), altura(nodo.nodoDerecho))
    Retornar Llamar a balancear(nodo)
FinAlgoritmo
     */
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
    /**
     * 
     * @param nodo
     * @return
     * AlgoritmoGetNodoConMenorValor(nodo) Como Nodo
            Definir current como Nodo
            current = nodo

        Mientras current.nodoIzquierdo != NULO
            current = current.nodoIzquierdo
        FinMientras

        Retornar current
        FinAlgoritmo
     */
    private Nodo getNodoConMenorValor(Nodo nodo) {
        Nodo current = nodo;
        while (current.getNodoIzquierdo() != null) {
            current = current.getNodoIzquierdo();
        }
        return current;
    }

    // Método para buscar un nodo dentro del árbol
    /**
     * 
     * @param nodoInicial
     * @param infoABuscar
     * AlgoritmoBuscarNodoDentroDelÁrbol(nodoInicial, infoABuscar)
        Si (nodoInicial == NULO) Entonces
            MostrarMensaje("El elemento no se encuentra dentro del árbol")
        Sino
            Si (infoABuscar == nodoInicial.info) Entonces
                MostrarMensaje("El elemento " + infoABuscar + " fue encontrado con éxito.")
            Sino
                Si (infoABuscar < nodoInicial.info) Entonces
                    Llamar a buscarNodoDentroDelÁrbol(nodoInicial.nodoIzquierdo, infoABuscar)
                Sino
            Llamar a buscarNodoDentroDelÁrbol(nodoInicial.nodoDerecho, infoABuscar)
        FinSi
    FinAlgoritmo
     */
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
    /**
     * 
     * @param nodo
     * @return
     * AlgoritmoBalancear(nodo) 
            Definir balance como Entero
            balance = Llamar a getBalance(nodo)

            Si (balance > 1 Y Llamar a getBalance(nodo.nodoIzquierdo) >= 0) Entonces
                Retornar Llamar a rotacionDerecha(nodo)
            FinSi

            Si (balance > 1 Y Llamar a getBalance(nodo.nodoIzquierdo) < 0) Entonces
                nodo.nodoIzquierdo = Llamar a rotacionIzquierda(nodo.nodoIzquierdo)
                Retornar Llamar a rotacionDerecha(nodo)
            FinSi

            Si (balance < -1 Y Llamar a getBalance(nodo.nodoDerecho) <= 0) Entonces
                Retornar Llamar a rotacionIzquierda(nodo)
            FinSi

            Si (balance < -1 Y Llamar a getBalance(nodo.nodoDerecho) > 0) Entonces
                nodo.nodoDerecho = Llamar a rotacionDerecha(nodo.nodoDerecho)
            Retornar Llamar a rotacionIzquierda(nodo)
            FinSi
        Retornar nodo
    FinAlgoritmo
     */
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
    /**
     * 
     * @param y
     * @return
     * Función rotacionDerecha(y) 
            Definir x como Nodo
            Definir T2 como Nodo
            x = y.nodoIzquierdo
            T2 = x.nodoDerecho
            x.nodoDerecho = y
            y.nodoIzquierdo = T2
            y.altura = 1 + Máximo(altura(y.nodoIzquierdo), altura(y.nodoDerecho))
            x.altura = 1 + Máximo(altura(x.nodoIzquierdo), altura(x.nodoDerecho))
            Retornar x
        FinAlgoritmo

     */
    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.getNodoIzquierdo();
        Nodo T2 = x.getNodoDerecho();

        x.setNodoDerecho(y);
        y.setNodoIzquierdo(T2);

        y.setAltura(1 + Math.max(altura(y.getNodoIzquierdo()), altura(y.getNodoDerecho())));
        x.setAltura(1 + Math.max(altura(x.getNodoIzquierdo()), altura(x.getNodoDerecho())));

        return x;
    }

    /**
     * 
     * @param x
     * @return
     * AlgoritmoEtacionIzquierda(x) 
        Definir y como Nodo
        Definir T2 como Nodo
        y = x.nodoDerecho
        T2 = y.nodoIzquierdo
        y.nodoIzquierdo = x
        x.nodoDerecho = T2
        x.altura = 1 + Máximo(altura(x.nodoIzquierdo), altura(x.nodoDerecho))
        y.altura = 1 + Máximo(altura(y.nodoIzquierdo), altura(y.nodoDerecho))
        Retornar y
    FinAlgoritmo
     */
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
    /**
     * 
     * @param nodo
     * @return
     * AlgoritmoAltura(nodo) Como Entero
            Si (nodo == NULO) Entonces
                Retornar 0
            FinSi
        Retornar nodo.altura
    FinAlgoritmo
     */
    private int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }
    /**
     * 
     * @param nodo
     * @return
     * AlgoritmoGetBalance(nodo) Como Entero
        Si (nodo == NULO) Entonces
            Retornar 0
        FinSi
            Retornar altura(nodo.nodoIzquierdo) - altura(nodo.nodoDerecho)
        FinAlgoritmo
     */
    private int getBalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getNodoIzquierdo()) - altura(nodo.getNodoDerecho());
    }

    public Nodo getRaiz() {
        return raiz;
    }


/**
 * AlgoritmoToString 
    Definir arbol como Cadena
    arbol = ""
    Llamar a imprimirÁrbolAux(raiz, 0, arbol)
    Retornar arbol
FinAlgoritmo

AlgoritmoimprimirÁrbolAux(nodo, nivel, arbol)
    Si (nodo != NULO) Entonces
        Llamar a imprimirÁrbolAux(nodo.nodoDerecho, nivel + 1, arbol)
        Para i = 0 Hasta nivel - 1 Con Paso 1
            arbol = arbol + "                 "
        FinPara
        arbol = arbol + nodo.info + "\n"
        Llamar a imprimirÁrbolAux(nodo.nodoIzquierdo, nivel + 1, arbol)
    FinSi
FinAlgoritmo

 */
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