CREATE TABLE `schedule`
    (
        `schcdule_id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정id',
        `user_id` BIGINT NOT NULL COMMENT '유저id',
        `planTitle` VARCHAR(100) NOT NULL COMMENT '일정 제목',
        `planContents` LONGTEXT COMMENT '일정 내용',
        `createDate` DATETIME NOT NULL COMMENT '생성날짜',
        `editDate` DATETIME NOT NULL COMMENT '수정날짜'
);

CREATE TABLE `user`
    (
        `user_id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '유저id',
        `userName` VARCHAR(100) NOT NULL COMMENT '유저 이름',
        `userEmail` VARCHAR(100) NOT NULL COMMENT '유저 이메일',
        `password` VARCHAR(100) NOT NULL COMMENT '비밀번호',
        `createDate` DATETIME NOT NULL COMMENT '생성날짜',
        `editDate` DATETIME NOT NULL COMMENT '수정날짜'
);
ALTER TABLE `schedule`
ADD CONSTRAINT `FK_schedule_user` FOREIGN KEY (user_id) REFERENCES `user` (user_id);
