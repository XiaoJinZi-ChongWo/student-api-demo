CREATE TABLE `stu_information` (
  `stu_id` varchar(100) NOT NULL COMMENT 'ѧ��id',
  `stu_name` varchar(10) NOT NULL COMMENT 'ѧ������',
  `stu_sex` int(11) NOT NULL COMMENT 'ѧ���Ա�0��ʾ�У�1��ʾŮ',
  `stu_age` int(11) NOT NULL COMMENT 'ѧ������',
  `stu_magor` varchar(100) NOT NULL COMMENT 'רҵ',
  `stu_grade` int(11) NOT NULL COMMENT '�꼶',
  `stu_department` varchar(100) NOT NULL COMMENT 'Ժϵ',
  `stu_class` varchar(100) NOT NULL COMMENT '�༶',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='ѧ����Ϣ��';