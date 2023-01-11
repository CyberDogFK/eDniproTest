--liquibase formatted sql
--changeset <antonpavliuk>:<create-workbook-table>
CREATE TABLE `workbook` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) DEFAULT NULL,
                            `saving_date_time` datetime(6) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


--rollback DROP TABLE `workbook`;

