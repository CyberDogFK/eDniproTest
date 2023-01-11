--liquibase formatted sql
--changeset <antonpavliuk>:<create-cell-table>
CREATE TABLE `cell` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `value` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--rollback DROP TABLE `cell`;

