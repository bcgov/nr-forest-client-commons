-- 00000001 James Baxter, Doing Business and Location

INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE,BIRTHDATE,CLIENT_ID_TYPE_CODE,CLIENT_IDENTIFICATION,REGISTRY_COMPANY_TYPE_CODE,CORP_REGN_NMBR,CLIENT_ACRONYM,WCB_FIRM_NUMBER,OCG_SUPPLIER_NMBR,CLIENT_COMMENT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,REVISION_COUNT) VALUES
('00000001','BAXTER','JAMES',NULL,'ACT','I',TIMESTAMP'1959-05-18 00:00:00.0','BCDL',NULL,NULL,'00000001',NULL,NULL,NULL,'Il.',TIMESTAMP'1989-11-26 08:52:38.0','CONV',70,TIMESTAMP'1999-02-16 10:40:05.0','JDOH',70,1) ;

INSERT INTO THE.CLIENT_DOING_BUSINESS_AS (CLIENT_DBA_ID,CLIENT_NUMBER,DOING_BUSINESS_AS_NAME,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
(1,'00000001','BAXTER''S FAMILY',TIMESTAMP'2007-04-24 12:21:47.0','IDIR\ITISWATTLES',70,TIMESTAMP'2007-04-24 12:21:47.0','IDIR\ITISWATTLES',70,1);

INSERT INTO THE.CLIENT_LOCATION (CLIENT_NUMBER,CLIENT_LOCN_CODE,CLIENT_LOCN_NAME,HDBS_COMPANY_CODE,ADDRESS_1,ADDRESS_2,ADDRESS_3,CITY,PROVINCE,POSTAL_CODE,COUNTRY,BUSINESS_PHONE,HOME_PHONE,CELL_PHONE,FAX_NUMBER,EMAIL_ADDRESS,LOCN_EXPIRED_IND,RETURNED_MAIL_DATE,TRUST_LOCATION_IND,CLI_LOCN_COMMENT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
('00000001','00',NULL,'01382','2080 Labieux Rd',NULL,NULL,'NANAIMO','BC','V9T6J9','CANADA',NULL,'8006618773',NULL,NULL,NULL,'N',NULL,'N',NULL,TIMESTAMP'2002-03-22 15:52:03.0','JBAXTER',27,TIMESTAMP'1989-11-26 08:52:09.0','CONV',70,1);

-- 00000002 Doug Funny, Doing Buseness and Location

INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE,BIRTHDATE,CLIENT_ID_TYPE_CODE,CLIENT_IDENTIFICATION,REGISTRY_COMPANY_TYPE_CODE,CORP_REGN_NMBR,CLIENT_ACRONYM,WCB_FIRM_NUMBER,OCG_SUPPLIER_NMBR,CLIENT_COMMENT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,REVISION_COUNT) VALUES
('00000002','FUNNY','THOMAS','Yansi','ACT','I',TIMESTAMP'1939-07-04 00:00:00.0','BCDL','Wull.',NULL,'00000002',NULL,NULL,NULL,'C v.',TIMESTAMP'1989-11-26 08:52:38.0','CONV',70,TIMESTAMP'2000-08-24 15:59:37.0','PLOUSY',70,1);

INSERT INTO THE.CLIENT_DOING_BUSINESS_AS (CLIENT_DBA_ID,CLIENT_NUMBER,DOING_BUSINESS_AS_NAME,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
(2,'00000002','DOUG FUNNY',TIMESTAMP'2007-04-24 12:21:47.0','IDIR\ITISWATTLES',70,TIMESTAMP'2007-04-24 12:21:47.0','IDIR\ITISWATTLES',70,1);

INSERT INTO THE.CLIENT_LOCATION (CLIENT_NUMBER,CLIENT_LOCN_CODE,CLIENT_LOCN_NAME,HDBS_COMPANY_CODE,ADDRESS_1,ADDRESS_2,ADDRESS_3,CITY,PROVINCE,POSTAL_CODE,COUNTRY,BUSINESS_PHONE,HOME_PHONE,CELL_PHONE,FAX_NUMBER,EMAIL_ADDRESS,LOCN_EXPIRED_IND,RETURNED_MAIL_DATE,TRUST_LOCATION_IND,CLI_LOCN_COMMENT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
('00000002','00',NULL,'01384','Government St','Floor 2',NULL,'VICTORIA','BC','V8V2L8','CANADA',NULL,NULL,NULL,NULL,NULL,'N',NULL,'N',NULL,TIMESTAMP'1991-11-20 13:15:01.0','JBAXTER',64,TIMESTAMP'1989-11-26 08:52:09.0','CONV',70,1);

-- 00000003 Boris and Boris, Doing Business and Location

INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE,BIRTHDATE,CLIENT_ID_TYPE_CODE,CLIENT_IDENTIFICATION,REGISTRY_COMPANY_TYPE_CODE,CORP_REGN_NMBR,CLIENT_ACRONYM,WCB_FIRM_NUMBER,OCG_SUPPLIER_NMBR,CLIENT_COMMENT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,REVISION_COUNT) VALUES
('00000003','BORIS AND BORIS INC.',NULL,NULL,'ACT','C',NULL,'BCDL',NULL,NULL,'00000003',NULL,NULL,NULL,NULL,TIMESTAMP'1989-11-26 08:52:38.0','CONV',70,TIMESTAMP'1989-11-26 08:52:38.0','CLIENT_REWRITE_CONV',70,1);

INSERT INTO THE.CLIENT_DOING_BUSINESS_AS (CLIENT_DBA_ID,CLIENT_NUMBER,DOING_BUSINESS_AS_NAME,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
(3,'00000003','BORIS AND BORIS INC.',TIMESTAMP'2007-04-24 12:21:47.0','IDIR\ITISWATTLES',70,TIMESTAMP'2007-04-24 12:21:47.0','IDIR\ITISWATTLES',70,1);

INSERT INTO THE.CLIENT_LOCATION (CLIENT_NUMBER,CLIENT_LOCN_CODE,CLIENT_LOCN_NAME,HDBS_COMPANY_CODE,ADDRESS_1,ADDRESS_2,ADDRESS_3,CITY,PROVINCE,POSTAL_CODE,COUNTRY,BUSINESS_PHONE,HOME_PHONE,CELL_PHONE,FAX_NUMBER,EMAIL_ADDRESS,LOCN_EXPIRED_IND,RETURNED_MAIL_DATE,TRUST_LOCATION_IND,CLI_LOCN_COMMENT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
('00000003','00',NULL,'01385','1950 Douglas St',NULL,NULL,'VICTORIA','BC','V8W1Z2','CANADA',NULL,NULL,NULL,NULL,NULL,'N',NULL,'N',NULL,TIMESTAMP'1999-05-04 09:30:11.0','JBAXTER',70,TIMESTAMP'1989-11-26 08:52:09.0','CONV',70,1);

-- 00000004 Indian Band, Multiple Locations

INSERT INTO THE.FOREST_CLIENT (CLIENT_NUMBER,CLIENT_NAME,LEGAL_FIRST_NAME,LEGAL_MIDDLE_NAME,CLIENT_STATUS_CODE,CLIENT_TYPE_CODE,BIRTHDATE,CLIENT_ID_TYPE_CODE,CLIENT_IDENTIFICATION,REGISTRY_COMPANY_TYPE_CODE,CORP_REGN_NMBR,CLIENT_ACRONYM,WCB_FIRM_NUMBER,OCG_SUPPLIER_NMBR,CLIENT_COMMENT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,REVISION_COUNT) VALUES
('00000004','SAMPLE INDIAN BAND COUNCIL',NULL,NULL,'ACT','B',NULL,NULL,NULL,'DINA','684','SAMPLIBC',236967,NULL,NULL,TIMESTAMP'1989-11-26 08:52:38.0','CONV',70,TIMESTAMP'1989-11-26 08:52:38.0','IDIR\ITISWATTLES',70,1);

INSERT INTO THE.CLIENT_LOCATION (CLIENT_NUMBER,CLIENT_LOCN_CODE,CLIENT_LOCN_NAME,HDBS_COMPANY_CODE,ADDRESS_1,ADDRESS_2,ADDRESS_3,CITY,PROVINCE,POSTAL_CODE,COUNTRY,BUSINESS_PHONE,HOME_PHONE,CELL_PHONE,FAX_NUMBER,EMAIL_ADDRESS,LOCN_EXPIRED_IND,RETURNED_MAIL_DATE,TRUST_LOCATION_IND,CLI_LOCN_COMMENT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
('00000004','00',NULL,'26573','PO BOX 999',NULL,NULL,'VICTORIA','BC','V8W1M0','CANADA',NULL,'2502502550',NULL,'2502502550',NULL,'N',NULL,'N',NULL,TIMESTAMP'2002-03-05 10:01:05.0','JBAXTER',21,TIMESTAMP'1989-11-26 12:20:50.0','CONV',70,1);
INSERT INTO THE.CLIENT_LOCATION (CLIENT_NUMBER,CLIENT_LOCN_CODE,CLIENT_LOCN_NAME,HDBS_COMPANY_CODE,ADDRESS_1,ADDRESS_2,ADDRESS_3,CITY,PROVINCE,POSTAL_CODE,COUNTRY,BUSINESS_PHONE,HOME_PHONE,CELL_PHONE,FAX_NUMBER,EMAIL_ADDRESS,LOCN_EXPIRED_IND,RETURNED_MAIL_DATE,TRUST_LOCATION_IND,CLI_LOCN_COMMENT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
('00000004','01','BAND OFFICE','D3475','INDIAN BAND','916-1150 MAINLAND ST',NULL,'VANCOUVER','BC','V6B2T4','CANADA','2505205200',NULL,NULL,'2505205200',NULL,'N',NULL,'N','THIS LOCATION IS ONLY FOR THE AGREEMENT SIGNAGE',TIMESTAMP'2006-04-03 15:01:44.0','itiswattles',70,TIMESTAMP'2001-01-25 14:08:42.0','ITISWATTLES',3,1);
INSERT INTO THE.CLIENT_LOCATION (CLIENT_NUMBER,CLIENT_LOCN_CODE,CLIENT_LOCN_NAME,HDBS_COMPANY_CODE,ADDRESS_1,ADDRESS_2,ADDRESS_3,CITY,PROVINCE,POSTAL_CODE,COUNTRY,BUSINESS_PHONE,HOME_PHONE,CELL_PHONE,FAX_NUMBER,EMAIL_ADDRESS,LOCN_EXPIRED_IND,RETURNED_MAIL_DATE,TRUST_LOCATION_IND,CLI_LOCN_COMMENT,UPDATE_TIMESTAMP,UPDATE_USERID,UPDATE_ORG_UNIT,ADD_TIMESTAMP,ADD_USERID,ADD_ORG_UNIT,REVISION_COUNT) VALUES
('00000004','02','TRUST ACCOUNT  -RSI','T1350','PO BOX 588',NULL,NULL,'CHASE','BC','V0E1M0','CANADA',NULL,'2502502550',NULL,'2502502550',NULL,'Y',NULL,'Y','TRUST ACCOUNT  - RSI',TIMESTAMP'2005-10-06 15:02:02.0','NEGELY',1834,TIMESTAMP'9999-12-31 00:00:00.0','CONVSNT',70,1);

-- 00000005 Erna Krakowsky

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000005', 'KRAKOWSKY', 'ERNA', NULL, 'ACT', 'I', NULL, NULL, NULL, 'DINA', '684', 'SAMPLIBC', '236967', NULL, NULL, TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '1989-11-26 08:52:38.000000', 'IDIR\ITISWATTLES', 70, 1);

-- 00000006 Indian Canada, Doing Business, Multiple Locations, Org Unit, Contact

INSERT INTO "THE"."FOREST_CLIENT"
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000006', 'INDIAN CANADA', NULL, NULL, 'ACT', 'G', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, TIMESTAMP '1989-11-26 08:54:15.000000', 'CONV', 70, TIMESTAMP '2001-09-28 11:04:30.000000', 'IDIR\ITISWATTLES', 70, 1);

INSERT INTO "THE"."CLIENT_LOCATION"
(CLIENT_NUMBER, CLIENT_LOCN_CODE, CLIENT_LOCN_NAME, HDBS_COMPANY_CODE, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PROVINCE, POSTAL_CODE, COUNTRY, BUSINESS_PHONE, HOME_PHONE, CELL_PHONE, FAX_NUMBER, EMAIL_ADDRESS, LOCN_EXPIRED_IND, RETURNED_MAIL_DATE, TRUST_LOCATION_IND, CLI_LOCN_COMMENT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, REVISION_COUNT)
VALUES('00000006', '00', 'MAILING ADDRESS', '04106', '300 - 1550 ALBERNI STREET', NULL, NULL, 'VANCOUVER', 'BC', 'V6G3C5', 'CANADA', NULL, NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, TIMESTAMP '1990-06-20 10:51:17.000000', 'IDIR\ITISWATTLES', 62, TIMESTAMP '1989-11-26 08:54:15.000000', 'IDIR\ITISWATTLES', 70, 1);
INSERT INTO "THE"."CLIENT_LOCATION"
(CLIENT_NUMBER, CLIENT_LOCN_CODE, CLIENT_LOCN_NAME, HDBS_COMPANY_CODE, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PROVINCE, POSTAL_CODE, COUNTRY, BUSINESS_PHONE, HOME_PHONE, CELL_PHONE, FAX_NUMBER, EMAIL_ADDRESS, LOCN_EXPIRED_IND, RETURNED_MAIL_DATE, TRUST_LOCATION_IND, CLI_LOCN_COMMENT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, REVISION_COUNT)
VALUES('00000006', '01', 'TERRACE/LAKALZAP BAND', '05050', '600 1138 MELVILLE ST', NULL, NULL, 'VANCOUVER', 'BC', 'V6E4S3', 'CANADA', '6046666755', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, TIMESTAMP '2001-04-25 13:47:53.000000', 'IDIR\ITISWATTLES', 70, TIMESTAMP '1990-08-27 13:25:25.000000', 'IDIR\ITISWATTLES', 62, 1);
INSERT INTO "THE"."CLIENT_LOCATION"
(CLIENT_NUMBER, CLIENT_LOCN_CODE, CLIENT_LOCN_NAME, HDBS_COMPANY_CODE, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PROVINCE, POSTAL_CODE, COUNTRY, BUSINESS_PHONE, HOME_PHONE, CELL_PHONE, FAX_NUMBER, EMAIL_ADDRESS, LOCN_EXPIRED_IND, RETURNED_MAIL_DATE, TRUST_LOCATION_IND, CLI_LOCN_COMMENT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, REVISION_COUNT)
VALUES('00000006', '02', NULL, '05893', '209 280 VICTORIA STREET', NULL, NULL, 'PRINCE GEORGE', 'BC', 'V2L4X3', 'CANADA', '2505615121', NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, TIMESTAMP '1999-03-24 15:00:18.000000', 'IDIR\ITISWATTLES', 70, TIMESTAMP '1990-08-27 13:26:46.000000', 'IDIR\ITISWATTLES', 62, 1);
INSERT INTO "THE"."CLIENT_LOCATION"
(CLIENT_NUMBER, CLIENT_LOCN_CODE, CLIENT_LOCN_NAME, HDBS_COMPANY_CODE, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PROVINCE, POSTAL_CODE, COUNTRY, BUSINESS_PHONE, HOME_PHONE, CELL_PHONE, FAX_NUMBER, EMAIL_ADDRESS, LOCN_EXPIRED_IND, RETURNED_MAIL_DATE, TRUST_LOCATION_IND, CLI_LOCN_COMMENT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, REVISION_COUNT)
VALUES('00000006', '03', 'SHUSWAP BAND OFFICE', '06901', 'SHUSWAP BAND OFFICE', 'PO BOX 790', NULL, 'INVERMERE', 'BC', 'V0A1K0', 'CANADA', NULL, NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, TIMESTAMP '1999-03-24 15:00:34.000000', 'IDIR\ITISWATTLES', 70, TIMESTAMP '1990-08-27 13:27:57.000000', 'IDIR\ITISWATTLES', 62, 1);

INSERT INTO "THE"."ORG_UNIT"
(ORG_UNIT_NO, ORG_UNIT_CODE, ORG_UNIT_NAME, LOCATION_CODE, AREA_CODE, TELEPHONE_NO, ORG_LEVEL_CODE, OFFICE_NAME_CODE, ROLLUP_REGION_NO, ROLLUP_REGION_CODE, ROLLUP_DIST_NO, ROLLUP_DIST_CODE, EFFECTIVE_DATE, EXPIRY_DATE, UPDATE_TIMESTAMP)
VALUES(1, 'RVA', 'OBSOLETE - Vancouver Forest Region (RCO)', '043', '250', '7517001', 'R', 'VA', 1835, 'RCO', 1, 'RVA', TIMESTAMP '1905-01-01 00:00:00.000000', TIMESTAMP '2003-03-31 00:00:00.000000', TIMESTAMP '2003-05-27 15:58:49.000000');

INSERT INTO "THE"."CLIENT_CONTACT"
(CLIENT_CONTACT_ID, CLIENT_NUMBER, CLIENT_LOCN_CODE, BUS_CONTACT_CODE, CONTACT_NAME, BUSINESS_PHONE, CELL_PHONE, FAX_NUMBER, EMAIL_ADDRESS, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, REVISION_COUNT)
VALUES(1717, '00000006', '00', 'BL', 'JASON MOMOA', '6046666755', NULL, NULL, NULL, TIMESTAMP '1993-03-26 17:40:15.000000', 'IDIR\ITISWATTLES', 1, TIMESTAMP '1993-03-26 17:40:15.000000', 'IDIR\ITISWATTLES', 1, 1);
INSERT INTO "THE"."CLIENT_CONTACT"
(CLIENT_CONTACT_ID, CLIENT_NUMBER, CLIENT_LOCN_CODE, BUS_CONTACT_CODE, CONTACT_NAME, BUSINESS_PHONE, CELL_PHONE, FAX_NUMBER, EMAIL_ADDRESS, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, REVISION_COUNT)
VALUES(1718, '00000006', '00', 'TN', 'NEDAD KONTIC', '6046666755', NULL, NULL, NULL, TIMESTAMP '1993-03-26 17:37:29.000000', 'IDIR\ITISWATTLES', 1, TIMESTAMP '1993-03-26 17:37:29.000000', 'IDIR\ITISWATTLES', 1, 1);

-- 00000007 James Bond

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000007', 'bond', 'james', 'bond', 'ACT', 'I', TIMESTAMP '1939-07-04 00:00:00.000000', 'BCDL', 'Wull.', NULL, '00000007', NULL, NULL, NULL, 'C v.', TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '2000-08-24 15:59:37.000000', 'PLOUSY', 70, 1);

-- 00000008 James Hunt HUnt

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000008', 'hunt', 'james', 'hunt', 'ACT', 'I', NULL, NULL, NULL, 'DINA', '684', 'SAMPLIBC', '236967', NULL, NULL, TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '1989-11-26 08:52:38.000000', 'IDIR\ITISWATTLES', 70, 1);

-- 00000009 James Hunt

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000009', 'james', NULL, 'hunt', 'ACT', 'I', NULL, NULL, NULL, 'DINA', '684', 'SAMPLIBC', '236967', NULL, NULL, TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '1989-11-26 08:52:38.000000', 'IDIR\ITISWATTLES', 70, 1);

-- 00000010 Jjamess Bbondd

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000010', 'bbondd', 'jjamess', 'bbondd', 'ACT', 'A', NULL, NULL, NULL, 'DINA', '684', 'SAMPLIBC', '236967', NULL, NULL, TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '1989-11-26 08:52:38.000000', 'IDIR\ITISWATTLES', 70, 1);

-- 00000011 CORP. OF THE CITY OF VICTORIA

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000011', 'CORP. OF THE CITY OF VICTORIA', NULL, NULL, 'ACT', 'G', NULL, NULL, NULL, 'DINA', '684', 'SAMPLIBC', '236967', NULL, NULL, TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '1989-11-26 08:52:38.000000', 'IDIR\ITISWATTLES', 70, 1);

-- 00000012 Sampler FOREST PRODUCTS INC

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000012', 'SAMPLER FOREST PRODUCTS INC.', NULL, NULL, 'ACT', 'U', NULL, NULL, NULL, 'DINA', '684', 'SAMPLIBC', '236967', NULL, NULL, TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '1989-11-26 08:52:38.000000', 'IDIR\ITISWATTLES', 70, 1);

-- 00000013 DOREEN FOREST PRODUCTS LTD

INSERT INTO THE.FOREST_CLIENT
(CLIENT_NUMBER, CLIENT_NAME, LEGAL_FIRST_NAME, LEGAL_MIDDLE_NAME, CLIENT_STATUS_CODE, CLIENT_TYPE_CODE, BIRTHDATE, CLIENT_ID_TYPE_CODE, CLIENT_IDENTIFICATION, REGISTRY_COMPANY_TYPE_CODE, CORP_REGN_NMBR, CLIENT_ACRONYM, WCB_FIRM_NUMBER, OCG_SUPPLIER_NMBR, CLIENT_COMMENT, ADD_TIMESTAMP, ADD_USERID, ADD_ORG_UNIT, UPDATE_TIMESTAMP, UPDATE_USERID, UPDATE_ORG_UNIT, REVISION_COUNT)
VALUES('00000013', 'DOREEN FOREST PRODUCTS LTD.', NULL, NULL, 'ACT', 'C', NULL, NULL, NULL, 'DINA', '684', 'SAMPLIBC', '236967', NULL, NULL, TIMESTAMP '1989-11-26 08:52:38.000000', 'CONV', 70, TIMESTAMP '1989-11-26 08:52:38.000000', 'IDIR\ITISWATTLES', 70, 1);
