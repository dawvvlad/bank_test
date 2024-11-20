# Тестовое задание

## Архитектура
Приложение реализовано на архитектуре "модульный монолит":
1. [core](src/main/java/com/test/bank/core) - управляющий "модуль"
2. [client_module](src/main/java/com/test/bank/client_module) - "модуль" клиента
3. [credit_agreement_module](src/main/java/com/test/bank/credit_agreement_module) - "модуль" кредитных договоров
4. [credit_application_module](src/main/java/com/test/bank/credit_application_module) - "модуль" заявок на кредит

## База данных

### Таблица Users
|id|first_name|middle_name|last_name|passport_details|phone_number|marital_status|address|work_experience|job_title|organization|
|--|----------|-----------|---------|----------------|------------|--------------|-------|---------------|---------|------------|
