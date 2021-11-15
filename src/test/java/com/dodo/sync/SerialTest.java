package com.dodo.sync;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.springframework.boot.autoconfigure.cache.CacheProperties.EhCache;

import com.test.bean.SPartsXm;

public class SerialTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try (//创建一个ObjectOutputStream输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
               //将对象序列化到文件s
            SPartsXm s = new SPartsXm();
            s.setParRowId("asdasdasdasda");
               oos.writeObject(s);
           } catch (Exception e) {
               e.printStackTrace();
           }
        
    }

}
