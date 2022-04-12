-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE `AUTHOR` (
	`id` INT NOT NULL,
	`name` varchar(100) NOT NULL,
	`citizenship` varchar(100) NOT NULL,
	`birthdate` DATE NOT NULL,
	CONSTRAINT `AUTHOR_PK` PRIMARY KEY (`id`)
)
ENGINE=InnoDB;

CREATE TABLE `BOOK` (
	`id` INT  NOT NULL,
	`name` varchar(100) NULL,
	`price` INT NOT NULL,
	`format` varchar(100) NOT NULL,
	`language` varchar(100) NOT NULL,
	`publicationdate` DATE NOT NULL,
	`rating` SMALLINT NOT NULL,
	`author_id` INT NOT NULL,
	CONSTRAINT `BOOK_PK` PRIMARY KEY (`id`),
	CONSTRAINT `BOOK_FK` FOREIGN KEY (`author_id`) REFERENCES `AUTHOR`(`id`)
)
ENGINE=InnoDB;

CREATE TABLE `REVIEW` (
	`id` INT NOT NULL,
	`title` varchar(100) NOT NULL,
	`date` DATE NOT NULL,
	`comment` varchar(1000) NOT NULL,
	`rating` SMALLINT NOT NULL,
	`book_id` INT NOT NULL,
	CONSTRAINT `REVIEW_PK` PRIMARY KEY (`id`),
	CONSTRAINT `REVIEW_FK` FOREIGN KEY (`book_id`) REFERENCES `BOOK`(`id`)
)
ENGINE=InnoDB;
