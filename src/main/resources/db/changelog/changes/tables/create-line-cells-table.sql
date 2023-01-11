--liquibase formatted sql
--changeset <antonpavliuk>:<create-line_cells-table>
CREATE TABLE `line_cells` (
                              `line_id` bigint NOT NULL,
                              `cell_id` bigint NOT NULL,
                              UNIQUE KEY `UK_k3owtfny6id54jg1avb18yuxo` (`cell_id`),
                              KEY `FKjul0e4s22xmxeci0d93db4eho` (`line_id`),
                              CONSTRAINT `FKixk8rqqolulrqk6c7umg71nqu` FOREIGN KEY (`cell_id`) REFERENCES `cell` (`id`),
                              CONSTRAINT `FKjul0e4s22xmxeci0d93db4eho` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--rollback DROP TABLE `line_cells`;
