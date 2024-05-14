package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<E extends Number & Comparable<E>> {

    private CustomStack<E> customStack;
    private List<E> sortedList = new ArrayList<>();

    public NumberAscOrder(){
        
    }

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

        // Adicionando elementos da pilha na lista
        for (int i = 0; i < customStack.size(); i++){
            E value = customStack.pop();
            sortedList.add(value);
        }

        Collections.sort(sortedList);

        return sortedList;
    }

}
