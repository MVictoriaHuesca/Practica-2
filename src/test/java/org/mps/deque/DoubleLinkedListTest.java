package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;

import java.util.Comparator;

public class DoubleLinkedListTest {

    @DisplayName("Prueba unitaria que comprueba que el objeto creado no es nulo")
    @Test
    void create_Object_Correctly(){
        DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();

        assertNotNull(dbl);
    }

    @Nested
    @DisplayName("Clase con pruebas para insertar elementos")
    class TestInsertElement {

        @DisplayName("Prueba que se ha añadido un elemento al principio de la lista")
        @Test
        void prepend_InsertElementInFirstPosition_Correctly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();

            dbl.prepend(1);
            dbl.prepend(2);
            int valueFirst = dbl.first();
            int valueLast = dbl.last();
            int tam = dbl.size();

            assertEquals(2, valueFirst);
            assertEquals(1, valueLast);
            assertEquals(2, tam);
        }

        @DisplayName("Prueba que se ha añadido un elemento al final de la lista")
        @Test
        void append_InsertElementInLastPosition_Correctly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();

            dbl.append(1);
            dbl.append(2);
            int valueFirst = dbl.first();
            int valueLast = dbl.last();
            int tam = dbl.size();

            assertEquals(1, valueFirst);
            assertEquals(2, valueLast);
            assertEquals(2, tam);
        }
        
    }
    
    @Nested
    @DisplayName("Clase con pruebas que devuelven una excepcion")
    public class TestReturnsExceptions {

        @DisplayName("Prueba que no se puede borrar el primer elemento de una lista vacia")
        @Test
        void deleteFirst_DeleteFirstElementFromEmptyList_ReturnsException(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            
            assertThrows(DoubleLinkedQueueException.class, ()-> {
                dbl.deleteFirst();
            });
        } 

        @DisplayName("Prueba que no se puede borrar el primer elemento de una lista vacia")
        @Test
        void deleteLast_DeleteFirstElementFromEmptyList_ReturnsException(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            
            assertThrows(DoubleLinkedQueueException.class, ()-> {
                dbl.deleteLast();
            });
        }

        @DisplayName("Prueba que no devuelve elemento cuando index es mayor que size")
        @Test
        void get_IndexIsGreaterThanSize_ReturnsException(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            assertThrows(IndexOutOfBoundsException.class, () -> {
                dbl.get(4);
            });
        }

        @DisplayName("Prueba que no devuelve elemento cuando index es menor que 0")
        @Test
        void get_IndexIsLessThanZero_ReturnsException(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            assertThrows(IndexOutOfBoundsException.class, () -> {
                dbl.get(-4);
            });
        }
    }

    @Nested
    @DisplayName("Clase con pruebas para borrar elemento de lista no vacia")
    public class TestDelete {

        @DisplayName("Prueba que se ha eliminado el primer elemento de la lista")
        @Test
        void deleteFirst_DeleteFirstElement_Correctly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);

            dbl.deleteFirst();
            int valueFirst = dbl.first();
            int valueLast = dbl.last();
            int tam = dbl.size();

            assertEquals(2, valueFirst);
            assertEquals(2, valueLast);
            assertEquals(1, tam);
        }

        @DisplayName("Prueba que se ha eliminado el ultimo elemento de la lista")
        @Test
        void deleteLast_DeleteLastElement_Correctly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);

            dbl.deleteLast();
            int valueFirst = dbl.first();
            int valueLast = dbl.last();
            int tam = dbl.size();

            assertEquals(1, valueFirst);
            assertEquals(1, valueLast);
            assertEquals(1, tam);
        }

        @DisplayName("Prueba que se ha eliminado el valor dado en el primer nodo")
        @Test
        void remove_RemovesElementFromFirstNodeCorrectly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            dbl.remove(1);
            int firstNode = dbl.first();
            int lastNode = dbl.last();
            int size = dbl.size();

            assertEquals(2, firstNode);
            assertEquals(3, lastNode);
            assertEquals(2, size);
        }

        @DisplayName("Prueba que se ha eliminado el valor dado en el ultimo nodo")
        @Test
        void remove_RemovesElementFromLastNodeCorrectly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            dbl.remove(3);
            int firstNode = dbl.first();
            int lastNode = dbl.last();
            int size = dbl.size();

            assertEquals(1, firstNode);
            assertEquals(2, lastNode);
            assertEquals(2, size);
        }

        @DisplayName("Prueba que se ha eliminado el valor dado en un nodo no terminal")
        @Test
        void remove_RemovesElementFromNotTerminalNodeCorrectly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            dbl.remove(2);
            int firstNode = dbl.first();
            int lastNode = dbl.last();
            int size = dbl.size();

            assertEquals(1, firstNode);
            assertEquals(3, lastNode);
            assertEquals(2, size);
        }

        @DisplayName("Prueba que se ha eliminado el valor dado en una lista con un elemento")
        @Test
        void remove_RemovesElementFromListWithOneElementCorrectly(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);

            dbl.remove(1);

            int size = dbl.size();

            assertEquals(0, size);
            assertThrows(DoubleLinkedQueueException.class, () -> {
                dbl.first();
            });
        }
    }

    
    @Nested
    @DisplayName("Clase con pruebas de consulta")
    public class testGetter {
        
        @DisplayName("Prueba que no se puede consultar el primer elemento de una lista vacia")
        @Test
        void first_ReturnsFirstFromEmptyList_ReturnsException(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            
            assertThrows(DoubleLinkedQueueException.class, ()-> {
                dbl.first();
            });
        }

        @DisplayName("Prueba que no se puede consultar el ultimo elemento de una lista vacia")
        @Test
        void last_ReturnsLastFromEmptyList_ReturnsException(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            
            assertThrows(DoubleLinkedQueueException.class, ()-> {
                dbl.last();
            });
        }


        @DisplayName("Prueba que devuelve el elemento en el index dado")
        @Test
        void get_ReturnsCorrectElement(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            int resultado = dbl.get(1);

            assertEquals(2, resultado);
        }

        @DisplayName("Prueba que contiene el numero dado devolviendo true")
        @Test
        void contains_TheValueIsInTheList_ReturnsTrue(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            boolean resultado = dbl.contains(2);

            assertTrue(resultado);
        }

        @DisplayName("Prueba que no contiene el numero dado devolviendo false")
        @Test
        void contains_TheValueIsNotInTheList_ReturnsFalse(){
            DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
            dbl.append(1);
            dbl.append(2);
            dbl.append(3);

            boolean resultado = dbl.contains(4);

            assertFalse(resultado);
        }
        
    }

    @DisplayName("Prueba que se ordena la lista correctamente")
    @Test
    void sort_SortTheListCorrectly(){
        DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
        dbl.append(2);
        dbl.append(3);
        dbl.append(1);

        Comparator<Integer> comparador = (a1,a2) -> a1.compareTo(a2);

        dbl.sort(comparador);
        int firstNode = dbl.first();
        int lastNode = dbl.last();

        assertEquals(1, firstNode);
        assertEquals(3, lastNode);
    }
    
    @DisplayName("Prueba que devuelve excepcion cuando se ordena una lista vacia")
    @Test
    void sort_SortEmptyList_ReturnsException(){
        DoubleLinkedList<Integer> dbl = new DoubleLinkedList<Integer>();
        Comparator<Integer> comparador = (a1,a2) -> a1.compareTo(a2);

        assertThrows(NullPointerException.class, () -> {
            dbl.sort(comparador);
        });
    }

    
}
