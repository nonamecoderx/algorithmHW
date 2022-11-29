package com.example.algorithm;

import com.example.algorithm.exceptions.IncorrectIndexException;
import com.example.algorithm.exceptions.IncorrectItemException;
import com.example.algorithm.exceptions.IncorrectSizeException;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList implements StringList {
    private String[] array;
    private int size;

    public ArrayList() {
    }


    public void StringList() {
        array = new String[10];
    }

    public void StringList(int storage) {
        array = new String[storage];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;

    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        array[size++] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateSize();
        validateIndex(index);
        if (index == size) {
            array[size++] = item;
            return item;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        validateIndex(index);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = array[index];
        validateItem(item);
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (indexOf(item) == -1) {
            return false;
        }
        return true;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Передан пустой список");
        }
        if (Arrays.equals(array, otherList.toArray())) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public void validateSize() {
        if (size >= array.length) {
            throw new IncorrectSizeException();
        }
    }

    public void validateIndex(int index) {
        if (index < 0 && index > size) {
            throw new IncorrectIndexException();
        }
    }

    public void validateItem(String item) {
        if (item == null) {
            throw new IncorrectItemException();
        }
    }

}