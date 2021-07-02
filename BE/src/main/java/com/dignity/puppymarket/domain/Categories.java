package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue
    @Column(name = "categories_id")
    private Long id;

    private String name;

    //Categories 1 : N Item
    @OneToMany
    private List<Item> itemList = new ArrayList<>();

    //Categories(child) N : 1 Categories(parent)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Categories parent;

    //Categories(parent) 1 : N Categories(child)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Categories> child = new ArrayList<>();

    public void addChildCategories(Categories child) {
        this.child.add(child);
        child.setParent(this);
    }
}
