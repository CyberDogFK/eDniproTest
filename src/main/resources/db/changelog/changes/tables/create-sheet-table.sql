--liquibase formatted sql
--changeset <antonpavliuk>:<create-sheet-table>
CREATE TABLE `sheet` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


--rollback DROP TABLE `sheet`;

