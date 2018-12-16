# Concurrent

### 测试工具
1. Postman： http请求
2. Apache Bench：测试性能
3. Jmeter：压力测试
4. 代码 Semaphore，CountDownLatch

### 原子性
- Atomic包 
- CAS算法 Unsafe.compareAndSwapInt() 
- Synconized 不可中断锁
- Lock 可中断锁

### 可见性
- Synconized
- volatile 内存屏障 禁止重排序优化 写操作现行发生于后面的读

### 有序性
happens-before原则

### 安全发布对象
