insert into CATEGORY (name) values ('Fantasy');
insert into CATEGORY (name) values ('Non-Fiction');
insert into CATEGORY (name) values ('Science');
insert into CATEGORY (name) values ('Sports');

insert into BOOK (CATEGORY_ID, ISBN, title, PRICE) values (2, '978-1-59420-009-0', 'Alexander Hamilton', 19.99);
insert into BOOK (CATEGORY_ID, ISBN, title, PRICE) values (1, '0-7475-3269-9', 'Harry Potter and the Philosophers Stone', 25.99);
insert into BOOK (CATEGORY_ID, ISBN, title, PRICE) values (3, '978-1-4398-8141-5', 'Data-Intensive Science', 70.25);
insert into BOOK (CATEGORY_ID, ISBN, title, PRICE) values (1, '0-7475-3849-2', 'Harry Potter and the Chamber of Secrets', 12.99);
insert into BOOK (CATEGORY_ID, ISBN, title, PRICE) values (4, '0-393-06123-X', 'The Blind Side: Evolution of a Game', 29.99);

insert into AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) values ('Ron', 'Chernow' , 'Ron Chernow is an American writer, journalist and biographer.');
insert into AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) values ('J. K.', 'Rowling', 'J. K. Rowling is a British author and philanthropist. She wrote Harry Potter.');
insert into AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) values ('Terence', 'Critchlow', 'Principal Technical Program Manager');
insert into AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) values ('Kerstin', 'Kleese van Dam', 'Director, Computational Science Initiative');
insert into AUTHOR (FIRST_NAME, LAST_NAME, DESCRIPTION) values ('Michael', 'Lewis', 'Michael Lewis is an American author and financial journalist.');

insert into AUTHOR_BOOK(AUTHOR_ID, BOOK_ID) values (1, 1);
insert into AUTHOR_BOOK(AUTHOR_ID, BOOK_ID) values (2, 2);
insert into AUTHOR_BOOK(AUTHOR_ID, BOOK_ID) values (2, 4);
insert into AUTHOR_BOOK(AUTHOR_ID, BOOK_ID) values (3, 3);
insert into AUTHOR_BOOK(AUTHOR_ID, BOOK_ID) values (4, 3);
insert into AUTHOR_BOOK(AUTHOR_ID, BOOK_ID) values (5, 5);
