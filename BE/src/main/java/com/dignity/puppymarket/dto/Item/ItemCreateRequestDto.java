package com.dignity.puppymarket.dto.Item;

import com.dignity.puppymarket.domain.BigCategory;
import com.dignity.puppymarket.domain.Gu;
import com.dignity.puppymarket.domain.Item;
import com.dignity.puppymarket.domain.ItemImage;
import com.dignity.puppymarket.domain.MidCategory;
import com.dignity.puppymarket.domain.NegoStatus;
import com.dignity.puppymarket.domain.Si;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemCreateRequestDto {
     private String name;

    private int price;

    private String description;

    private NegoStatus negoStatus;

    private BigCategory bigCategory;

    private MidCategory midCategory;

    private Si si;

    private Gu gu;

    private List<ItemImage> itemImageList;

    @Builder
    public ItemCreateRequestDto(String name, int price, String description, NegoStatus negoStatus,
                                BigCategory bigCategory, MidCategory midCategory, Si si, Gu gu,
                                List<ItemImage> itemImageList) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.negoStatus = negoStatus;
        this.bigCategory = bigCategory;
        this.midCategory = midCategory;
        this.si = si;
        this.gu = gu;
        this.itemImageList = itemImageList;
    }

    public Item toEntity() {
        return Item.builder()
                .name(this.name)
                .price(this.price)
                .description(this.description)
                .negoStatus(this.negoStatus)
                .bigCategory(this.bigCategory)
                .midCategory(this.midCategory)
                .si(this.si)
                .gu(this.gu)
                .itemImageList(this.itemImageList)
                .build();
    }
}
