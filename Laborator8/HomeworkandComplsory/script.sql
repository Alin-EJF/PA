DROP TABLE countries;
/
DROP TABLE continents;
/
DROP TABLE CITIES;
/

CREATE TABLE CITIES
(
  id NUMBER(3) PRIMARY KEY,
  country VARCHAR2(40) NOT NULL,
  name VARCHAR2(40) UNIQUE NOT NULL,
  latitude FLOAT,
  longitude FLOAT,
  capital CHAR(1)
  );
  

CREATE TABLE COUNTRIES
(
  id NUMBER(3) PRIMARY KEY ,
  name VARCHAR2(40) UNIQUE NOT NULL,
  code VARCHAR2(6),
  continent VARCHAR2(40) NOT NULL
  );



CREATE TABLE CONTINENTS
(
  id NUMBER(3) PRIMARY KEY,
  name VARCHAR2(40) UNIQUE NOT NULL
  );
  
/

COMMIT;