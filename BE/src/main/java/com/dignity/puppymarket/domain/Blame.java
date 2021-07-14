package com.dignity.puppymarket.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blame")
@ToString(exclude = {"item", "user"})
@Builder
@AllArgsConstructor
public class Blame {
    @Id
    @GeneratedValue
    @Column(name = "blame_id")
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private BlameStatus blameStatus;

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

}
