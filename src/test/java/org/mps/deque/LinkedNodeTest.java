/*
 * @autor1 = Eduardo García Rivas
 * @autor2 = María Victoria Huesca Peláez
 */

package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;

public class LinkedNodeTest {
    
    @DisplayName("Prueba que modifica el atributo item correctamente")
    @Test
    void setItem_Set_Item_Correctly(){
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, null);

        node.setItem(2);
        int value = node.getItem();

        assertEquals(2, value);
    }

    @Nested
    @DisplayName("Clase con pruebas que pregunta si es firstNode o lastNode")
    public class TestAskIfFirstOrLast {
        @DisplayName("Prueba que el nodo es el primero devolviendo true")
        @Test
        void isFirstNode_AskIfNodeIsFirst_ReturnTrue(){
            LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, null);

            boolean result = node.isFirstNode();

            assertTrue(result);
        }

        @DisplayName("Prueba que el nodo no es el primero devolviendo false")
        @Test
        void isFirstNode_AskIfNodeIsFirst_ReturnFalse(){
            LinkedNode<Integer> previous = new LinkedNode<Integer>(2, null, null);
            LinkedNode<Integer> node = new LinkedNode<Integer>(3, previous, null);

            boolean result = node.isFirstNode();

            assertFalse(result);
        }

        @DisplayName("Prueba que el nodo es el ultimo devolviendo true")
        @Test
        void isLastNode_AskIfNodeIsLast_ReturnTrue(){
            LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, null);

            boolean result = node.isLastNode();

            assertTrue(result);
        }

        @DisplayName("Prueba que el nodo no es el ultimo devolviendo false")
        @Test
        void isLastNode_AskIfNodeIsFirst_ReturnFalse(){
            LinkedNode<Integer> next = new LinkedNode<Integer>(4, null, null);
            LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, next);

            boolean result = node.isLastNode();

            assertFalse(result);
        }
        
    }
    
    @Nested
    @DisplayName("Clase con pruebas para el metodo isNotATerminalNode")
    public class TestIsNotATermianlNode {
        @DisplayName("Prueba que el nodo no es un no terminal cuando tiene un next devolviendo false")
        @Test
        void isNotATerminatNode_AskIfNodeIsNotATerminalNodeWithNext_ReturnFalse(){
            LinkedNode<Integer> next = new LinkedNode<Integer>(4, null, null);
            LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, next);

            boolean result = node.isNotATerminalNode();

            assertFalse(result);
        }

        @DisplayName("Prueba que el nodo no es un no terminal cuando tiene un previous devolviendo false")
        @Test
        void isNotATerminatNode_AskIfNodeIsNotATerminalNodeWithPrevious_ReturnFalse(){
            LinkedNode<Integer> previous = new LinkedNode<Integer>(2, null, null);
            LinkedNode<Integer> node = new LinkedNode<Integer>(3, previous, null);

            boolean result = node.isNotATerminalNode();

            assertFalse(result);
        }

        @Test@DisplayName("Prueba que el nodo es un no terminal devolviendo true")
        void isNotATerminatNode_AskIfNodeIsNotATerminalNode_ReturnTrue(){
            LinkedNode<Integer> previous = new LinkedNode<Integer>(2, null, null);
            LinkedNode<Integer> next = new LinkedNode<Integer>(4, null, null);
            LinkedNode<Integer> node = new LinkedNode<Integer>(3, previous, next);

            boolean result = node.isNotATerminalNode();

            assertTrue(result);
        }
    }
}
