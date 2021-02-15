create table edu_teacher
(
    `id`           bigint auto_increment comment '讲师ID' primary key,
    `name`         varchar(20)                  not null comment '讲师姓名',
    `intro`        varchar(500)     default ''  not null comment '讲师简介',
    `career`       varchar(500)                 null comment '讲师资历,一句话说明讲师',
    `level`        int unsigned                 not null comment '头衔 1高级讲师 2首席讲师',
    `avatar`       varchar(255)                 null comment '讲师头像',
    `sort`         int unsigned     default '0' not null comment '排序',
    `is_deleted`   tinyint unsigned default '0' not null comment '逻辑删除 1（true）已删除， 0（false）未删除',
    `gmt_create`   datetime                     not null comment '创建时间',
    `gmt_modified` datetime                     not null comment '更新时间',
    constraint uk_name unique (`name`)
)
    comment '讲师' charset = utf8mb4;

CREATE TABLE `edu_subject`
(
    `id`           bigint auto_increment comment '课程类别ID' primary key,
    `title`        varchar(10)      NOT NULL COMMENT '类别名称',
    `parent_id`    bigint           NOT NULL DEFAULT '0' COMMENT '父ID',
    `sort`         int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
    `gmt_create`   datetime         NOT NULL COMMENT '创建时间',
    `gmt_modified` datetime         NOT NULL COMMENT '更新时间',
    KEY `idx_parent_id` (`parent_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='课程科目';

CREATE TABLE `edu_course`
(
    `id`                bigint AUTO_INCREMENT COMMENT '课程ID' PRIMARY KEY,
    `teacher_id`        bigint                          NOT NULL COMMENT '课程讲师ID',
    `subject_id`        bigint                          NOT NULL COMMENT '课程专业ID',
    `subject_parent_id` BIGINT                                   DEFAULT NULL,
    `title`             varchar(50)                     NOT NULL COMMENT '课程标题',
    `price`             decimal(10, 2) unsigned         NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
    `lesson_num`        int(10) unsigned                NOT NULL DEFAULT '0' COMMENT '总课时',
    `cover`             varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '课程封面图片路径',
    `buy_count`         bigint(10) unsigned             NOT NULL DEFAULT '0' COMMENT '销售数量',
    `view_count`        bigint(10) unsigned             NOT NULL DEFAULT '0' COMMENT '浏览数量',
    `version`           bigint(20) unsigned             NOT NULL DEFAULT '1' COMMENT '乐观锁',
    `status`            varchar(10)                     NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
    `is_deleted`        tinyint(3)                               DEFAULT NULL COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
    `gmt_create`        datetime                        NOT NULL COMMENT '创建时间',
    `gmt_modified`      datetime                        NOT NULL COMMENT '更新时间',
    KEY `idx_title` (`title`),
    KEY `idx_subject_id` (`subject_id`),
    KEY `idx_teacher_id` (`teacher_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='课程';

CREATE TABLE `edu_course_description`
(
    `id`           bigint AUTO_INCREMENT COMMENT '课程ID' PRIMARY KEY,
    `description`  text COMMENT '课程简介',
    `gmt_create`   datetime NOT NULL COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='课程简介';

CREATE TABLE `edu_chapter`
(
    `id`           bigint AUTO_INCREMENT COMMENT '章节ID' PRIMARY KEY,
    `course_id`    bigint           NOT NULL COMMENT '课程ID',
    `title`        varchar(50)      NOT NULL COMMENT '章节名称',
    `sort`         int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
    `gmt_create`   datetime         NOT NULL COMMENT '创建时间',
    `gmt_modified` datetime         NOT NULL COMMENT '更新时间',
    KEY `idx_course_id` (`course_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='课程';

CREATE TABLE `edu_video`
(
    `id`                  bigint AUTO_INCREMENT COMMENT '视频ID' PRIMARY KEy,
    `course_id`           bigint              NOT NULL COMMENT '课程ID',
    `chapter_id`          bigint              NOT NULL COMMENT '章节ID',
    `title`               varchar(50)         NOT NULL COMMENT '节点名称',
    `video_source_id`     varchar(100)                 DEFAULT NULL COMMENT '云端视频资源',
    `video_original_name` varchar(100)                 DEFAULT NULL COMMENT '原始文件名称',
    `sort`                int(10) unsigned    NOT NULL DEFAULT '0' COMMENT '排序字段',
    `play_count`          bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
    `is_free`             tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
    `duration`            float               NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
    `status`              varchar(20)         NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
    `size`                bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
    `version`             bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
    `gmt_create`          datetime            NOT NULL COMMENT '创建时间',
    `gmt_modified`        datetime            NOT NULL COMMENT '更新时间',
    KEY `idx_course_id` (`course_id`),
    KEY `idx_chapter_id` (`chapter_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='课程视频';