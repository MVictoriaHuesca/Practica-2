package org.mps.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LinkedNodeTest {

    @Nested
    @DisplayName("Creación de un LinkedNode")
    class CreacionLinkedNode {

        @Test
        @DisplayName("Crear un nuevo LinkedNode")
        public void LinkedNode_Test() {
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
            assertEquals(item, node.getItem());
            assertEquals(previous, node.getPrevious());
            assertEquals(next, node.getNext());
        }

        @Test
        @DisplayName("Crear un nuevo LinkedNode con item nulo")
        public void LinkedNode_ItemNull_Test() {
            LinkedNode<Integer> node = new LinkedNode<>(null, null, null);
            assertNull(node.getItem());
            assertEquals(null, node.getPrevious());
            assertEquals(null, node.getNext());
        }
    }

    @Nested
    @DisplayName("Operaciones de LinkedNode")
    class OperacionesLinkedNode {

        @Nested
        @DisplayName("Operaciones de obtención")
        class OperacionesObtencion {

            @Test
            @DisplayName("Obtener el item de un LinkedNode")
            public void getItem_Test() {
                Integer item = 10;
                LinkedNode<Integer> node = new LinkedNode<>(item, null, null);
                assertEquals(item, node.getItem());
            }

            @Test
            @DisplayName("Obtener el nodo anterior de un LinkedNode")
            public void getPrevious_Test() {
                LinkedNode<Integer> previous = new LinkedNode<>(5, null,    null);
                LinkedNode<Integer> node = new LinkedNode<>(10, previous, null);
                assertEquals(previous, node.getPrevious());
            }

            @Test
            @DisplayName("Obtener el nodo siguiente de un LinkedNode")
            public void getNext_Test() {
                LinkedNode<Integer> next = new LinkedNode<>(15, null,   null);
                LinkedNode<Integer> node = new LinkedNode<>(10, null, next);
                assertEquals(next, node.getNext());
            }
        }

        @Nested
        @DisplayName("Operaciones de modificación")
        class OperacionesModificacion {

            @Test
            @DisplayName("Establecer el item de un LinkedNode")
            public void setItem_Test() {
                Integer item = 10;
                LinkedNode<Integer> node = new LinkedNode<>(item, null, null);
                Integer newItem = 20;
                node.setItem(newItem);
                assertEquals(newItem, node.getItem());
            }

            @Test
            @DisplayName("Establecer el nodo anterior de un LinkedNode")
            public void setPrevious_Test() {
                LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
                LinkedNode<Integer> node = new LinkedNode<>(10, previous, null);
                LinkedNode<Integer> newPrevious = new LinkedNode<>(15, null, null);
                node.setPrevious(newPrevious);
                assertEquals(newPrevious, node.getPrevious());
            }

            @Test
            @DisplayName("Establecer el nodo siguiente de un LinkedNode")
            public void setNext_Test() {
                LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
                LinkedNode<Integer> node = new LinkedNode<>(10, null, next);
                LinkedNode<Integer> newNext = new LinkedNode<>(20, null, null);
                node.setNext(newNext);
                assertEquals(newNext, node.getNext());
            }
        }
    }

    @Nested
    @DisplayName("Propiedades de LinkedNode")
    class PropiedadesLinkedNode {

        @Test
        @DisplayName("Es el primer nodo")
        public void isFirstNode_Test() {
            LinkedNode<Integer> node = new LinkedNode<>(10, null, null);
            assertEquals(true, node.isFirstNode());
        }

        @Test
        @DisplayName("No es el primer nodo")
        public void isNotFirstNode_Test() {
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(10, previous, null);
            assertEquals(false, node.isFirstNode());
        }

        @Test
        @DisplayName("Es el ultimo nodo")
        public void isLastNode_Test() {
            LinkedNode<Integer> node = new LinkedNode<>(10, null, null);
            assertEquals(true, node.isLastNode());
        }

        @Test
        @DisplayName("No es el ultimo nodo")
        public void isNotLastNode_Test() {
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(10, null, next);
            assertEquals(false, node.isLastNode());
        }

        @Nested
        @DisplayName("Nodo terminal")
        class NodoTerminal {
            @Test
            @DisplayName("No es un nodo terminal")
            public void isNotATerminalNode_Test() {
                LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
                LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
                LinkedNode<Integer> node = new LinkedNode<>(10, previous, next);
                assertEquals(true, node.isNotATerminalNode());
            }

            @Test
            @DisplayName("Si el nodo es unico es terminal")
            public void isATerminalNode_SoloUnNodo_Test() {
                LinkedNode<Integer> node = new LinkedNode<>(10, null, null);
                assertEquals(false, node.isNotATerminalNode());
            }

            @Test
            @DisplayName("El ultimo nodo es terminal")
            public void isATerminalNode_UltimoNodo_Test() {
                LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
                LinkedNode<Integer> node = new LinkedNode<>(10, previous, null);
                assertEquals(false, node.isNotATerminalNode());
            }

            @Test
            @DisplayName("El primer nodo es terminal")
            public void isATerminalNode_PrimerNodo_Test() {
                LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
                LinkedNode<Integer> node = new LinkedNode<>(10, null, next);
                assertEquals(false, node.isNotATerminalNode());
            }
        }
    }
}