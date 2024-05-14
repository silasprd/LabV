package br.edu.fatec.sjc;

import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @SuppressWarnings("rawtypes")
    @Mock
    private NumberAscOrder numberAscOrder;
    @Mock
    private CustomStack<Double> customStack;
    @Mock
    private CalculableStrategy<Double> calculableStrategy;

    Integer i;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @BeforeEach
    public void setUp() {
        numberAscOrder = new NumberAscOrder(customStack);
        i = 0;
    }

    @Test
    public void testSortWithSixRandomNumbers() throws StackEmptyException, StackFullException {

        // Cria uma lista com 6 números aleatórios
        List<Double> randomList = new ArrayList<>(Arrays.asList(0.7, 0.3, 0.9, 0.1, 0.5, 0.2));

        // Lista ordenada para comparação
        List<Double> sortedList = new ArrayList<Double>(randomList);
        Collections.sort(sortedList);

        // Mock do comportamento da pilha
        when(customStack.size()).thenReturn(6);
        when(customStack.isEmpty()).thenReturn(false);
        when(customStack.pop()).thenAnswer(invocation -> {
            if (i < randomList.size()) {
                return randomList.get(i++);
            } else {
                throw new StackEmptyException();
            }
        });

        // Verifica se a lista retornada está ordenada corretamente
        Assertions.assertEquals(sortedList, numberAscOrder.sort());
    }

    @Test
    public void testSortWithEmptyList() throws StackEmptyException, StackFullException {

        // Mock do compartamento de uma pilha vazia
        when(customStack.isEmpty()).thenReturn(true);

        // Verifica se uma exceção é lançada ao tentar utilizar o método sort com uma
        // lista vazia
        Assertions.assertThrows(StackEmptyException.class, numberAscOrder::sort);

    }

}
