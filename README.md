# Тестовое задание

Приложение создано на стеке Spring Boot + MVC + Hibernate + Postgresql

## Архитектура
Приложение реализовано на архитектуре "модульный монолит":
1. [core](src/main/java/com/test/bank/core) - управляющий "модуль"
2. [client_module](src/main/java/com/test/bank/client_module) - "модуль" клиента
3. [credit_agreement_module](src/main/java/com/test/bank/credit_agreement_module) - "модуль" кредитных договоров
4. [credit_application_module](src/main/java/com/test/bank/credit_application_module) - "модуль" заявок на кредит

## База данных

### Таблица Users

SQL

```
create table clients
(
    id               serial
        primary key,
    first_name       varchar(100)                                     not null,
    middle_name      varchar(100)                                     not null,
    last_name        varchar(100) default ''::character varying,
    passport_details varchar(25)                                      not null
        constraint clients_pk
            unique,
    phone_number     varchar(12)                                      not null
        constraint clients_pk_2
            unique,
    marital_status   varchar(20)  default 'single'::character varying not null,
    address          varchar(255)                                     not null,
    work_experience  integer      default 0,
    job_title        varchar(100) default 'worker'::character varying,
    organization     varchar(255) default 'self-employed'::character varying
);

alter table clients
    owner to vladdrd;
```

|id|first_name|middle_name|last_name|passport_details|phone_number|marital_status|address|work_experience|job_title|organization|
|--|----------|-----------|---------|----------------|------------|--------------|-------|---------------|---------|------------|
|  |          |           |         |                |            |              |       |               |         |            |


### Таблица credit_applications

SQL

```
create table credit_applications
(
    id            serial
        primary key,
    client_id     integer          default 1
        references clients,
    credit_amount double precision,
    status        varchar(20)      default 'not_approved'::character varying,
    approved_sum  double precision default 0,
    deadline      integer,
    date          timestamp not null,
    is_approved   boolean          default false
);

alter table credit_applications
    owner to vladdrd;
```

|id|first_name|middle_name|last_name|passport_details|phone_number|marital_status|address|work_experience|job_title|organization|
|--|----------|-----------|---------|----------------|------------|--------------|-------|---------------|---------|------------|
|  |          |           |         |                |            |              |       |               |         |            |


### Таблица agreements

SQL

```
create table agreements
(
    id            serial
        primary key,
    credit_app_id integer
        references credit_applications,
    sign_date     timestamp,
    status        varchar(20) default 'not_signed'::character varying
);

alter table agreements
    owner to vladdrd;
```


|id|credit_app_id|sign_date|status|
|--|-------------|---------|------|

