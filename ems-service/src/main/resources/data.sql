INSERT INTO EMSTOGGLE (ID,DESCRIPTION,EMS_ID,MODIFIED_TIME,EMS_HEADEND_PORT,HEADEND_ID,STATUS,TOGGLE_CODE)
VALUES (1,'Supported Operation','EMS_121',NOW(),'/shelf=1/slot=11/port=11','BAAGIO','On','GTC_TOGGLE_0000'),
(2,'Supported Operation','EMS_122',NOW(),'/shelf=1/slot=11/port=12','BABGIO','Off','GTC_TOGGLE_0001'),
(3,'unsupported Operation','EMS_123',NOW(),'/shelf=1/slot=11/port=13','BACGIO','On','GTC_TOGGLE_0002'),
(4,'unsupported Operation','EMS_124',NOW(),'/shelf=1/slot=11/port=14','BADGIO','Off','GTC_TOGGLE_0003'),
(5,'Supported Operation','EMS_125',NOW(),'/shelf=1/slot=11/port=15','BBAGIO','On','GTC_TOGGLE_0004'),
(6,'Supported Operation','EMS_126',NOW(),'/shelf=1/slot=11/port=16','BBBGIO','Off','GTC_TOGGLE_0005'),
(7,'Supported Operation','EMS_127',NOW(),'/shelf=1/slot=11/port=17','BBCGIO','On','GTC_TOGGLE_0000'),
(8,'Supported Operation','EMS_128',NOW(),'/shelf=1/slot=11/port=18','BBDGIO','Off','GTC_TOGGLE_0001');