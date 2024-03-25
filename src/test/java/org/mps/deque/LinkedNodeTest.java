package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class LinkedNodeTest {
    
    @Test
    void setItem_Set_Item_Correctly(){
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, null);

        node.setItem(2);
        int value = node.getItem();

        assertEquals(2, value);
    }

    @Test
    void isFirstNode_AskIfNodeIsFirst_ReturnTrue(){
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, null);

        boolean result = node.isFirstNode();

        assertTrue(result);
    }

    @Test
    void isFirstNode_AskIfNodeIsFirst_ReturnFalse(){
        LinkedNode<Integer> previous = new LinkedNode<Integer>(2, null, null);
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, previous, null);

        boolean result = node.isFirstNode();

        assertFalse(result);
    }

    @Test
    void isLastNode_AskIfNodeIsLast_ReturnTrue(){
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, null);

        boolean result = node.isLastNode();

        assertTrue(result);
    }

    @Test
    void isLastNode_AskIfNodeIsFirst_ReturnFalse(){
        LinkedNode<Integer> next = new LinkedNode<Integer>(4, null, null);
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, next);

        boolean result = node.isLastNode();

        assertFalse(result);
    }

    @Test
    void isNotATerminatNode_AskIfNodeIsNotATerminalNodeWithNext_ReturnFalse(){
        LinkedNode<Integer> next = new LinkedNode<Integer>(4, null, null);
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, null, next);

        boolean result = node.isNotATerminalNode();

        assertFalse(result);
    }

    @Test
    void isNotATerminatNode_AskIfNodeIsNotATerminalNodeWithPrevious_ReturnFalse(){
        LinkedNode<Integer> previous = new LinkedNode<Integer>(2, null, null);
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, previous, null);

        boolean result = node.isNotATerminalNode();

        assertFalse(result);
    }

    @Test
    void isNotATerminatNode_AskIfNodeIsNotATerminalNode_ReturnTrue(){
        LinkedNode<Integer> previous = new LinkedNode<Integer>(2, null, null);
        LinkedNode<Integer> next = new LinkedNode<Integer>(4, null, null);
        LinkedNode<Integer> node = new LinkedNode<Integer>(3, previous, next);

        boolean result = node.isNotATerminalNode();

        assertTrue(result);
    }
    
}
