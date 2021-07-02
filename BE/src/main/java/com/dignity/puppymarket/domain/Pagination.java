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

    @Builder
    public Pagination(int totalPages, long totalElements, int currentPage, int currentElements) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.currentElements = currentElements;
    }

    public static Pagination itemWith(Page<Item> items) {
        return Pagination.builder()
                .totalPages(items.getTotalPages())
                .totalElements(items.getTotalElements())
                .currentPage(items.getNumber())
                .currentElements(items.getNumberOfElements())
                .build();
    }
}
