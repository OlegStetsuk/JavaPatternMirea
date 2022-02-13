package Task03;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ListLock<E> implements List<E>{
    private List<E> list = new ArrayList<E>();
    public final Lock lock = new ReentrantLock();

    @Override
    public boolean add(E e) {
        try{
            lock.lock();
            return list.add(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void add(int index, E e) {
        try{
            lock.lock();
            list.add(index, e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E get(int e) {
        try{
            lock.lock();
            return list.get(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E set(int index, E e) {
        try{
            lock.lock();
            return list.set(index, e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try{
            lock.lock();
            return list.addAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try{
            lock.lock();
            return list.addAll(index, c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        try{
            lock.lock();
            list.clear();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean contains(Object o) {
        try{
            lock.lock();
            return list.contains(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int indexOf(Object o) {
        try{
            lock.lock();
            return list.indexOf(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try{
            lock.lock();
            return list.lastIndexOf(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try{
            lock.lock();
            return list.containsAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object obj) {
        try{
            lock.lock();
            return list.equals(obj);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int hashCode() {
        try{
            lock.lock();
            return list.hashCode();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            lock.lock();
            return list.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator<E> iterator() {
        try{
            lock.lock();
            return list.iterator();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        try{
            lock.lock();
            return list.listIterator();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        try{
            lock.lock();
            return list.listIterator(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<E> subList(int index1, int index2) {
        try{
            lock.lock();
            return list.subList(index1, index2);
        } finally {
            lock.unlock();
        }
    }


    @Override
    public boolean remove(Object o) {
        try{
            lock.lock();
            return list.remove(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E remove(int index) {
        try{
            lock.lock();
            return list.remove(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try{
            lock.lock();
            return list.removeAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try{
            lock.lock();
            return list.retainAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        try{
            lock.lock();
            return list.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object[] toArray() {
        try{
            lock.lock();
            return list.toArray();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        try{
            lock.lock();
            return list.toArray(a);
        } finally {
            lock.unlock();
        }
    }
}
