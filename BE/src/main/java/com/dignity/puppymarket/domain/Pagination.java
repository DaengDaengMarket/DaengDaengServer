package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Pagination {
    private int totalPages;

    private long totalElements;

    private int currentPage;

    private int currentElements;

    private boolean hasNext;

    private boolean hasPrevious;

    @Builder
    public Pagination(int totalPages, long totalElements, int currentPage,
                      int currentElements, boolean hasNext, boolean hasPrevious) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.currentElements = currentElements;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }

    public static Pagination itemWith(Page<Item> items) {
        return Pagination.builder()
                .totalPages(items.getTotalPages())
                .totalElements(items.getTotalElements())
                .currentPage(items.getNumber())
                .currentElements(items.getNumberOfElements())
                .hasNext(items.hasNext())
                .hasPrevious(items.hasPrevious())
                .build();
    }

    public static Pagination reviewWith(Page<Review> pageReviews) {
        return Pagination.builder()
                .totalPages(pageReviews.getTotalPages())
                .totalElements(pageReviews.getTotalElements())
                .currentPage(pageReviews.getNumber())
                .currentElements(pageReviews.getNumberOfElements())
                .hasNext(pageReviews.hasNext())
                .hasPrevious(pageReviews.hasPrevious())
                .build();
    }
}
