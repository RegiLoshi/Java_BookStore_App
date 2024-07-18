create database bookstore;

use bookstore;

CREATE TABLE User
(
  firstName varchar(30) NOT NULL,
  lastName varchar(30) NOT NULL,
  email varchar(30) NOT NULL,
  username varchar(30) NOT NULL,
  password varchar(30) NOT NULL,
  gender varchar(30) NOT NULL,
  Role varchar(30) NOT NULL,
  PRIMARY KEY (username),
  UNIQUE (email),
  UNIQUE (password)
);

CREATE TABLE Bill
(
  orderId INT NOT NULL auto_increment,
  date Date NOT NULL,
  username varchar(30) NOT NULL,
  PRIMARY KEY (orderId),
  FOREIGN KEY (username) REFERENCES User(username)
);

CREATE TABLE Book
(
  ISBN varchar(30) NOT NULL,
  name varchar(30) NOT NULL,
  author varchar(30) NOT NULL,
  category varchar(30) NOT NULL,
  supplier varchar(30) NOT NULL,
  description INT NOT NULL,
  bookURL INT NOT NULL,
  PRIMARY KEY (ISBN),
  UNIQUE (bookURL)
);

CREATE TABLE Author
(
  fullName varchar(30) NOT NULL,
  authorId INT NOT NULL auto_increment,
  PRIMARY KEY (authorId)
);

CREATE TABLE Supplier
(
  SupplierId INT NOT NULL auto_increment,
  name varchar(30) NOT NULL,
  email varchar(30) NOT NULL,
  phoneNumber INT,
  PRIMARY KEY (SupplierId),
  UNIQUE (email)
);

CREATE TABLE hasWritten
(
  ISBN varchar(30) NOT NULL,
  authorId INT NOT NULL,
  PRIMARY KEY (ISBN, authorId),
  FOREIGN KEY (ISBN) REFERENCES Book(ISBN),
  FOREIGN KEY (authorId) REFERENCES Author(authorId)
);

CREATE TABLE supplies
(
  SupplierId INT NOT NULL,
  ISBN varchar(30) NOT NULL,
  PRIMARY KEY (SupplierId, ISBN),
  FOREIGN KEY (SupplierId) REFERENCES Supplier(SupplierId),
  FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);

CREATE TABLE SoldBookType
(
  amount INT NOT NULL,
  soldBooksID INT NOT NULL auto_increment,
  soldQuantity INT NOT NULL,
  orderId INT NOT NULL,
  ISBN varchar(30) NOT NULL,
  PRIMARY KEY (soldBooksID),
  FOREIGN KEY (orderId) REFERENCES Bill(orderId),
  FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);

insert into user(firstName,lastName,email,username,password,gender,Role) values 
('admin','admin','admin@gmail.com','admin','admin','male','admin');

select * from user;