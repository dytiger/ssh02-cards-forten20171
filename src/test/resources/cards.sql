
DROP TABLE IF EXISTS `cards`;

CREATE TABLE `cards` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '100.00',
  `type` char(2) NOT NULL DEFAULT 'TI' COMMENT 'TI:计次卡 DC:折扣卡',
  `times` int(5) unsigned NOT NULL DEFAULT '0',
  `discount` double(10,2) unsigned NOT NULL DEFAULT '10.00',
  `status` char(2) NOT NULL DEFAULT 'SU' COMMENT 'SU:启用 BU:停用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

