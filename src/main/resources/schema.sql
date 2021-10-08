create table netology.persons
(
    name varchar(100) not null ,
    surname varchar(100) not null ,
    age int check ( age >= 0 ) not null ,
    phone_noumber int,
    city_of_living varchar(100),
    primary key (name, surname, age)
);