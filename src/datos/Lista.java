package datos;

import model.Identificable;

public class Lista<T extends Identificable> {
    private Nodo<T> cabeza;

    public Nodo<T> getCabeza() {
        return cabeza;
    }
    
    public boolean esVacio() {
        return cabeza == null;
    }

    public void insertarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (this.esVacio()) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public void elimina(int id) {
        if (cabeza == null) {
            System.out.println("La lista es vacía");
        } else {
            if (cabeza.getDato().getId() == id) {
                System.out.println("Eliminando elemento: " + cabeza.toString());
                cabeza = cabeza.getSiguiente();
            } else {
                Nodo<T> aux = cabeza;
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getDato().getId() == id) {
                        System.out.println("Eliminando elemento: " + aux.getSiguiente().toString());
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        return;
                    }
                    aux = aux.getSiguiente();
                }

                System.out.println("El elemento: " + id + " no se encuentra en la lista");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (esVacio()) {
            result.append("La lista está vacía");
        } else {
            Nodo<T> actual = cabeza;
            result.append(actual).append("\n");

            if (actual.getSiguiente() != null) {
                result.append("Siguiente: ").append(actual.getSiguiente()).append("\n");
            }
        }

        return "ListaEnlazada{\n" + result + '}';
    }
    
    public Lista<T> obtenerListaDeCanciones() {
        Lista<T> listaDeCanciones = new Lista<>();
        
        Nodo<T> actual = cabeza;
        while (actual != null) {
            listaDeCanciones.insertarAlFinal(actual.getDato());
            actual = actual.getSiguiente();
        }

        return listaDeCanciones;
    }
}
