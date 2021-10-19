
    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user

    create table app_user (
       id  bigserial not null,
        email varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table app_user_roles (
       app_user_id int8 not null,
        roles varchar(255)
    )

    create table note (
       id  bigserial not null,
        created_date int8,
        description varchar(255),
        title varchar(255),
        owner_id int8,
        primary key (id)
    )

    alter table app_user 
       add constraint UK_1j9d9a06i600gd43uu3km82jw unique (email)

    alter table app_user_roles 
       add constraint FKkwxexnudtp5gmt82j0qtytnoe 
       foreign key (app_user_id) 
       references app_user

    alter table note 
       add constraint FKjl54w6uv8owox1s3dqb0w4r0y 
       foreign key (owner_id) 
       references app_user
