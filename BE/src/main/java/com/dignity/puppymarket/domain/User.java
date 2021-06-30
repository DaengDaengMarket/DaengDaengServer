package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@ToString(exclude = {"sellerItemList", "buyerItemList", "blame", "wish", "chatRoomList", "chatMessageList"})
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String password;

    private String nickname;

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

    //User 1 : 1 Blame
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Blame blame;

    //User 1 : N Wish
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Wish> wishList = new ArrayList<>();

    //User 1 : N chatRoom
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ChatRoom> chatRoomList = new ArrayList<>();

    //User(sender) 1 : N ChatMessage
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
    private List<ChatMessage> chatMessageList = new ArrayList<>();

    public boolean authenticate(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.password);
    }
}
