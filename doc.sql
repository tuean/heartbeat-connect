
create database hb;

use hb;

create table if not exists `heart_beat` (
    `id` int(10) unsigned not null auto_increment comment 'id',
    `app_version` varchar(100) null comment '设备版本号',
    `cid` varchar(200) null comment '设备标识号',
    `seq` bigint(20) null,
    `uptime` bigint(20) null,
    `type` int(10) null,
    primary key(`id`)
)Engine=InnoDB comment '心跳记录表' default charset=utf8mb4;