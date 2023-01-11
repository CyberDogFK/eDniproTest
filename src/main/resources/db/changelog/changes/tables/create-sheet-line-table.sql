--liquibase formatted sql
--changeset <antonpavliuk>:<create-sheet_line-table>
CREATE TABLE `sheet_line` (
                              `sheet_id` bigint NOT NULL,
                              `line_id` bigint NOT NULL,
                              UNIQUE KEY `UK_4opk0molgfx5vpeewin53uv36` (`line_id`),
                              KEY `FK8m2mvm226ll63hjwhbtk9w0qm` (`sheet_id`),
                              CONSTRAINT `FK8kdtfivswxmoqc8k5cb36ag94` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`),
                              CONSTRAINT `FK8m2mvm226ll63hjwhbtk9w0qm` FOREIGN KEY (`sheet_id`) REFERENCES `sheet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--rollback DROP TABLE `sheet_line`;
