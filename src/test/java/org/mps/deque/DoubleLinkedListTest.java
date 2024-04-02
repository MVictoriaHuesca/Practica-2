/*
 * @autor1 = Eduardo García Rivas
 * @autor2 = María Victoria Huesca Peláez
 */

package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;

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
        
    }
}
