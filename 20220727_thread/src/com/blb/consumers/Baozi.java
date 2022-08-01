package com.blb.consumers;

/**
 * @Author Charon
 * @Date 2022/7/29
 **/

/**
 * 包子类
 */
public class Baozi {
    private int id;

    public Baozi(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "包子 id:" + id;
    }
}
