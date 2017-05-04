CREATE TABLE str_customer
  (
     customerid   VARCHAR2(20) NOT NULL PRIMARY KEY,
     customername VARCHAR2(50),
     gender       VARCHAR2(20),
     age          VARCHAR2(20),
     mobilenumber BIGINT,
     email        VARCHAR2(50),
     address      VARCHAR2(200)
  );

CREATE TABLE str_product
  (
     productid       VARCHAR2(20) NOT NULL PRIMARY KEY,
     productname     VARCHAR2(50),
     category        VARCHAR2(20),
     description     VARCHAR2(20),
     specifications  VARCHAR2(20),
     quantityinstock INTEGER,
     price           DOUBLE
  );

CREATE TABLE str_order
  (
     orderid      VARCHAR2(20) NOT NULL PRIMARY KEY,
     customerid   VARCHAR2(20),
          FOREIGN KEY(customerid) REFERENCES str_customer(customerid),
     orderdate    DATE,
     requireddate DATE,
     dispatchdate DATE,
     status       VARCHAR2(20)
  );

CREATE TABLE str_orderdetail
  (
     orderdetailid   VARCHAR2(20) NOT NULL PRIMARY KEY,
     orderid         VARCHAR2(50),
          FOREIGN KEY(orderid) REFERENCES str_order(orderid),
          productid       VARCHAR2(20),
          FOREIGN KEY(productid) REFERENCES str_product(productid),
     unitprice       DOUBLE,
     orderlinenumber INTEGER,
     quantity        INTEGER,
     discount        DOUBLE
  );

CREATE TABLE str_login
  (
     username VARCHAR2(20) NOT NULL PRIMARY KEY,
     password VARCHAR2(50),
     usertype VARCHAR2(20)
  );