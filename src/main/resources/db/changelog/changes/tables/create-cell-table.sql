--liquibase formatted sql
--changeset <antonpavliuk>:<create-cell-table>
CREATE TABLE `cell` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `value` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--rollback DROP TABLE `cell`;

