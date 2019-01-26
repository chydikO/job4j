package ru.job4j.array;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] input = {"Liza", "Olga","Liza", "Sveta", "Valeria"};
        String[] except = {"Liza", "Olga","Sveta", "Valeria"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}