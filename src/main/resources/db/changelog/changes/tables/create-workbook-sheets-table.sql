--liquibase formatted sql
--changeset <antonpavliuk>:<create-workbook_sheets-table>
CREATE TABLE `workbook_sheets` (
                                   `workbook_id` bigint NOT NULL,
                                   `sheet_id` bigint NOT NULL,
                                   UNIQUE KEY `UK_68srpkh5xft2yl2a1dtfy7woq` (`sheet_id`),
                                   KEY `FKnamg549x8vlpjcg6sieydqq3d` (`workbook_id`),
                                   CONSTRAINT `FKl7f1rrnqirm8s8bfrdatitcra` FOREIGN KEY (`sheet_id`) REFERENCES `sheet` (`id`),
                                   CONSTRAINT `FKnamg549x8vlpjcg6sieydqq3d` FOREIGN KEY (`workbook_id`) REFERENCES `workbook` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--rollback DROP TABLE `workbook_sheets`;
