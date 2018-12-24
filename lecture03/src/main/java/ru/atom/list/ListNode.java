package ru.atom.list;

import java.awt.*;
import java.util.ArrayList;

/**
 * Contains ref to next node, prev node and value
 */
public class ListNode<E> {
    E item;
    ListNode<E> prev;
    ListNode<E> next;


    public ListNode(E item, ListNode<E> prev, ListNode<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }
}
