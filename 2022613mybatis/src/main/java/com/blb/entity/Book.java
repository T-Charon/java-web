package com.blb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/6/13
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String bookName;
    private int bookTypeId;
    private BookType bookType;
}
