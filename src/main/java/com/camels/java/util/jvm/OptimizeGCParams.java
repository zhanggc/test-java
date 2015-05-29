package com.camels.java.util.jvm;

/**
 * @Todo 优化GC相关参数
 * @Document http://www.oracle.com/technetwork/java/javase/tech/vmoptions-jsp-140102.html
 * @Options
 * -XX:MinHeapFreeRatio 设置堆空间最小空闲比列
 * -XX:MaxHeapFreeRatio 设置堆空间最大空闲比列
 * -XX:MaxTenuringThreshold 设置对象进入老年代年龄
 * -XX:PretenureSizeThreshold 设置大对象进入老年代
 * -XX:NewSize 设置新生代初始大小
 * -XX:MaxNewSize 设置新生代最大值
 * -Xmn 设置NewSize与MaxNewSize 值（注：将值设置大点，有利于新对象预留在新生代）
 * -XX:LargePageSizeInBytes 设置大页的大小(增强CPU寻址能力)
 * -XX:LargePageSizeInBytes 设置大页的大小
 * -XX:TargetSurvivorRatio 设置survivor区的可使用率
 * -XX:CompileThreshold 设置JIT编译阈值
 * -XX:+CITime 打印JIT编译基本信息
 * -XX:OnOutOfMemoryError Run user-defined commands when an OutOfMemoryError is first thrown. (Introduced in 1.4.2 update 12, 6)
 * -XX:+HeapDumpOnOutOfMemoryError Dump heap to file when java.lang.OutOfMemoryError is thrown. Manageable. (Introduced in 1.4.2 update 12, 5.0 update 7.)
 * -XX:HeapDumpPath 指定堆快照保存位置
 * -XX:SurvivorRatio 设置eden/s0或eden/s1 比例
 * -XX:NewRatio old/young
 * -verbose:gc 显示GC信息
 * -XX:+PrintGC Print messages at garbage collection. Manageable.
 * -XX:+PrintGCDetails Print more details at garbage collection. Manageable. (Introduced in 1.4.0.)
 * -XX:+PrintGCTimeStamps Print timestamps(tips:以JVM启动时间为基准的相对时间) at garbage collection. Manageable (Introduced in 1.4.0.)
 * -XX:+PrintGCDateStamps Print date(tips:以系统时间为准) at garbage collection.
 * -XX:+PrintGCApplicationStoppedTime 显示GC造成的应用暂停的时间
 * -XX:+DisableExplicitGC 禁止System.gc()
 * -Xverify:none 禁止类校验
 * -XX:PermSize 设置方法区初始值
 * -XX:ParallelGCThreads 新生代线程数量（CPU<8, -XX:ParallelGCThreads=CPU;CPU>8， -XX:ParallelGCThreads=3+[(5*CPU)/8]）
 * -XX:CMSInitiatingOccupancyFraction 设置Full GC触发的阈值
 * -XX:+UseCMSInitiatingOccupancyOnly 标志来命令JVM不基于运行时收集的数据来启动CMS垃圾收集周期
 * -Xnoclassgc 禁用类元数据回收
 * -Xgcpolicy:[optthruput | optavgpause | gencon | subpool] 设置 GC 的策略
 *      -Xgcpolicy:optthruput , 针对吞吐量优化，这是虚拟机默认的 GC 策略，适用于两种极端情况：应用需要尽可能快的在短时间内运行结束，或应用长时间运行，且运行过程中的吞吐量没有比较固定的大小和分布;
 *      -Xgcpolicy:optavgpause ，针对 GC 导致的停顿优化，通过并发地执行一部分垃圾收集，在高吞吐量和短 GC 停顿之间进行折中。应用程序停顿的时间更短。适用于应用具有比较规则和突发的吞吐量周期分布;
 *      -Xgcpolicy:gencon ，分代并发进行 GC，以不同方式处理短期存活的对象和长期存活的对象。采用这种策略时，具有许多短期存活对象的应用程序会表现出更短的停顿时间，同时仍然产生很好的吞吐量；
 *      -Xgcpolicy:subpool ，子池优化，采用与默认策略相似的算法，但是采用一种比较适合多处理器计算机的分配策略。适用于在多核环境下运行的具有较高对象创建速率的多线程应用;
 * -XX:+UseCMSCompactAtFullCollection 设置CMS收集垃圾完成后，进行一次内存碎片整理（串行进行）
 * -XX:CMSFullGCsBeforeCompation 设置进行多少次CMS垃圾回收后，进行一次内存压缩
 * -XX:MaxGCPauseMillis 设置最大垃圾收集停顿时间（会导致增加垃圾回收频率，从而增加垃圾回收总时间，降低吞吐量）
 * -XX:GCTimeRatio 设置吞吐量大小（0-100），假设GCTimeRatio=n,那么系统将花费不超过1/(1+n)的时间用于垃圾收集
 * -XX:+UseAdaptiveSizePolicy 设置自适应GC策略
 * -XX:+CMSScavengeBeforeRemark 设置CMS执行垃圾回收时，进行remark 过程前，先进行Minor GC （作用：这能减少remark过程时间）；
 * -XX:+UseThreadPriorities 启用本地线程优先级API。即使 java.lang.Thread.setPriority() 生效，不启用则无效。
 * -XX:SoftRefLRUPolicyMSPerMB=0：软引用对象在最后一次被访问后能存活0毫秒（JVM默认为1000毫秒）
 * -XX:-PrintGCTimeStamps Print timestamps at garbage collection. Manageable (Introduced in 1.4.0.)
 * -XX:CMSFullGCsBeforeCompaction 由于并发收集器不对内存空间进行压缩、整理，所以运行一段时间以后会产生“碎片”，使得运行效率降低。此值设置运行多少次GC以后对内存空间进行压缩、整理
 * -XX：CMSParallelRemarkEnabled  在使用 UseParNewGC 的情况下，尽量减少 mark 的时间
 * -XX:+UseFastAccessorMethods Use optimized versions of Get<Primitive>Field.(get,set 方法转成本地代码)
 * -XX:+CompressOops 指针压缩，在64位HotSpot中使用32位指针，默认64位会比32位的内存使用多出1.5倍，启用CompressOops后，会压缩的对象
 * -XX:+ReduceInitialCardMarks 避免java 6 中CMS的一个bug,导致jvm crash。 该bug在Java6 update25中得到修复
 * -XX:InitialCodeCacheSize 用来存储已编译方法生成的本地代码
 * -XX:ReservedCodeCacheSize 用来存储已编译方法生成的本地代码
 * -XX:+UseCodeCacheFlushing 如果本地代码缓存已满，自动清除存储已编译方法生成的本地代码
 * -XX:+UnlockExperimentalVMOptions
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+LogCompilation
 * -XX:+PrintOptoAssembly
 * -XX:+PrintCompilation
 * Created by zhanggc on 2014/11/25.
 */
public class OptimizeGCParams {
    public static void main(String[] args){}
}
