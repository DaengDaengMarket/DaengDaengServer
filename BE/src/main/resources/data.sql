/*DROP TABLE IF EXISTS advertise;

CREATE TABLE advertise (advertise_id INT PRIMARY KEY AUTO_INCREMENT,
                        image_path VARCHAR(45),
                        orders INT);

INSERT INTO advertise (image_path, orders) VALUES ('https://picsum.photos/1920/570/?image=814', 1);
INSERT INTO advertise (image_path, orders) VALUES ('https://picsum.photos/1920/570/?image=815', 2);
INSERT INTO advertise (image_path, orders) VALUES ('https://picsum.photos/1920/570/?image=816', 3);

DROP TABLE IF EXISTS user ;
create table user (
                      user_id INT PRIMARY KEY AUTO_INCREMENT,
                      big_category varchar(255),
                      email varchar(255),
                      gu varchar(255),
                      image_path varchar(255),
                      nickname varchar(255),
                      password varchar(255),
                      rate float,
                      si varchar(255),
                      tel varchar(255)
);
insert into user (big_category, email, gu, image_path, nickname, password, rate, si, tel)
values('대형견', 'melon', 'JONGNOGU', 'https://picsum.photos/1920/570/?image=816', 'hello', '1234', 4.5, 'SEOULSI', '1234');
insert into user (big_category, email, gu, image_path, nickname, password, rate, si, tel)
values('중현견', 'abcd', 'GWANGJINGU', 'https://picsum.photos/1920/570/?image=817', 'luis', '5678', 3.5, 'SEOULSI', '4321');

DROP TABLE IF EXISTS item;
create table item (
                      item_id INT PRIMARY KEY AUTO_INCREMENT,
                      big_category varchar(255),
                      created_at datetime(6),
                      description varchar(255),
                      gu varchar(255),
                      hit integer not null,
                      item_status varchar(255),
                      mid_category varchar(255),
                      name varchar(255),
                      nego_status varchar(255),
                      price integer not null,
                      si varchar(255),
                      updated_at datetime(6),
                      buyer_id bigint,
                      seller_id bigint
);

ALTER TABLE item
    ADD CONSTRAINT FK_item_seller_id_user_user_id FOREIGN KEY (seller_id)
        REFERENCES user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE item
    ADD CONSTRAINT FK_item_buyer_id_user_user_id FOREIGN KEY (buyer_id)
        REFERENCES user (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;


insert into item (big_category, created_at, description, gu, hit, item_status, mid_category, name, nego_status, price, si, updated_at, buyer_id, seller_id)
values ('대형견', '2021-06-17', '안녕', 'JONGNOGU', 50, 'NEW', 'ETC', '기타상품입니다', 'OK', 100, 'SEOULSI', '2021-06-18', 1, 2);

create table item_image (
                            item_image_id INT PRIMARY KEY AUTO_INCREMENT,
                            orders integer not null,
                            path varchar(255),
                            item_id bigint
);

ALTER TABLE item_image
    ADD CONSTRAINT FK_item_image_item_id_item_item_id FOREIGN KEY (item_id)
        REFERENCES item (item_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

insert into item_image (orders, path, item_id) values (1, 'https://picsum.photos/1920/570/?image=814', 1);
insert into item_image (orders, path, item_id) values (2, 'https://picsum.photos/1920/570/?image=815', 1);
insert into item_image (orders, path, item_id) values (3, 'https://picsum.photos/1920/570/?image=816', 1);

*/
