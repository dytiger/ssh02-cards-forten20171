
DROP TABLE IF EXISTS `cards`;

CREATE TABLE `cards` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '100.00',
  `type` char(2) NOT NULL DEFAULT 'TI' COMMENT 'TI:计次卡 DC:折扣卡',
  `times` int(5) unsigned NOT NULL DEFAULT '0',
  `discount` double(10,2) unsigned NOT NULL DEFAULT '1.00',
  `status` char(2) NOT NULL DEFAULT 'SU' COMMENT 'SU:启用 BU:停用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cards (id,name,price,type,times,status) VALUES
(1,'青铜卡',100,'TI',6,'SU'),
(2,'白银卡',300,'TI',20,'SU'),
(3,'黄金卡',500,'TI',36,'SU'),
(4,'青铜卡',100,'TI',8,'BU'),
(5,'黄金卡',100,'TI',10,'BU');

INSERT INTO cards (id,name,price,type,discount,status) VALUES
(6,'兰叶卡',300,'DC',0.95,'SU'),
(7,'梅花卡',500,'DC',0.9,'SU'),
(8,'菊芳卡',1000,'DC',0.85,'SU'),
(9,'梅花卡',100,'DC',0.8,'BU'),
(10,'梅花卡',100,'DC',0.7,'BU');