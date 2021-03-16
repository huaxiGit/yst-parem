package com.huaxi.customzhujie;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)   //  注解将被编译器记录在class文件中，而且在运行时会被虚拟机保留，因此它们能通过反射被读取到）
public @interface MyTarget  {
   // RetentionPolicy value();
    String name();
}

