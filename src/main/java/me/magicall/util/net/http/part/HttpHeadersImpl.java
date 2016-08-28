package me.magicall.util.net.http.part;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

/**
 * @author Liang Wenjian
 */
public class HttpHeadersImpl implements HttpHeaders {

    private final List<HttpHeader<?>> list;

    public HttpHeadersImpl(final List<HttpHeader<?>> list) {
        this.list = list;
    }

    public HttpHeadersImpl() {
        //ArrayList默认长度16应该满足大多数情况了。
        this(Lists.newArrayList());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<HttpHeader<?>> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(final HttpHeader<?> e) {
        return list.add(e);
    }

    @Override
    public boolean remove(final Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends HttpHeader<?>> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends HttpHeader<?>> c) {
        return list.addAll(index, c);
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void replaceAll(final UnaryOperator<HttpHeader<?>> operator) {
        list.replaceAll(operator);
    }

    @Override
    public void sort(final Comparator<? super HttpHeader<?>> c) {
        list.sort(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public HttpHeader<?> get(final int index) {
        return list.get(index);
    }

    @Override
    public HttpHeader<?> set(final int index, final HttpHeader<?> element) {
        return list.set(index, element);
    }

    @Override
    public void add(final int index, final HttpHeader<?> element) {
        list.add(index, element);
    }

    @Override
    public HttpHeader<?> remove(final int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(final Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(final Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<HttpHeader<?>> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<HttpHeader<?>> listIterator(final int index) {
        return list.listIterator(index);
    }

    @Override
    public List<HttpHeader<?>> subList(final int fromIndex, final int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<HttpHeader<?>> spliterator() {
        return list.spliterator();
    }

    @Override
    public boolean removeIf(final Predicate<? super HttpHeader<?>> filter) {
        return list.removeIf(filter);
    }

    @Override
    public Stream<HttpHeader<?>> stream() {
        return list.stream();
    }

    @Override
    public Stream<HttpHeader<?>> parallelStream() {
        return list.parallelStream();
    }

    @Override
    public void forEach(final Consumer<? super HttpHeader<?>> action) {
        list.forEach(action);
    }

    @Override
    public String toString() {
        return asString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HttpHeaders)) {
            return false;
        }
        final HttpHeaders that = (HttpHeaders) o;
        return Objects.equals(asString(), that.asString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
