package com.thoughtworks.myList;

import java.util.*;

public class MyList<T> implements List<T> {

    private int size = 0;
    private Object[] obj;

    public MyList(){
        obj=new Object[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(obj == null || obj.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0; i<obj.length; i++){
            if(o == obj[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {

        return  Arrays.copyOf(obj, size);
    }

    @Override
    public boolean add(T o) {
        if(o != null){
            size++;
            obj= Arrays.copyOf(obj, size);
            obj[size-1] = o;

            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean remove = false;

        for(int i=0, j=0; i<obj.length; i++){
            if(obj[i] != o){

                obj[j++] = obj[i];
            }else{
                size -= 1;
                remove = true;
            }
        }

        return remove;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        Object[] cArray = c.toArray();
        for(int i=0; i<cArray.length; i++){
            add((T) cArray[i]);
        }
        return cArray.length != 0;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object[] cArray = c.toArray();

        if(cArray.length == 0){
            return false;
        }

        Object[] leftList = Arrays.copyOfRange(obj, index, obj.length);

        obj = Arrays.copyOf(obj, obj.length + cArray.length);
        for(int i=0; i<cArray.length; i++){
            obj[index + i] = cArray[i];
        }

        int currentLength = index + cArray.length -1;
        for(int i=0; i<leftList.length; i++){
            obj[currentLength + i] = leftList[i];
        }

        size += cArray.length;
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        obj = new Object[0];
    }

    @Override
    public T get(int index) {
        return (T) obj[index];
    }

    @Override
    public Object set(int index, Object element) {

        Object previousElement = obj[index];
        obj[index] = element;
        return previousElement;
    }

    @Override
    public void add(int index, Object element) {

        Object[] leftObj = Arrays.copyOfRange(obj, index, obj.length);

        obj = Arrays.copyOf(obj, obj.length+1);
        obj[index] = element;
        for(int i=0; i<leftObj.length; i++){
            obj[index+i+1] = leftObj[i];
        }

        size++;
    }

    @Override
    public T remove(int index) {
        T removeElement = (T) obj[index];
        for(int i =index; i<obj.length-1; i++){
            obj[i] = obj[i+1];
        }
        size--;
        return removeElement;
    }

    @Override
    public int indexOf(Object o) {
        int index= -1;
        for(int i=0; i<obj.length; i++){
            if(o == obj[i]){
                index = i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;

        for(int i=0; i<obj.length; i++){
            if(o == obj[i]){
                index = i;
            }
        }
        return index;
    }
    @Override
    public List subList(int fromIndex, int toIndex) {

        Object[] subArray = Arrays.copyOfRange(obj, fromIndex, toIndex+1);
        return Arrays.asList(subArray);
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public T[] toArray(Object[] a) {
        return  null;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator<>(obj);
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }
}

