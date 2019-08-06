SET DATABASE SQL SYNTAX ORA TRUE;

DROP TABLE usrslrpaymentprize  IF EXISTS;

create sequence SEQUSRSLRPAYMENTPRIZE;

CREATE TABLE usrslrpaymentprize
(
 id INTEGER identity primary key , 
idfactory DECIMAL , 
idbranches DECIMAL,   
iddepartment DECIMAL, 
snm VARCHAR(255), 
idkadr DECIMAL , 
idincome DECIMAL,
nmoney DECIMAL ,
nmoneyvichet DECIMAL ,
ntaxprc DECIMAL ,
ntaxmoney DECIMAL,
dperiod DATE,
dperiodfrom DATE,
dperiodfromuser DATE,
dfactpayed DATE,
dperiodtax DATE,
dpayofftax DATE,
dtimelimittax DATE,
sremark VARCHAR ( 255 ),
idcreator DECIMAL,
ideditor DECIMAL,
dcreatedatetime DATE,
deditdatetime DATE ) ;

CREATE INDEX usrslrpaymentprize_idx ON usrslrpaymentprize (id);

