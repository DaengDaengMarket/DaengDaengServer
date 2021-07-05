package com.dignity.puppymarket.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "notice")

public class Notice {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title_id")
    private String title;

    @Column(name = "content_id")
    private String content;

    public Notice(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    // 기존의 내용을 update로 변경한다.
    public void update(Notice form) {
        this.title = form.getTitle();
        this.content = form.getContent();
    }

}
