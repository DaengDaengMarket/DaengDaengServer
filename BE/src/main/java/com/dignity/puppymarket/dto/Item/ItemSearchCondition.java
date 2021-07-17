package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.MidCategory;
import lombok.Data;

@Data
public class ItemSearchCondition {
    // 게시물 명(아이템 명), 대분류, 소분류
    private String name;
    private BigCategory bigCategory;
    private MidCategory midCategory;
}