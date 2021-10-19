    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    );

    alter table note
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y
       foreign key (owner_id)
       references app_user;
