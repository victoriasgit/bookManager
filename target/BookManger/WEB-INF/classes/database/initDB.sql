create table books
(
	book_id serial not null
		constraint books_pkey
			primary key,
	book_title varchar(255) not null,
	book_price integer not null,
	author_id varchar(30) not null
);

