create table app_user
(
    id       bigserial not null,
    email    varchar(255),
    password varchar(255),
    primary key (id)
);

alter table app_user
    add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email);

create table app_user_roles
(
    app_user_id int8 not null,
    roles       varchar(255)
);
alter table app_user_roles
    add constraint FK3idtpbhpwr5210xln1uclapsm
        foreign key (app_user_id)
            references app_user;