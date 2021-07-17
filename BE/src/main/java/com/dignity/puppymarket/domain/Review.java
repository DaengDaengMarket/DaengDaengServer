package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review")
@ToString(exclude = {"item"})
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    private String content;

    private Float rate;

    @CreatedDate
    private LocalDateTime createdAt;

    //Review 1 : 1 Item
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public Review(Long id, String content, Float rate, LocalDateTime createdAt, Item item) {
        this.id = id;
        this.content = content;
        this.rate = rate;
        this.createdAt = createdAt;
        this.item = item;
    }

    public void addItem(Item item) {
        this.item = item;
        item.addReview(this);
    }
}
