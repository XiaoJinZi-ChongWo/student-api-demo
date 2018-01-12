CREATE TABLE `stu_information` (
  `stu_id` varchar(100) NOT NULL COMMENT '学生id',
  `stu_name` varchar(10) NOT NULL COMMENT '学生姓名',
  `stu_sex` int(11) NOT NULL COMMENT '学生性别，0表示男，1表示女',
  `stu_age` int(11) NOT NULL COMMENT '学生年龄',
  `stu_magor` varchar(100) NOT NULL COMMENT '专业',
  `stu_grade` int(11) NOT NULL COMMENT '年级',
  `stu_department` varchar(100) NOT NULL COMMENT '院系',
  `stu_class` varchar(100) NOT NULL COMMENT '班级',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';