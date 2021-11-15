package com.dodo.sync;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.test.bean.SPartsXm;

public class beanEqTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SPartsXm sp = new SPartsXm();
        SPartsXm sp1 = new SPartsXm();
        System.out.println(sp.equals(sp1));
        SPartsXm sp2 = new SPartsXm();
        sp2.setAbcCodeCd(22);
        System.out.println(sp.equals(sp2));
        
        long a = 9223372036854775807l;
        System.out.println(Long.MAX_VALUE);
        
        
    }   
    
private void aaa() {
    List<Object> attrs = new ArrayList<>();
    List<Object> editEntity = new ArrayList<>();
    
    for(Object o : editEntity) {
        Object ot = new Object();
        BeanUtils.copyProperties(o,ot);
        attrs.add(ot);
    }
    
    
    
}
}
