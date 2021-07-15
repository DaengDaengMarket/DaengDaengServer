package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
@ToString(exclude = {"sellerItemList", "buyerItemList", "blameList", "wishList", "chatRoomList", "chatMessageList"})
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String nickname;

    private String name;

    private String imagePath;

    private String tel;

    private Float rate;

    @Enumerated(EnumType.STRING)
    private Si si;

    @Enumerated(EnumType.STRING)
    private Gu gu;

    @Enumerated(EnumType.STRING)
    private BigCategory concern;

    //User(seller) 1 : N Item
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    List<Item> sellerItemList = new ArrayList<>();

    //User(buyer) 1: N Item
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer")
    List<Item> buyerItemList = new ArrayList<>();

    //User 1 : N Blame
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Blame> blameList = new ArrayList<>();

    //User 1 : N Wish
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Wish> wishList = new ArrayList<>();

    //User 1 : N chatRoom
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ChatRoom> chatRoomList = new ArrayList<>();

    //User(sender) 1 : N ChatMessage
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
    private List<ChatMessage> chatMessageList = new ArrayList<>();

    @Builder
    public User(String email, String password, String nickname, String name, String imagePath, String tel, Float rate,
                Si si, Gu gu, BigCategory concern, List<Item> sellerItemList, List<Item> buyerItemList,
                List<Blame> blameList, List<Wish> wishList, List<ChatRoom> chatRoomList, List<ChatMessage> chatMessageList) {
                Blame blame, List<Wish> wishList, List<ChatRoom> chatRoomList, List<ChatMessage> chatMessageList) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.imagePath = imagePath;
        this.tel = tel;
        this.rate = rate;
        this.si = si;
        this.gu = gu;
        this.concern = concern;
        this.sellerItemList = sellerItemList;
        this.buyerItemList = buyerItemList;
        this.blameList = blameList;
        this.wishList = wishList;
        this.chatRoomList = chatRoomList;
        this.chatMessageList = chatMessageList;
    }

    public boolean authenticate(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.password);
    }

    public void updatePassword(String password, PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public void updateLocationWith(String guCode, String siCode) {
        Gu gu = Gu.findByGuCode(guCode);
        Si si = Si.findBySiCode(siCode);

        this.gu = gu;
        this.si = si;
    }

    public boolean isSame(String userEmail) {
        return this.email.equals(userEmail);
    }

    public void addBlame(Blame blame) {
        blameList.add(blame);
    }

    public void addWish(Wish wish) {
        wishList.add(wish);
    }
}
