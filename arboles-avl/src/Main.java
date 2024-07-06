import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Sebastián Ramos, Fernando Huilca, Juan Mateo Quisilema
        ArbolAVL arbolAVL = new ArbolAVL();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    " _______________ ELIJA UNA OPERACIÓN ÁRBOLES AVL _______________ \n\n" +

                            "                                     1)  CREACIÓN DEL ÁRBOL AVL \n\n" +

                            "                                     2)  BUSCAR DENTRO DEL ÁRBOL\n\n" +

                            "                                     3)  INSERTAR EN EL ÁRBOL\n\n" +

                            "                                     4)  ELIMINAR ALGÚN ELEMENTO\n\n" +

                            "                                     5)  VER ÁRBOL AVL\n\n" +

                            "                                     0)  SALIR\n\n"));
            switch (opcion) {
                case 1:
                    arbolAVL.crearÁrbol();
                    JOptionPane.showMessageDialog(null, "El árbol AVL ha quedado de la siguiente manera: \n " + arbolAVL);
                    break;
                case 2:
                    int infoABuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info que se desea buscar"));
                    arbolAVL.buscarNodoDentroDelÁrbol(arbolAVL.getRaiz(), infoABuscar);
                    break;
                case 3:
                    int infoNuevoNodo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info del nuevo nodo "));
                    arbolAVL.insertarNodo(infoNuevoNodo);
                    JOptionPane.showMessageDialog(null, "El árbol AVL ha quedado de la siguiente manera: \n " + arbolAVL);
                    break;
                case 4:
                    int infoAEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info que se desea eliminar"));
                    arbolAVL.eliminarNodo(infoAEliminar);
                    JOptionPane.showMessageDialog(null, "El árbol AVL ha quedado de la siguiente manera: \n " + arbolAVL);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "El árbol AVL es el siguiente: \n " + arbolAVL);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA, gracias por usarlo :D.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR. Elija una opción de las que se presentan. Pilas.");
                    break;
            }
        } while (opcion != 0);
    }
}
