package com.camels.java.util.concurrent;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Todo 极限分离并发Map
 * @Define 将锁段减少到单一实体操作
 * @Think
 * -----------------
 * 1) remove i: 标识indexs[i] = {@link java.lang.Integer#MAX_VALUE} (MAX_VALUE: )
 * -----------------
 * Created by zhanggc on 2014/11/11.
 */
public class ConcurrentGeekMap <K, V> extends AbstractMap<K, V>
        implements ConcurrentMap<K, V>, Serializable {

       /* ---------------- Constants -------------- */

    /**
     * The default initial capacity for this table,
     * used when not otherwise specified in a constructor.
     */
    int INITIAL_CAPACITY = 16;

    /**
     * The default load factor for this table, used when not
     * otherwise specified in a constructor.
     */
    float LOAD_FACTOR = 0.75f;

    /**
     * The maximum capacity, used if a higher value is implicitly
     * specified by either of the constructors with arguments.  MUST
     * be a power of two <= 1<<30 to ensure that entries are indexable
     * using ints.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    //最大hash code value = 2147483647
    static final int MAXIMUM_HASHCODE;

    //空位置标识 value = 2147483648
    static final long EMPTY_POSITION;

    //位置指针
    int cusor = 0;

    /**
     * The table is rehashed when its size exceeds this threshold.
     * (The value of this field is always <tt>(int)(capacity *
     * loadFactor)</tt>.)
     */
    transient int threshold;

    /**
     * The segments, each of which is a specialized hash table
     */
    Segment<K,V>[] segments;

    //索引位置记录
    long[] indexs;

    //初始化
    static{
        final long TEMP;
        TEMP = (1 << 30);
        MAXIMUM_HASHCODE = (int)((TEMP << 1)-1) ;
        EMPTY_POSITION = TEMP << 1;

    }

    /**
     * Creates a new, empty map with a default initial capacity (16),
     * load factor (0.75) and concurrencyLevel (16).
     */
    public ConcurrentGeekMap() {
        this(16, 0.75f);
    }

    /**
     * Creates a new, empty map with the specified initial
     * capacity, load factor and concurrency level.
     *
     * @param initialCapacity the initial capacity. The implementation
     * performs internal sizing to accommodate this many elements.
     * @param loadFactor  the load factor threshold, used to control resizing.
     * Resizing may be performed when the average number of elements per
     * bin exceeds this threshold.
     * @throws IllegalArgumentException if the initial capacity is
     * negative or the load factor or concurrencyLevel are
     * nonpositive.
     */
    public ConcurrentGeekMap(int initialCapacity,
                             float loadFactor) {
        INITIAL_CAPACITY = initialCapacity;
        LOAD_FACTOR = loadFactor;
        if (!(loadFactor > 0) || initialCapacity < 0 )
            throw new IllegalArgumentException();

        this.segments = Segment.newArray(initialCapacity);

        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        for (int i = 0; i < this.segments.length; ++i)
            this.segments[i] = new Segment<K,V>(1, loadFactor);

        threshold = (int)(loadFactor*initialCapacity);

        indexs = new long[initialCapacity];
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public V put(K key, V value){
        Integer aimIndex = null;
        Integer emptyPosition = null;
        int hashcode = key.hashCode();
        for(int i=-1;++i<INITIAL_CAPACITY;){
            if(indexs[i] == hashcode)
                aimIndex = i;
        }
        if(null==aimIndex){
            indexs[++cusor] = hashcode;
            if(cusor>=threshold){
                INITIAL_CAPACITY*=2;
                threshold = (int)(INITIAL_CAPACITY*LOAD_FACTOR);
                long[] expendIndex = new long[INITIAL_CAPACITY];
                System.arraycopy(indexs,0,expendIndex,0,cusor+1);
                indexs = expendIndex;
                Segment[] expendSegment = Segment.newArray(INITIAL_CAPACITY);
                System.arraycopy(segments,0,expendSegment,0,cusor-1);
                segments = expendSegment;
            }
            return segments[cusor].put(key,hashcode,value,false);
        }else{
            return segments[aimIndex].put(key,hashcode,value,false);
        }
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    /**
     * ConcurrentHashMap list entry. Note that this is never exported
     * out as a user-visible Map.Entry.
     *
     * Because the value field is volatile, not final, it is legal wrt
     * the Java Memory Model for an unsynchronized reader to see null
     * instead of initial value when read via a data race.  Although a
     * reordering leading to this is not likely to ever actually
     * occur, the Segment.readValueUnderLock method is used as a
     * backup in case a null (pre-initialized) value is ever seen in
     * an unsynchronized access method.
     */
    static final class HashEntry<K,V> {
        final K key;
        final int hash;
        volatile V value;

        HashEntry(K key, int hash,V value) {
            this.key = key;
            this.hash = hash;
            this.value = value;
        }

        @SuppressWarnings("unchecked")
        static final <K,V> HashEntry<K,V>[] newArray(int i) {
            return new HashEntry[i];
        }
    }

    /**
     * Segments are specialized versions of hash tables.  This
     * subclasses from ReentrantLock opportunistically, just to
     * simplify some locking and avoid separate construction.
     */
    static final class Segment<K,V> extends ReentrantLock implements Serializable {
        /*
         * Segments maintain a table of entry lists that are ALWAYS
         * kept in a consistent state, so can be read without locking.
         * Next fields of nodes are immutable (final).  All list
         * additions are performed at the front of each bin. This
         * makes it easy to check changes, and also fast to traverse.
         * When nodes would otherwise be changed, new nodes are
         * created to replace them. This works well for hash tables
         * since the bin lists tend to be short. (The average length
         * is less than two for the default load factor threshold.)
         *
         * Read operations can thus proceed without locking, but rely
         * on selected uses of volatiles to ensure that completed
         * write operations performed by other threads are
         * noticed. For most purposes, the "count" field, tracking the
         * number of elements, serves as that volatile variable
         * ensuring visibility.  This is convenient because this field
         * needs to be read in many read operations anyway:
         *
         *   - All (unsynchronized) read operations must first read the
         *     "count" field, and should not look at table entries if
         *     it is 0.
         *
         *   - All (synchronized) write operations should write to
         *     the "count" field after structurally changing any bin.
         *     The operations must not take any action that could even
         *     momentarily cause a concurrent read operation to see
         *     inconsistent data. This is made easier by the nature of
         *     the read operations in Map. For example, no operation
         *     can reveal that the table has grown but the threshold
         *     has not yet been updated, so there are no atomicity
         *     requirements for this with respect to reads.
         *
         * As a guide, all critical volatile reads and writes to the
         * count field are marked in code comments.
         */

        private static final long serialVersionUID = 2249069246763182397L;

        /**
         * The number of elements in this segment's region.
         */
        transient volatile int count;

        /**
         * Number of updates that alter the size of the table. This is
         * used during bulk-read methods to make sure they see a
         * consistent snapshot: If modCounts change during a traversal
         * of segments computing size or checking containsValue, then
         * we might have an inconsistent view of state so (usually)
         * must retry.
         */
        transient int modCount;

        /**
         * The table is rehashed when its size exceeds this threshold.
         * (The value of this field is always <tt>(int)(capacity *
         * loadFactor)</tt>.)
         */
        transient int threshold;

        /**
         * The per-segment table.
         */
        transient volatile HashEntry<K,V>[] table;

        /**
         * The load factor for the hash table.  Even though this value
         * is same for all segments, it is replicated to avoid needing
         * links to outer object.
         * @serial
         */
        final float loadFactor;

        Segment(int initialCapacity, float lf) {
            loadFactor = lf;
            setTable(HashEntry.<K,V>newArray(initialCapacity));
        }

        @SuppressWarnings("unchecked")
        static final <K,V> Segment<K,V>[] newArray(int i) {
            return new Segment[i];
        }

        /**
         * Sets table to new HashEntry array.
         * Call only while holding lock or in constructor.
         */
        void setTable(HashEntry<K,V>[] newTable) {
            threshold = (int)(newTable.length * loadFactor);
            table = newTable;
        }

        /**
         * Returns properly casted first entry of bin for given hash.
         */
        HashEntry<K,V> getFirst(int hash) {
            HashEntry<K,V>[] tab = table;
            return tab[hash & (tab.length - 1)];
        }

        /**
         * Reads value field of an entry under lock. Called if value
         * field ever appears to be null. This is possible only if a
         * compiler happens to reorder a HashEntry initialization with
         * its table assignment, which is legal under memory model
         * but is not known to ever occur.
         */
        V readValueUnderLock(HashEntry<K,V> e) {
            lock();
            try {
                return e.value;
            } finally {
                unlock();
            }
        }

        V put(K key, int hash, V value, boolean onlyIfAbsent) {
            lock();
            try {
                HashEntry<K,V>[] tab = table;
                HashEntry<K,V> first = tab[0];
                HashEntry<K,V> e = first;
                V oldValue;
                if (e != null) {
                    oldValue = e.value;
                    if (!onlyIfAbsent)
                        e.value = value;
                }
                else {
                    oldValue = null;
                    ++modCount;
                    tab[0] = new HashEntry<K,V>(key, hash, value);
                }
                return oldValue;
            } finally {
                unlock();
            }
        }

        void clear() {
            if (count != 0) {
                lock();
                try {
                    HashEntry<K,V>[] tab = table;
                    for (int i = 0; i < tab.length ; i++)
                        tab[i] = null;
                    ++modCount;
                    count = 0; // write-volatile
                } finally {
                    unlock();
                }
            }
        }
    }


}
