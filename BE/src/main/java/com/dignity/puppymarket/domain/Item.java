package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "item")
@ToString(exclude = {"seller", "buyer", "itemImageList", "blameList", "wishList", "review", "chatRoom"})
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private String description;

    @Builder.Default
    private int hit = 0;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ItemStatus itemStatus = ItemStatus.NEW;

    @Enumerated(EnumType.STRING)
    private NegoStatus negoStatus;

    @Enumerated(EnumType.STRING)
    private BigCategory bigCategory;

    @Enumerated(EnumType.STRING)
    private MidCategory midCategory;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Si si;

    @Enumerated(EnumType.STRING)
    private Gu gu;

    //Item N : 1 User(seller)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", referencedColumnName="user_id")
    private User seller;

    //Item N : 1 User(buyer)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", referencedColumnName="user_id")
    private User buyer;

    //Item 1 : N ItemImage
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<ItemImage> itemImageList = new ArrayList<>();

    //Item 1 : N Blame
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<Blame> blameList = new ArrayList<>();

    //Item 1 : N Wish
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<Wish> wishList = new ArrayList<>();
    
    //Item 1 : 1 Review
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "item")
    private Review review;

    //Item 1 : N chatRoom
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<ChatRoom> chatRoomList = new ArrayList<>();

    public Item(Long id, String name, int price, String description, int hit, ItemStatus itemStatus,
                NegoStatus negoStatus, BigCategory bigCategory, MidCategory midCategory, LocalDateTime createdAt,
                LocalDateTime updatedAt, Si si, Gu gu, User seller, User buyer, List<ItemImage> itemImageList,
                List<Blame> blameList, List<Wish> wishList, Review review, List<ChatRoom> chatRoomList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.hit = hit;
        this.itemStatus = itemStatus;
        this.negoStatus = negoStatus;
        this.bigCategory = bigCategory;
        this.midCategory = midCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.si = si;
        this.gu = gu;
        this.seller = seller;
        this.buyer = buyer;
        this.itemImageList = itemImageList;
        this.blameList = blameList;
        this.wishList = wishList;
        this.review = review;
        this.chatRoomList = chatRoomList;
    }
}
