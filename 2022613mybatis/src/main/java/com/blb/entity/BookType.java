package com.blb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/13
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookType {
    private int id;
    private String bookType;
    private List<Book> books;
}
