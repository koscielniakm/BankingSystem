CREATE TABLE `Client` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Client_Number` bigint(9) NOT NULL,
	`Password` varchar(64) NOT NULL,
	`Date_Open` DATETIME NOT NULL,
	`Date_Close` DATETIME,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Account` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Client_ID` bigint NOT NULL,
	`Account_Type_ID` int NOT NULL,
	`Amount` double NOT NULL,
	`Account_Number` bigint(26) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Account_Type` (
	`ID` bigint NOT NULL,
	`Type` varchar(20) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Authorizations` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Client_ID` bigint NOT NULL,
	`IP_Address` varchar(15) NOT NULL,
	`Result` bit(1) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Money_Transfer_Data` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Sender_Account_Number` bigint NOT NULL,
	`Sender_Name` bigint NOT NULL,
	`Recipient_Account_Number` bigint NOT NULL,
	`Recipient_Name` bigint NOT NULL,
	`Title` varchar(50) NOT NULL,
	`Amount` double NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Card` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Account_ID` bigint(9) NOT NULL,
	`Card_Type_ID` bigint NOT NULL,
	`Card_Number` int(9) NOT NULL,
	`Date_Active` DATETIME NOT NULL,
	`Date_Unactive` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Payment` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Card_ID` bigint NOT NULL,
	`Country` varchar(20) NOT NULL,
	`City` varchar(30) NOT NULL,
	`Address` varchar(40) NOT NULL,
	`Date` DATETIME NOT NULL,
	`Amount` double NOT NULL,
	`Title` varchar(30) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Card_Type` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Type` varchar(15) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Cyclical_Money_Transfer` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Account_ID` bigint NOT NULL,
	`Money_Transfer_Data_ID` bigint NOT NULL,
	`Date_Active` DATETIME NOT NULL,
	`Date_Delay` DATETIME NOT NULL,
	`Date_Unactive` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Incoming_Money_Transfer` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Account_ID` bigint NOT NULL,
	`Money_Transfer_Data_ID` bigint NOT NULL,
	`Date_Receive` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Outgoing_Money_Transfer` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Account_ID` bigint NOT NULL,
	`Money_Transfer_Data_ID` bigint NOT NULL,
	`Date_Send` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Document_Type` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Type` varchar(25) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Document` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Document_Type_ID` bigint NOT NULL,
	`Value` varchar(50) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Contact` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Contact_Type_ID` bigint NOT NULL,
	`Value` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Contact_Type` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Type` varchar(40) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Address` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Country` varchar(20) NOT NULL,
	`City` varchar(30) NOT NULL,
	`Address` varchar(40) NOT NULL,
	`Address_Type` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Address_Type` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Type` varchar(20) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Person` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`Client_ID` bigint NOT NULL,
	`First_Name` varchar(30) NOT NULL,
	`Last_Name` varchar(30) NOT NULL,
	`Default_Document` varchar(30) NOT NULL,
	`Default_Address` bigint NOT NULL,
	`Default_Contact` bigint NOT NULL,
	PRIMARY KEY (`ID`)
);

ALTER TABLE `Account` ADD CONSTRAINT `Account_fk0` FOREIGN KEY (`Client_ID`) REFERENCES `Client`(`ID`);

ALTER TABLE `Account` ADD CONSTRAINT `Account_fk1` FOREIGN KEY (`Account_Type_ID`) REFERENCES `Account_Type`(`ID`);

ALTER TABLE `Authorizations` ADD CONSTRAINT `Authorizations_fk0` FOREIGN KEY (`Client_ID`) REFERENCES `Client`(`ID`);

ALTER TABLE `Card` ADD CONSTRAINT `Card_fk0` FOREIGN KEY (`Account_ID`) REFERENCES `Account`(`ID`);

ALTER TABLE `Card` ADD CONSTRAINT `Card_fk1` FOREIGN KEY (`Card_Type_ID`) REFERENCES `Card_Type`(`ID`);

ALTER TABLE `Payment` ADD CONSTRAINT `Payment_fk0` FOREIGN KEY (`Card_ID`) REFERENCES `Card`(`ID`);

ALTER TABLE `Cyclical_Money_Transfer` ADD CONSTRAINT `Cyclical_Money_Transfer_fk0` FOREIGN KEY (`Account_ID`) REFERENCES `Account`(`ID`);

ALTER TABLE `Cyclical_Money_Transfer` ADD CONSTRAINT `Cyclical_Money_Transfer_fk1` FOREIGN KEY (`Money_Transfer_Data_ID`) REFERENCES `Money_Transfer_Data`(`ID`);

ALTER TABLE `Incoming_Money_Transfer` ADD CONSTRAINT `Incoming_Money_Transfer_fk0` FOREIGN KEY (`Account_ID`) REFERENCES `Account`(`ID`);

ALTER TABLE `Incoming_Money_Transfer` ADD CONSTRAINT `Incoming_Money_Transfer_fk1` FOREIGN KEY (`Money_Transfer_Data_ID`) REFERENCES `Money_Transfer_Data`(`ID`);

ALTER TABLE `Outgoing_Money_Transfer` ADD CONSTRAINT `Outgoing_Money_Transfer_fk0` FOREIGN KEY (`Account_ID`) REFERENCES `Account`(`ID`);

ALTER TABLE `Outgoing_Money_Transfer` ADD CONSTRAINT `Outgoing_Money_Transfer_fk1` FOREIGN KEY (`Money_Transfer_Data_ID`) REFERENCES `Money_Transfer_Data`(`ID`);

ALTER TABLE `Document` ADD CONSTRAINT `Document_fk0` FOREIGN KEY (`Document_Type_ID`) REFERENCES `Document_Type`(`ID`);

ALTER TABLE `Contact` ADD CONSTRAINT `Contact_fk0` FOREIGN KEY (`Contact_Type_ID`) REFERENCES `Contact_Type`(`ID`);

ALTER TABLE `Address` ADD CONSTRAINT `Address_fk0` FOREIGN KEY (`Address_Type`) REFERENCES `Address_Type`(`ID`);

ALTER TABLE `Person` ADD CONSTRAINT `Person_fk0` FOREIGN KEY (`Client_ID`) REFERENCES `Client`(`ID`);

ALTER TABLE `Person` ADD CONSTRAINT `Person_fk1` FOREIGN KEY (`Default_Document`) REFERENCES `Document`(`ID`);

ALTER TABLE `Person` ADD CONSTRAINT `Person_fk2` FOREIGN KEY (`Default_Address`) REFERENCES `Address`(`ID`);

ALTER TABLE `Person` ADD CONSTRAINT `Person_fk3` FOREIGN KEY (`Default_Contact`) REFERENCES `Contact`(`ID`);

