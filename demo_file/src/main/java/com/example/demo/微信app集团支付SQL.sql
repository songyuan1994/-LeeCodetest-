
--新建表，用于存储所有的非app支付的类型
CREATE TABLE `pay_payMethod_parm_configs` (
   `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id of the record',
   `biz_system_id` BIGINT(20) DEFAULT NULL,
   `account_code` VARCHAR(64) DEFAULT NULL,
   `payment_type` INT(11) NOT NULL,
   `payment_config` TEXT,
   `payment_config_version` INT(11) NOT NULL DEFAULT '0',
   PRIMARY KEY (`id`),
   UNIQUE KEY `u_pay_payMethod_parm_configs` (`account_code`,`payment_type`),
   KEY `i_pay_payMethod_app_id` (`account_code`)
 ) ENGINE=INNODB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4
 
 
 
UPDATE pay_client_app_configs SET payment_config='{\"subAppId\":\"wx15eb1e9ad9d57bda\",\"subMchId\":\"392584053114937\",\"vspCusid\":\"55158405311N403\"}',payment_type='26' WHERE account_code='NS2'; 
UPDATE pay_client_app_configs SET payment_config='{\"subAppId\":\"wx3644e68cba2175ea\",\"subMchId\":\"392584053114937\",\"vspCusid\":\"55158405311N490\"}',payment_type='26' WHERE account_code='NS999959';
INSERT INTO `pay_client_app_configs` (`id`, `biz_system_id`, `account_code`, `client_app_id`, `payment_type`, `payment_config`, `payment_config_version`) VALUES('32','10','NS999952','50','26','{\"subAppId\":\"wx506106ae56d9d16f\",\"subMchId\":\"392584053114937\",\"vspCusid\":\"55158405311N497\"}','0');
UPDATE pay_client_app_configs SET payment_config='{\"subAppId\":\"wx05b55ee9a2710399\",\"subMchId\":\"392584053114937\",\"vspCusid\":\"55158405311N483\"}',payment_type='26' WHERE account_code='NS999948';
INSERT INTO `pay_client_app_configs` (`id`, `biz_system_id`, `account_code`, `client_app_id`, `payment_type`, `payment_config`, `payment_config_version`) VALUES('33','10','NS999963','69','26','{\"subAppId\":\"wxac66ec2118f9f51f\",\"subMchId\":\"392584053114937\",\"vspCusid\":\"55158405311N48V\"}','0');
