package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<E extends Number & Comparable<E>> {

    private CustomStack<E> customStack;
    
    public NumberAscOrder(CustomStack<E> customStack) {
        this.customStack = customStack;
    }
    
    public List<E> sort() throws StackEmptyException, StackFullException {

        List<E> sortedList = new ArrayList<>();
        
        if(customStack.isEmpty()){
            throw new StackEmptyException();
        }

        int stackSize = customStack.size();
        
        // Adicionando elementos da customStack para a lista ordenada
        while (stackSize > 0) {
            sortedList.add(customStack.pop());
            stackSize--;
        }

        Collections.sort(sortedList);

        return sortedList;
    }

}
