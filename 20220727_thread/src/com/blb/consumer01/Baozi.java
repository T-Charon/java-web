package com.blb.consumer01;

/**
 * @Author Charon
 * @Date 2022/7/29
 **/
public class Baozi {
    private int id;
    public Baozi(int id){
        this.id= id;
    };

    @Override
    public String toString() {
        return "包子 id:" + id;
    }
}
