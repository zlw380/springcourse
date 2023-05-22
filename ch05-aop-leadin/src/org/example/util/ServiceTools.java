package org.example.util;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("non service method"+ new Date());
    }

    public static void doTrans(){
        System.out.println("commit transaction");
    }
}
