package com.dignity.puppymarket.repository;

import com.dignity.puppymarket.domain.*;
import com.dignity.puppymarket.dto.Item.ItemCategoryGetResponseDto;
import com.dignity.puppymarket.dto.Item.ItemSearchCondition;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaItemRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public JpaItemRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

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

    public List<ItemCategoryGetResponseDto> search(ItemSearchCondition condition, int page, int size){

        QItem item = QItem.item;
        return queryFactory
                .select(Projections.fields(ItemCategoryGetResponseDto.class,
                        item.id,
                        item.name,
                        item.price,
                        item.hit,
                        item.bigCategory,
                        item.midCategory,
                        item.createdAt,
                        item.si,
                        item.gu
                        ))
                .from(item)
                .where(
                        itemNameEq(condition.getName()),
                        midCategoryEq(condition.getMidCategory()),
                        bigCategoryEq(condition.getBigCategory())
                )
                .offset((page - 1) * size)
                .limit(size)
                .fetch();
    }

    private BooleanExpression itemNameEq(String name) {
        return StringUtils.hasText(name) ? QItem.item.name.eq(name) : null;
    }

    private BooleanExpression midCategoryEq(MidCategory midCategory) {
        return ObjectUtils.isEmpty(midCategory) ? null : QItem.item.midCategory.eq(midCategory);
    }

    private BooleanExpression bigCategoryEq(BigCategory bigCategory) {
        return ObjectUtils.isEmpty(bigCategory) ? null : QItem.item.bigCategory.eq(bigCategory);
    }
}
