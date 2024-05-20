package br.edu.fatec.sjc;

import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.when;

import java.util.Arrays;
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

    Integer i;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @BeforeEach
    public void setUp() {
        numberAscOrder = new NumberAscOrder(customStack);
        i = 0;
    }

    @Test
    public void testSortWithSixRandomNumbers() throws StackEmptyException, StackFullException {

        Double[] randomNumbers = {5.5, 2.2, 6.6, 4.4, 1.1, 3.3};
        Double[] sortedNumbers = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        List<Double> sortedList = Arrays.asList(sortedNumbers);

        // Mock comportamento da pilha
        when(customStack.size()).thenReturn(6);
        when(customStack.pop()).thenAnswer(invocations -> {
            return randomNumbers[i++];
        });

        // Executa o método sort e verifica o resultado
        Assertions.assertEquals(sortedList, numberAscOrder.sort());
    }

    @Test
    public void testSortWithEmptyList() throws StackEmptyException, StackFullException {

        // Mock do compartamento de uma pilha vazia
        when(customStack.isEmpty()).thenReturn(true);

        // Verifica se uma exceção é lançada ao tentar utilizar o método sort com uma lista vazia
        Assertions.assertThrows(StackEmptyException.class, numberAscOrder::sort);

    }

}
