package br.edu.fatec.sjc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberAscOrder<E extends Number & Comparable<E>> {

    private CustomStack<E> customStack;

    public NumberAscOrder(CustomStack<E> customStack) {
        this.customStack = customStack;
    }

    public List<E> sort() throws StackEmptyException, StackFullException {

         // Verifica se a pilha está vazia
         if (customStack.isEmpty()) {
            throw new StackEmptyException();
        }
        
        // Verifica se a pilha está cheia
        if (customStack.size() > 6) {
            throw new StackFullException();
        }

        List<E> elements = customStack.getElements();
 
        Collections.sort(elements, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return Double.compare(o1.doubleValue(), o2.doubleValue());
            }
        });

        return elements;
    }

}
