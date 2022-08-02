select * from books;

select bc.name, count(*) from book_borrow
inner join books b on book_borrow.book_id = b.id inner join book_categories bc on b.book_category_id = bc.id group by bc.name order by 2 desc;










