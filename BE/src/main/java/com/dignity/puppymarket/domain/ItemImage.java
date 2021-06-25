package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item_image")
@ToString(exclude = {"item"})
public class ItemImage {
    @Id
    @GeneratedValue
    @Column(name = "item_image_id")
    private Long id;

    private String path;

    private int orders;

    //ItemImage N : 1 Item
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public ItemImage(Long id, String path, int orders, Item item) {
        this.id = id;
        this.path = path;
        this.orders = orders;
        this.item = item;
    }
}
