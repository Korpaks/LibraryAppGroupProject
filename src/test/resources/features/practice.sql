select * from books;
select * from users;

select !distinct from users;

select full_name,b.name,bb.borrowed_date from users u
inner join book_borrow bb on u.id = bb.user_id
inner join books b on bb.book_id = b.id
where full_name='Test Student 1' and name='Waiting for the Barbarians'
and is_returned=0 order by 3 desc ;

select b.name,bb.borrowed_date from users u                             inner join book_borrow bb on u.id = bb.user_id
                                                  inner join books b on bb.book_id = b.id
where is_returned=1 and full_name='Test Student 1' and name='Waiting for the Barbarians';

select full_name,b.name,bb.borrowed_date from users u
                                                  inner join book_borrow bb on u.id = bb.user_id
                                                  inner join books b on bb.book_id = b.id;

select * from book_borrow bb inner join books b on bb.book_id = b.id;
