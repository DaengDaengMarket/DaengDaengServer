package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "advertise")
@ToString
public class Advertise {
    @Id
    @GeneratedValue
    @Column(name = "advertise_id")
    private Long id;

    private String imagePath;

    private int orders;

    @Builder
    public Advertise(Long id, String imagePath, int orders) {
        this.id = id;
        this.imagePath = imagePath;
        this.orders = orders;
    }
}
