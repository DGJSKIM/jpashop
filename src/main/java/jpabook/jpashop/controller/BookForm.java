package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor

public class BookForm {


    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;



}
