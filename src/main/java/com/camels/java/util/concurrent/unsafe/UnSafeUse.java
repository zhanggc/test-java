package com.camels.java.util.concurrent.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @Todo {@link sun.misc.Unsafe} 基本方法使用
 * @Method Created by zhanggc on 2014/12/8.
 * @see http://www.docjar.com/html/api/sun/misc/Unsafe.java.html
 */
public class UnSafeUse {
    int field;
    static int staticField;
    static final Unsafe unsafe = NewUnSafe.getUnsafe();
    static final int[] array = {1, 0};
    static final UnSafeUse resource = new UnSafeUse();

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                park(0l);
                System.out.println("park");
            }
        });thread.start();
        Thread.sleep(2000);
        System.out.println("unpark");
        unpark(thread);
    }

    public static void test(){}
    public  void test1(){}

    //从给定的内存地址获取一个的本地指针
    public static void getAddress() {
        long address = new Random().nextLong();
        long pointer = unsafe.getAddress(address);
        System.out.println(pointer);
    }

    /**
     * Report the size in bytes of a native pointer, as stored via {@link
     * sun.misc.Unsafe#putAddress}.  This value will be either 4 or 8.  Note that the sizes of
     * other primitive types (as stored in native memory blocks) is determined
     * fully by their information content.
     */
    static void addressSize() {
        int addressSize = unsafe.addressSize();
        System.out.println(addressSize);
    }

    /**
     * Report the size in bytes of a native memory page (whatever that is).
     * This value will always be a power of two.
     */
    static void pageSize() {
        int pageSize = unsafe.pageSize();
        System.out.println(pageSize);
    }

    /**
     * Allocate an instance but do not run any constructor.
     * Initializes the class if it has not yet been.
     */
    static void allocateInstance() throws Exception {
        Object obj = unsafe.allocateInstance(UnSafeUse.class);
        System.out.println(obj);
    }

    /**
     * Report the location of a given field in the storage allocation of its
     * class.  Do not expect to perform any sort of arithmetic on this offset;
     * it is just a cookie which is passed to the unsafe heap memory accessors.
     * <p/>
     * <p>Any given field will always have the same offset and base, and no
     * two distinct fields of the same class will ever have the same offset
     * and base.
     * <p/>
     * <p>As of 1.4.1, offsets for fields are represented as long values,
     * although the Sun JVM does not use the most significant 32 bits.
     * However, JVM implementations which store static fields at absolute
     * addresses can use long offsets and null base pointers to express
     * the field locations in a form usable by {@link sun.misc.Unsafe#getInt(Object, long)}.
     * Therefore, code which will be ported to such JVMs on 64-bit platforms
     * must preserve all bits of static field offsets.
     *
     * @see sun.misc.Unsafe#getInt(Object, long)
     */
    static void objectFieldOffset() throws Exception {
        Field field = UnSafeUse.class.getDeclaredField("field");
        long offset = unsafe.objectFieldOffset(field);
        System.out.println(offset);
    }

    /**
     * Report the location of a given static field, in conjunction with {@link
     * sun.misc.Unsafe#staticFieldBase}.
     * <p>Do not expect to perform any sort of arithmetic on this offset;
     * it is just a cookie which is passed to the unsafe heap memory accessors.
     * <p/>
     * <p>Any given field will always have the same offset, and no two distinct
     * fields of the same class will ever have the same offset.
     * <p/>
     * <p>As of 1.4.1, offsets for fields are represented as long values,
     * although the Sun JVM does not use the most significant 32 bits.
     * It is hard to imagine a JVM technology which needs more than
     * a few bits to encode an offset within a non-array object,
     * However, for consistency with other methods in this class,
     * this method reports its result as a long value.
     *
     * @see sun.misc.Unsafe#getInt(Object, long)
     */
    static void staticFieldOffset() throws Exception {
        Field field = UnSafeUse.class.getDeclaredField("staticField");
        long offset = unsafe.staticFieldOffset(field);
        System.out.println(offset);
    }

    /**
     * Report the location of a given static field, in conjunction with {@link
     * sun.misc.Unsafe#staticFieldOffset}.
     * <p>Fetch the base "Object", if any, with which static fields of the
     * given class can be accessed via methods like {@link sun.misc.Unsafe#getInt(Object,
     * long)}.  This value may be null.  This value may refer to an object
     * which is a "cookie", not guaranteed to be a real Object, and it should
     * not be used in any way except as argument to the get and put routines in
     * this class.
     */
    static void staticFieldBase() throws Exception {
        Field field = UnSafeUse.class.getDeclaredField("staticField");
        Object obj = unsafe.staticFieldBase(field);
        System.out.println(obj);
    }

    /**
     * Returns the base address for accessing some static field
     * in the given class.  This method is implemented as follows:
     * <blockquote><pre>
     * public Object staticFieldBase(Class c) {
     *     Field[] fields = c.getDeclaredFields();
     *     for (int i = 0; i < fields.length; i++) {
     *         if (Modifier.isStatic(fields[i].getModifiers())) {
     *             return staticFieldBase(fields[i]);
     *         }
     *     }
     *     return null;
     * }
     * </pre></blockquote>
     *
     * @deprecated As of 1.4.1, use {@link sun.misc.Unsafe#staticFieldBase(Field)}
     * to obtain the base pertaining to a specific {@link Field}.
     * This method works only for JVMs which store all statics
     * for a given class in one place.
     */
    @Deprecated
    static void staticFieldBase(Class cla) {
        Object obj = unsafe.staticFieldBase(UnSafeUse.class);
        System.out.println(obj);
    }


    /**
     * Stores a value into a given Java variable.
     * <p/>
     * The first two parameters are interpreted exactly as with
     * {@link sun.misc.Unsafe#getInt(Object, long)} to refer to a specific
     * Java variable (field or array element).  The given value
     * is stored into that variable.
     * <p/>
     * The variable must be of the same type as the method
     * parameter <code>x</code>.
     *
     * @param o      Java heap object in which the variable resides, if any, else
     *               null
     * @param offset indication of where the variable resides in a Java heap
     *               object, if any, else a memory address locating the variable
     *               statically
     * @param x      the value to store into the indicated Java variable
     * @throws RuntimeException No defined exceptions are thrown, not even
     *                          {@link NullPointerException}
     */
    static void putInt() throws Exception {
        UnSafeUse unSafeUse = new UnSafeUse();
        int newValue = 1;
        Field field = UnSafeUse.class.getDeclaredField("field");
        long offset = unsafe.objectFieldOffset(field);
        unsafe.putInt(unSafeUse, offset, newValue);
        System.out.println(unSafeUse.field);
    }

    /**
     * Tell the VM to define a class, without security checks.  By default, the
     * class loader and protection domain come from the caller's class.
     */
    static void defineClass() {
    }

    /**
     * Define a class but do not make it known to the class loader or system dictionary.
     * <p/>
     * For each CP entry, the corresponding CP patch must either be null or have
     * the a format that matches its tag:
     * <ul>
     * <li>Integer, Long, Float, Double: the corresponding wrapper object type from java.lang
     * <li>Utf8: a string (must have suitable syntax if used as signature or name)
     * <li>Class: any java.lang.Class object
     * <li>String: any object (not just a java.lang.String)
     * <li>InterfaceMethodRef: (NYI) a method handle to invoke on that call site's arguments
     * </ul>
     *
     * @params hostClass context for linkage, access control, protection domain, and class loader
     * @params data      bytes of a class file
     * @params cpPatches where non-null entries exist, they replace corresponding CP entries in data
     */
    static void defineAnonymousClass() {
    }

    /**
     * Ensure the given class has been initialized. This is often
     * needed in conjunction with obtaining the static field base of a
     * class.
     */
    static void ensureClassInitialized() {
    }

    /**
     * Report the offset of the first element in the storage allocation of a
     * given array class.  If {@link sun.misc.Unsafe#arrayIndexScale} returns a non-zero value
     * for the same class, you may use that scale factor, together with this
     * base offset, to form new offsets to access elements of arrays of the
     * given class.
     *
     * @see sun.misc.Unsafe#getInt(Object, long)
     * @see sun.misc.Unsafe#putInt(Object, long, int)
     */
    static void arrayBaseOffset() {
        int offset = unsafe.arrayBaseOffset(array.getClass());
        System.out.println(offset);
    }

    /**
     * Report the scale factor for addressing elements in the storage
     * allocation of a given array class.  However, arrays of "narrow" types
     * will generally not work properly with accessors like {@link
     * sun.misc.Unsafe#getByte(Object, int)}, so the scale factor for such classes is reported
     * as zero.
     *
     * @see sun.misc.Unsafe#arrayBaseOffset
     * @see sun.misc.Unsafe#getInt(Object, long)
     * @see sun.misc.Unsafe#putInt(Object, long, int)
     */
    static void arrayIndexScale() {
        int scale = unsafe.arrayIndexScale(array.getClass());
        System.out.println(scale);
    }

    /**
     * Lock the object.  It must get unlocked via {@link sun.misc.Unsafe#monitorExit}.
     */
    static void monitorEnter() {
        unsafe.monitorEnter(resource);
    }

    /**
     * Unlock the object.  It must have been locked via {@link
     * sun.misc.Unsafe#monitorEnter}.
     */
    static void monitorExit() {
        unsafe.monitorExit(resource);
    }

    /**
     * Tries to lock the object.  Returns true or false to indicate
     * whether the lock succeeded.  If it did, the object must be
     * unlocked via {@link sun.misc.Unsafe#monitorExit}.
     */
    static void tryMonitorEnter() {
        unsafe.tryMonitorEnter(resource);
    }

    /**
     * Atomically update Java variable to <tt>x</tt> if it is currently
     * holding <tt>expected</tt>.
     *
     * @return <tt>true</tt> if successful
     */
    static void compareAndSwapInt() throws Exception {
        Field field = UnSafeUse.class.getDeclaredField("field");
        long offset = unsafe.objectFieldOffset(field);
        int expect = 0;
        int newValue = 1;
        unsafe.compareAndSwapInt(resource, offset, expect, newValue);
        System.out.println(resource.field);
    }

    /**
     * Ordered/Lazy version of {@link sun.misc.Unsafe#putIntVolatile(Object, long, int)}
     */
    static void putOrderedInt() throws Exception {
        Field field = UnSafeUse.class.getDeclaredField("field");
        long offset = unsafe.objectFieldOffset(field);
        int newValue = 1;
        unsafe.putOrderedInt(resource, offset, newValue);
        System.out.println(resource.field);
    }

    /**
     * Volatile version of {@link sun.misc.Unsafe#putInt(Object, long, int)}
     */
    static void putIntVolatile() throws Exception {
        Field field = UnSafeUse.class.getDeclaredField("field");
        long offset = unsafe.objectFieldOffset(field);
        int newValue = 1;
        unsafe.putIntVolatile(resource, offset, newValue);
        System.out.println(resource.field);
    }

    /**
     * Allocates a new block of native memory, of the given size in bytes.  The
     * contents of the memory are uninitialized; they will generally be
     * garbage.  The resulting native pointer will never be zero, and will be
     * aligned for all value types.  Dispose of this memory by calling {@link
     * sun.misc.Unsafe#freeMemory}, or resize it with {@link sun.misc.Unsafe#reallocateMemory}.
     *
     * @throws IllegalArgumentException if the size is negative or too large
     *                                  for the native size_t type
     * @throws OutOfMemoryError         if the allocation is refused by the system
     * @see sun.misc.Unsafe#getByte(long)
     * @see sun.misc.Unsafe#putByte(long, byte)
     */
    static void allocateMemory() {
    }

    /**
     * Resizes a new block of native memory, to the given size in bytes.  The
     * contents of the new block past the size of the old block are
     * uninitialized; they will generally be garbage.  The resulting native
     * pointer will be zero if and only if the requested size is zero.  The
     * resulting native pointer will be aligned for all value types.  Dispose
     * of this memory by calling {@link sun.misc.Unsafe#freeMemory}, or resize it with {@link
     * sun.misc.Unsafe#reallocateMemory}.  The address passed to this method may be null, in
     * which case an allocation will be performed.
     *
     * @throws IllegalArgumentException if the size is negative or too large
     *                                  for the native size_t type
     * @throws OutOfMemoryError         if the allocation is refused by the system
     * @see sun.misc.Unsafe#allocateMemory
     */
    static void reallocateMemory() {
    }

    /**
     * Sets all bytes in a given block of memory to a copy of another
     * block.
     * <p/>
     * <p>This method determines each block's base address by means of two parameters,
     * and so it provides (in effect) a <em>double-register</em> addressing mode,
     * as discussed in {@link sun.misc.Unsafe#getInt(Object, long)}.  When the object reference is null,
     * the offset supplies an absolute base address.
     * <p/>
     * <p>The transfers are in coherent (atomic) units of a size determined
     * by the address and length parameters.  If the effective addresses and
     * length are all even modulo 8, the transfer takes place in 'long' units.
     * If the effective addresses and length are (resp.) even modulo 4 or 2,
     * the transfer takes place in units of 'int' or 'short'.
     *
     * @since 1.7
     */
    static void copyMemory() {
    }

    /**
     * Disposes of a block of native memory, as obtained from {@link
     * sun.misc.Unsafe#allocateMemory} or {@link sun.misc.Unsafe#reallocateMemory}.  The address passed to
     * this method may be null, in which case no action is taken.
     *
     * @see sun.misc.Unsafe#allocateMemory
     */
    static void freeMemory() {
    }

    /**
     * Unblock the given thread blocked on <tt>park</tt>, or, if it is
     * not blocked, cause the subsequent call to <tt>park</tt> not to
     * block.  Note: this operation is "unsafe" solely because the
     * caller must somehow ensure that the thread has not been
     * destroyed. Nothing special is usually required to ensure this
     * when called from Java (in which there will ordinarily be a live
     * reference to the thread) but this is not nearly-automatically
     * so when calling from native code.
     *
     * @param thread the thread to unpark.
     */
    static void unpark(Object obj) {
        unsafe.unpark(obj);
    }

    /**
     * Block current thread, returning when a balancing
     * <tt>unpark</tt> occurs, or a balancing <tt>unpark</tt> has
     * already occurred, or the thread is interrupted, or, if not
     * absolute and time is not zero, the given time nanoseconds have
     * elapsed, or if absolute, the given deadline in milliseconds
     * since Epoch has passed, or spuriously (i.e., returning for no
     * "reason"). Note: This operation is in the Unsafe class only
     * because <tt>unpark</tt> is, so it would be strange to place it
     * elsewhere.
     */
    static void park(long time) {
        unsafe.park(false,time);
    }
}
