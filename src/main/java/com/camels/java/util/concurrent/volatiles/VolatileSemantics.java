package com.camels.java.util.concurrent.volatiles;

/**
 * @Todo {@code volatile} 基本语义
 * @Semantics
 * 1) 对volatile变量读、写，就是直接对主存的变量读、写；
 * 2) 32位系统下，保证对long\double 的读、写 是原子操作
 * 3) 针对volatile变量重排规则；（注：Java SE 5 之后，包括Java SE 5）
 *       ----------------------------------------------------------------------
 *      | Can ReOrder    |                     2nd Opertation                 |
 *       ----------------------------------------------------------------------
 *      | 1st Operation  | Normal Load   | Volatile Load  | Volatile Store    |
 *      |                | Normal Store  | MonitorEnter   | MonitorExit       |
 *      -----------------------------------------------------------------------
 *      | Normal Load   |       Yes     |      Yes        |        No         |
 *      | Normal Store  |               |                 |                   |
 *      -----------------------------------------------------------------------
 *      | Volatile Load |       No       |     No         |      No           |
 *      | MonitorEnter  |                |                |                   |
 *      -----------------------------------------------------------------------
 *      | Volatile Store|     Yes       |       No       |      No            |
 *      | MonitorExit   |               |                |                    |
 *      -----------------------------------------------------------------------
 *  4) happen-before volatile rule
 *      • A write to a volatile field (§8.3.1.4) happens-before every subsequent read of that field.
 *
 * Created by zhanggc on 2014/12/4.
 */
public class VolatileSemantics {
}
