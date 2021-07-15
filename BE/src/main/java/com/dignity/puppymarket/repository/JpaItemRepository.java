package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.Categories;
import com.dignity.puppymarket.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaItemRepository {

    private final EntityManager em;

    public Categories findById(Long id) {
        return em.find(Categories.class, id);
    }

    public List<Item> getItemsInCategory(Long id, String name) {

        List<Item> itemList = em.createQuery("select c from Categories c " +
                "where c.parent.id = :id and c.name = :name", Categories.class)
                .setParameter("id", id)
                .setParameter("name", name)
                .getSingleResult()
                .getItemList();
        System.out.println("itemList.size() = " + itemList.size());
        for (Item item : itemList) {
            System.out.println("레포지토리에서 출력 item = " + item);
        }
        return itemList;
    }
}
