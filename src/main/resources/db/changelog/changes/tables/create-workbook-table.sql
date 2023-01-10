--liquibase formatted sql
--changeset <antonpavliuk>:<create-workbook-table>
CREATE TABLE `workbook` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--rollback DROP TABLE `workbook`;

