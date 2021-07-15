package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "wish")
@Builder
@ToString(exclude = {"user", "item"})
public class Wish {
    @Id
    @GeneratedValue
    @Column(name = "wish_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private WishStatus wishStatus = WishStatus.OK;

    //Wish N : 1 User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //Wish N : 1 Item
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void addItem(Item item) {
        this.item = item;
        item.addWish(this);
    }

    public void addUser(User user) {
        this.user = user;
        user.addWish(this);
    }

    public void updateWishStatus(WishStatus wishStatus) {
        if(wishStatus.equals(WishStatus.NO)) {
            this.wishStatus = WishStatus.OK;
        }

        if(wishStatus.equals(WishStatus.OK)) {
            this.wishStatus = WishStatus.NO;
        }
    }
}
