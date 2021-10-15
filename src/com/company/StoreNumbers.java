package com.company;

import java.util.EventObject;

public class StoreNumbers extends EventObject {
    int[] numbers;

    public StoreNumbers(Object source, int[] numbers) {
        super(source);
        this.numbers = numbers;

    }

    public int[] getNumbers() {
        return numbers;
    }
}
