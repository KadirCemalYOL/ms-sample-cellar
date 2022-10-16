package com.kcy.mssamplecellar.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ItemPagedList extends PageImpl<ItemDto> {
    public ItemPagedList(List<ItemDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public ItemPagedList(List<ItemDto> content) {
        super(content);
    }
}
