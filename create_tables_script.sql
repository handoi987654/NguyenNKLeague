create table League
(
    ID          int auto_increment
        primary key,
    name        varchar(64) charset utf8 not null,
    createdDate date                     not null
);

create table Club
(
    ID       int auto_increment
        primary key,
    leagueID int                      null,
    name     varchar(64) charset utf8 not null,
    point    int default 0            null,
    constraint Club_League_ID_fk
        foreign key (leagueID) references League (ID)
);

create table `Match`
(
    ID           int auto_increment
        primary key,
    leagueID     int         not null,
    firstClubID  int         not null,
    secondClubID int         not null,
    date         date        not null,
    result       varchar(16) null,
    constraint Match_Club_ID_fk
        foreign key (firstClubID) references Club (ID),
    constraint Match_Club_ID_fk_2
        foreign key (secondClubID) references Club (ID),
    constraint Match_League_ID_fk
        foreign key (leagueID) references League (ID)
);

create table Player
(
    ID     int auto_increment
        primary key,
    clubID int                       not null,
    name   varchar(128) charset utf8 not null,
    constraint Player_Club_ID_fk
        foreign key (clubID) references Club (ID)
);


