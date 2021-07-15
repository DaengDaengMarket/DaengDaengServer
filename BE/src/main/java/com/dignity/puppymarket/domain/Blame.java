package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blame")
@ToString(exclude = {"item", "user"})
@Builder
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Blame {
    @Id
    @GeneratedValue
    @Column(name = "blame_id")
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private BlameStatus blameStatus = BlameStatus.OK;

    @CreatedDate
    private LocalDateTime createdAt;

    //Blame N : 1 Item
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //Blame N : 1 User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void addItem(Item savedItem) {
        this.item = savedItem;
        savedItem.addBlame(this);
    }

    public void addUser(User savedUser) {
        this.user = savedUser;
        savedUser.addBlame(this);
    }
}
