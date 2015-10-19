create table crfa (
	id int auto_increment primary key,
	registry int(20) not null,
	region int(5) not null
);

create table expert (
	id int auto_increment primary key,
	name varchar(100) not null,
	password varchar(20) not null,
	crfa_id int not null,
	activated boolean not null,
	constraint fk_crfa_ex foreign key (crfa_id) references crfa(id)
);

create table patient (
	id int auto_increment primary key,
	name varchar(100) not null,
	rg varchar(20),
	photo varchar(255),
	constraint uni_rg_patient unique(rg)
);

create table expert_patient (
	expert_id int not null,
	patient_id int not null,
	constraint fk_expert_id foreign key (expert_id) references expert(id),
	constraint fk_patient_id foreign key  (patient_id) references patient(id),
	constraint uni_expert_patient unique(expert_id, patient_id)
);

create table phoneme (
	id int auto_increment primary key,
	name varchar(45) not null,
	classification varchar(45) not null,
	constraint uni_phoneme_name unique(name)
);

create table exercise (
	id int auto_increment primary key,
	demo varchar(255),
	content varchar(45) not null,
	type varchar(45) not null,
	phoneme_id int not null,
	category varchar(45) not null,
	constraint fk_phoneme_id foreign key (phoneme_id) references phoneme(id)
);

create table recording_history (
	id int auto_increment primary key,
	record varchar(255) not null,
	date datetime not null,
	patient_id int not null,
	exercise_id int not null,
	constraint fk_exercise_rh foreign key (exercise_id) references exercise(id),
	constraint fk_patient_rh foreign key  (patient_id) references patient(id)
);

create table expert_exercise (
	expert_id int not null,
    exercise_id int not null,
    constraint uni_expert_exercise unique(expert_id, exercise_id)
);

-- INSERT phonemes
INSERT INTO `phoneme` 
VALUES (1,'/a/','VOWEL'),
(2,'/e/','VOWEL'),
(3,'/i/','VOWEL'),
(4,'/o/','VOWEL'),
(5,'/u/','VOWEL'),
(6,'/b/','CONSONANT'),
(7,'/k/','CONSONANT'),
(8,'/d/','CONSONANT'),
(9,'/f/','CONSONANT'),
(10,'/g/','CONSONANT'),
(11,'/l/','CONSONANT'),
(12,'/m/','CONSONANT'),
(13,'/n/','CONSONANT'),
(14,'/p/','CONSONANT'),
(15,'/r/','ARCHIPHONEME'),
(16,'/s/','ARCHIPHONEME'),
(17,'/t/','CONSONANT'),
(18,'/v/','CONSONANT'),
(19,'/z/','CONSONANT');

-- INSERT EXERCISES 
INSERT INTO `exercise` VALUES (1,'/site/content/video/demo/a.mp4','/a/','VIDEO',1,'ACQUIREMENT'),(2,'/site/content/video/demo/e.mp4','/e/','VIDEO',2,'ACQUIREMENT'),(3,'/site/content/video/demo/i.mp4','/i/','VIDEO',3,'ACQUIREMENT'),(4,'/site/content/video/demo/o.mp4','/o/','VIDEO',4,'ACQUIREMENT'),(5,'/site/content/video/demo/u.mp4','/u/','VIDEO',5,'ACQUIREMENT'),(6,'/site/content/video/demo/ba.mp4','/ba/','VIDEO',6,'ACQUIREMENT'),(7,'/site/content/video/demo/be.mp4','/be/','VIDEO',6,'ACQUIREMENT'),(8,'/site/content/video/demo/bi.mp4','/bi/','VIDEO',6,'ACQUIREMENT'),(9,'/site/content/video/demo/bo.mp4','/bo/','VIDEO',6,'ACQUIREMENT'),(10,'/site/content/video/demo/bu.mp4','/bu/','VIDEO',6,'ACQUIREMENT'),(11,'/site/content/video/demo/ã.mp4','/ã/','VIDEO',8,'ACQUIREMENT'),(12,NULL,'Bacana','DOC',6,'WORD'),(13,NULL,'Bom','DOC',6,'WORD'),(14,NULL,'Breja','DOC',6,'WORD'),(15,NULL,'Brinquedo','DOC',6,'WORD'),(16,NULL,'Boa','DOC',6,'WORD'),(17,NULL,'Bencha Deus','DOC',6,'WORD'),(18,NULL,'BarabarÃ¡','DOC',6,'WORD'),(19,NULL,'Beijo','DOC',6,'WORD'),(20,NULL,'Bruna','DOC',6,'WORD'),(21,NULL,'Brasil','DOC',6,'WORD'),(22,NULL,'Belgica','DOC',6,'WORD'),(23,NULL,'Babaca','DOC',6,'WORD'),(24,NULL,'boca','DOC',6,'WORD'),(25,'/site/content/audio/demo/Brahma.wav','Brahma','AUDIO',6,'WORD'),(27,'/site/content/audio/demo/Biju.wav','Biju','AUDIO',6,'WORD'),(28,'/site/content/audio/demo/Boceta.wav','Boceta','AUDIO',6,'WORD'),(29,NULL,'PROVA','DOC',7,'WORD'),(30,'/site/content/audio/demo/beber.wav','BEBER','AUDIO',6,'WORD');
