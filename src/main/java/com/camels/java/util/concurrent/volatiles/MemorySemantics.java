package com.camels.java.util.concurrent.volatiles;

/**
 * @todo java memory model 基本语义
 * @synchronized
 *      1) 保证同步块内变量可见
 *      2) 保证线程间同步块执行有序
 * @volatile
 *      1) 保证共享变量在线程间可见
 *      2) 保证局部字节码指令有序
 * @happen-before
 *  happen-before 描述在内存模型下变量可见性规则，只要遵守happen-before 规则则能保证其可见性，这是对缓存、重排一种抽象概括描述;
 *  旨在帮助开发人员更容易编写出安全的并发程序;以下是happen-before部分规则（参见：jsl3-17.4 Memory Model-17.4.5 Happens-before Order）：
 *      • An unlock on a monitor happens-before every subsequent lock on that monitor
 *      .
 *      • A write to a volatile field (§8.3.1.4) happens-before every subsequent read of that field.
 *
 *      • A call to start()on a thread happens-before any actions in the started thread.
 *
 *      • All actions in a thread happen-before any other thread successfully returns from a
 *       join()on that thread.
 *
 *      • The default initialization of any object happens-before any other actions (other than
 *      default-writes) of a program
 *
 *      • If x and y are actions of the same thread and x comes before yin program
 *        order, then hb(x, y).
 *
 *      • There is a happens-before edge from the end of a constructor of an object to
 *      the start of a finalizer (§12.6) for that object.
 *
 *      • If an action x synchronizes-with a following action y, then we also have hb(x,
 *       y).
 *
 *      • If hb(x, y) and hb(y, z),then hb(x, z).
 *
 *
 *
 * created by zhanggc on 2014/12/6.
 */
public class MemorySemantics {
}
