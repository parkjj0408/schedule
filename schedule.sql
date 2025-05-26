create table schedule
(
    id          bigint auto_increment primary key,
    userid      bigint       null,
    username    varchar(255) not null,
    contents    varchar(255) not null,
    title       varchar(255) not null,
    create_at   datetime(6)  null,
    modified_at datetime(6)  null,

        foreign key (userid) references user (userid)
);
