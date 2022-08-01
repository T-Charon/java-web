package com.blb.test;

/**
 * @Author Charon
 * @Date 2022/7/31
 **/

/**
 * 票
 */
public class Ticket {
    private int id;
    public Ticket(int id){
        this.id= id;
    };

    @Override
    public String toString() {
        return "火车票 id:" + id;
    }
}
