package com.company;


public interface Storage {
     long getStorageCapacity();

     default void getStorageCapacityMbKbB(){
         System.out.println("storageCapacity in Megabytes :" +getStorageCapacity()*1024+
                            "\n storageCapacity in Kilobytes :" +getStorageCapacity()*1024*1024+
                            "\n storageCapacity in bytes :" + getStorageCapacity()*1024*1024*1024);
     }

}
