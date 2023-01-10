--liquibase formatted sql
--changeset <antonpavliuk>:<create-sheet-table>
CREATE TABLE `sheet` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--rollback DROP TABLE `sheet`;

