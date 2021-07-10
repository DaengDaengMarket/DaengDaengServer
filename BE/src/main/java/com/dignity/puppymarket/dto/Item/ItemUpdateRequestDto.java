package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemUpdateRequestDto {
    private String name;

    private int price;

    private String description;

    private Categories categories;

    private ItemStatus itemStatus;

    private NegoStatus negoStatus;

    private BigCategory bigCategory;

    private MidCategory midCategory;

    private List<ItemImage> itemImageList;

    private Si si;

    private Gu gu;

    public ItemUpdateRequestDto(String name, int price, String description, Categories categories, ItemStatus itemStatus,
                                NegoStatus negoStatus, BigCategory bigCategory, MidCategory midCategory,
                                List<ItemImage> itemImageList, Si si, Gu gu) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categories = categories;
        this.itemStatus = itemStatus;
        this.negoStatus = negoStatus;
        this.bigCategory = bigCategory;
        this.midCategory = midCategory;
        this.itemImageList = itemImageList;
        this.si = si;
        this.gu = gu;
    }
}
