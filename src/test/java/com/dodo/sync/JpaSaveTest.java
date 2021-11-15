package com.dodo.sync;

import cn.hutool.core.util.ReflectUtil;
import com.test.bean.SPartsXm;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JpaSaveTest {
    public <S extends T> List<S> save(Iterable<S> entities) {
        List<S> result = new ArrayList<S>();

        if (entities == null) {
            return result;
        }

        for (S entity : entities) {

            System.out.println(entity);
        }

        return result;
    }

    private static void save(Object entity) {
        // 获取属性
        // 存在modify_time
        // 调用ctxtools
        Object entityId = ReflectUtil.getField(entity.getClass(), "modifyTime");
        System.out.println(entityId);
    }

    static class SaveParent{
        private void save(){
            System.out.println("parent save");
        }
        private void update(){
            System.out.println("parent upd");
            save();
        }
    }
    static class SaveChild extends SaveParent{
        private void save(){
            System.out.println("child save");
            super.save();
        }
        private void update(){
            System.out.println("child upd");
            save();
        }
    }

    public static void main(String[] args) {
//        SPartsXm sp = new SPartsXm();
//        sp.setId("1");
//        save(sp);
        SaveChild sc = new SaveChild();
        SaveParent sp = new SaveParent();
        sc.update();
    }
}
