select * from books;
select * from users;

select id from users;

select count(id) from users;
select count(distinct id) from users;

select * from users;

select count(*) from book_borrow;
select * from book_borrow;

select count(*) from book_borrow where is_returned = 0;

select name from book_categories;

select * from books where name='Clean Code';
select * from books where name='Clean Code' order by year;






