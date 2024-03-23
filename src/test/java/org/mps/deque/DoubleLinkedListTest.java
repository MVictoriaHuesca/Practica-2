package org.mps.deque;

import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> myLinkedList;

    @Nested
    @DisplayName("WhenEmpty")
    class WhenEmpty {

        @Test
        @DisplayName("Create a new DoubleLinkedList")
        public void createDoubleLinkedList() {
            myLinkedList = new DoubleLinkedList<Integer>();
            assertNotNull(myLinkedList);
            assertEquals(0, myLinkedList.size());
        }

        @Test
        @DisplayName("DeleteFirst cola vacia devuelve excepcion DoubleLinkedQueueException")
        public void deleteFirst_colaVacia_Test() {
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows(DoubleLinkedQueueException.class, ()->{
                myLinkedList.deleteFirst();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

        @Test
        @DisplayName("DeleteLast cola vacia devuelve excepcion DoubleLinkedQueueException")
        public void deleteLast_colaVacia_Test() {
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows    (DoubleLinkedQueueException.class, ()->{
                myLinkedList.deleteLast();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

        @Test
        @DisplayName("First cola vacia devuelve excepcion DoubleLinkedQueueException")
        public void first_colaVacia_Test() {
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows    (DoubleLinkedQueueException.class, ()->{
                myLinkedList.first();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

        @Test
        @DisplayName("Last cola vacia devuelve excepcion DoubleLinkedQueueException")
        public void last_colaVacia_Test(){
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows    (DoubleLinkedQueueException.class, ()->{
                myLinkedList.last();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

        @Test
        @DisplayName("Get index en cola vacia devuelve excepcion IndexOutOfBoundsException")
        public void get_colaVacia_Test(){
            myLinkedList = new DoubleLinkedList<>();
            IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, ()->{
                myLinkedList.get(0);
            });
            assertEquals("Index out of range", thrown.getMessage());
        }

        @Test
        @DisplayName("Contains en cola vacia devuelve false")
        public void contains_colaVacia_Test(){
            myLinkedList = new DoubleLinkedList<>();
            assertEquals(false, myLinkedList.contains(1));
        }

        @Test
        @DisplayName("Remove en cola vacia no hace nada") //11
        public void remove_colaVacia_Test(){
            myLinkedList = new DoubleLinkedList<>();
            myLinkedList.remove(1);
            assertEquals(0, myLinkedList.size());
        }

        @Test
        @DisplayName("Sort en cola vacia no hace nada")
        public void sort_colaVacia_Test(){
            myLinkedList = new DoubleLinkedList<>();
            myLinkedList.sort(Comparator.naturalOrder());
            assertEquals(0, myLinkedList.size());
        }
    }

    @Nested
    @DisplayName("When new")
    class WhenNew {

        @Test
        @DisplayName("Prepend nodo unico")
        public void prepend_soloUnNodo_Test(){
            myLinkedList = new DoubleLinkedList<>();
            myLinkedList.prepend(1);
            assertEquals(1, myLinkedList.size());
            assertEquals(1, myLinkedList.first());
            assertEquals(1, myLinkedList.last());
        }

        @Test
        @DisplayName("Append nodo unico")
        public void append_soloUnNodo_Test(){
            myLinkedList = new DoubleLinkedList<>();
            myLinkedList.append(1);
            assertEquals(1, myLinkedList.size());
            assertEquals(1, myLinkedList.first());
            assertEquals(1, myLinkedList.last());
        }

        @Nested
        @DisplayName("When not empty")
        class WhenNotEmpty {

            @Test
            @DisplayName("Append mas de un nodo")
            void append_masDeUnNodo_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                assertEquals(3, myLinkedList.size());
                assertEquals(1, myLinkedList.first());
                assertEquals(3, myLinkedList.last());
            }

            @Test
            @DisplayName("Prepend mas de un nodo")
            public void prepend_masDeUnNodo_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.prepend(1);
                myLinkedList.prepend(2);
                myLinkedList.prepend(3);
                assertEquals(3, myLinkedList.size());
                assertEquals(3, myLinkedList.first());
                assertEquals(1, myLinkedList.last());
            }

            @Test
            @DisplayName("DeleteFirst nodo unico")
            public void deleteFirst_soloUnNodo_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.prepend(1);
                myLinkedList.deleteFirst();
                assertEquals(0, myLinkedList.size());
            }

            @Test
            @DisplayName("DeleteFirst borrar una cola entera")
            public void deleteFirst_ColaEntera_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.prepend(1);
                myLinkedList.prepend(2);
                myLinkedList.prepend(3);
                myLinkedList.deleteFirst();
                myLinkedList.deleteFirst();
                myLinkedList.deleteFirst();
                assertEquals(0, myLinkedList.size());
            }

            @Test
            @DisplayName("DeleteLast nodo unico")
            public void deleteLast_soloUnNodo_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.deleteLast();
                assertEquals(0, myLinkedList.size());
            }

            @Test
            @DisplayName("DeleteLast borrar cola entera")
            public void deleteLast_ColaEntera_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                myLinkedList.deleteLast();
                myLinkedList.deleteLast();
                myLinkedList.deleteLast();
                assertEquals(0, myLinkedList.size());
            }

            @Test
            @DisplayName("Get con index > size devuelve IndexOutOfBoundsException")
            public void get_indexMayorQueSize_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, ()->{
                    myLinkedList.get(3);
                });
                assertEquals("Index out of range", thrown.getMessage());
            }

            @Test
            @DisplayName("Get con index correcto devuelve el item en la posicion index")
            public void get_indexCorrecto_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                assertEquals(2, myLinkedList.get(1));
            }

            @Test
            @DisplayName("Contains con item que no esta en la cola devuelve false")
            public void contains_itemNoEnCola_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                assertEquals(false, myLinkedList.contains(4));
            }

            @Test
            @DisplayName("Contains con item que esta en la cola devuelve true")
            public void contains_itemEnCola_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                assertEquals(true, myLinkedList.contains(2));
            }

            @Test
            @DisplayName("Remove con item que no esta en la cola no hace nada") 
            public void remove_itemNoEnCola_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                myLinkedList.remove(4);
                assertEquals(3, myLinkedList.size());
            }

            @Test
            @DisplayName("Remove con item que esta en la cola y no es terminal lo elimina") 
            public void remove_itemEnColaNoTerminal_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                myLinkedList.remove(2);
                assertEquals(2, myLinkedList.size());
                assertEquals(1, myLinkedList.first());
                assertEquals(3, myLinkedList.last());
            }

            @Test
            @DisplayName("Remove con item que esta en la cola y es primer nodo lo elimina")
            public void remove_itemEnColaPrimerNodo_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                myLinkedList.remove(1);
                assertEquals(2, myLinkedList.size());
                assertEquals(2, myLinkedList.first());
                assertEquals(3, myLinkedList.last());
            }

            @Test
            @DisplayName("Remove con item que esta en la cola y es ultimo nodo lo elimina") 
            public void remove_itemEnColaUltimoNodo_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.append(3);
                myLinkedList.remove(3);
                assertEquals(2, myLinkedList.size());
                assertEquals(1, myLinkedList.first());
                assertEquals(2, myLinkedList.last());
            }

            @Test
            @DisplayName("Remove con item que esta en la cola y es el unico nodo lo elimina") 
            public void remove_itemEnColaUnicoNodo_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(1);
                myLinkedList.remove(1);
                assertEquals(0, myLinkedList.size());
            }

            @Test
            @DisplayName("Sort con cola desordenada la ordena")
            public void sort_colaDesordenada_Test() {
                myLinkedList = new DoubleLinkedList<>();
                myLinkedList.append(3);
                myLinkedList.append(1);
                myLinkedList.append(2);
                myLinkedList.sort(Comparator.naturalOrder());
                assertEquals(1, myLinkedList.first());
                assertEquals(2, myLinkedList.get(1));
                assertEquals(3, myLinkedList.last());
            }
        }
    }
}