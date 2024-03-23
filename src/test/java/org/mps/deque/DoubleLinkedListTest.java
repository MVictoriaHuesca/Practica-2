package org.mps.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("DoubleLinkedList")
public class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> myLinkedList;

    @Nested
    @DisplayName("WhenEmpty")
    class WhenEmpty {

        @Test
        @DisplayName("Create a new DoubleLinkedList")
        public void createDoubleLinkedList() {
            myLinkedList = new DoubleLinkedList<>();
            assertNotNull(myLinkedList);
            assertEquals(0, myLinkedList.size());
        }

        @Test
        @DisplayName("DeleteFirst cola vacia devuelve excepcion DoubleLinkedQueueException")
        void deleteFirst_colaVacia_Test() {
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows    (DoubleLinkedQueueException.class, ()->{
                myLinkedList.deleteFirst();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

        @Test
        @DisplayName("DeleteLast cola vacia devuelve excepcion DoubleLinkedQueueException")
        void deleteLast_colaVacia_Test() {
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows    (DoubleLinkedQueueException.class, ()->{
                myLinkedList.deleteLast();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

        @Test
        @DisplayName("First cola vacia devuelve excepcion DoubleLinkedQueueException")
        void first_colaVacia_Test() {
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows    (DoubleLinkedQueueException.class, ()->{
                myLinkedList.first();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

        @Test
        @DisplayName("Last cola vacia devuelve excepcion DoubleLinkedQueueException")
        void last_colaVacia_Test() {
            myLinkedList = new DoubleLinkedList<>();
            DoubleLinkedQueueException thrown = assertThrows    (DoubleLinkedQueueException.class, ()->{
                myLinkedList.last();
            });
            assertEquals("The LinkedList is empty", thrown.getMessage());
        }

    }

    @Nested
    @DisplayName("When new")
    class WhenNew {

        @Test
        @DisplayName("Prepend nodo unico")
        public void prepend_soloUnNodo_Test() {
            myLinkedList = new DoubleLinkedList<>();
            myLinkedList.prepend(1);
            assertEquals(1, myLinkedList.size());
            assertEquals(1, myLinkedList.first());
            assertEquals(1, myLinkedList.last());
        }

        @Test
        @DisplayName("Append nodo unico")
        public void append_soloUnNodo_Test() {
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
        }
    }
}