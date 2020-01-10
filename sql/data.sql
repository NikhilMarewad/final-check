-- Include table data insertion, updation, deletion and select scripts
-- -----------------------------------------------------------------------------
----------------------------- MovieCruiser -------------------------------------
--------------------------------------------------------------------------------


-- -------------------- MovieCruiser.movie_item---------------------------------
-------------- Showing Empty Records of movie_item table  ----------------------
--------------------------------------------------------------------------------
select * from movie_item;

----------------- Inserting Records to movie_item table  -----------------------
--------------------------------------------------------------------------------
insert into movie_item values
(1, 'Avatar',2787965087,'Yes','2017-03-15','Science Fiction', 'Yes'),

(2, 'The Avengers',1518812988,'Yes','2017-12-23','Superhero','No'),

(3,'Titanic',2187463944,'Yes','2017-08-21','Science Romance','No'),

(4, 'Jurassic World',1671731208,'No','2017-07-02', 'Science Fiction', 'Yes'),

(5, 'Avengers:End Game',2750760348,'Yes','2022-11-22','Superhero','No');

-------------- Showing Inserted Records of movie_item table  ------------------------
--------------------------------------------------------------------------------
select * from movie_item;

----------- Showing One Record before updating from movie_item table  ----------
--------------------------------------------------------------------------------
select 
 mo_id,
 mo_title,
 mo_box_office,
 mo_active,
 mo_date_of_launch,
 mo_genre,
 mo_has_teaser 
 from movie_item
 where mo_id=1;

-------------- updating One Record from movie_item table  -----------------------
--------------------------------------------------------------------------------
update movie_item 
 set 
 mo_title='Lord Of Rings',
 mo_box_office=1724424449,
 mo_active='Yes',
 mo_date_of_launch='2001-12-19',
 mo_genre='Science Fiction',
 mo_has_teaser='Yes' 
 where mo_id=1;

-------- Showing One Record after updating from movie_item table  -------------
--------------------------------------------------------------------------------
select 
 mo_id,
 mo_title,
 mo_box_office,
 mo_active,
 mo_date_of_launch,
 mo_genre,
 mo_has_teaser 
 from movie_item 
 where mo_id=1;

-------------- Showing Updated Records from movie_item table  ------------------
--------------------------------------------------------------------------------
select * from movie_item;
--------------------------------------------------------------------------------



----------------------- MovieCruiser.movie_item---------------------------------
----------------------- Showing Records of Customer Detials --------------------
--------------------------------------------------------------------------------
select 
 mo_title,
 mo_box_office,
 mo_genre,
 mo_has_teaser
 from movie_item 
 where mo_active='yes'
 and mo_date_of_launch<current_date(); 
--------------------------------------------------------------------------------



-- -------------------- MovieCruiser.user---------------------------------------
-------------- Showing Empty Records of user table  ----------------------------
--------------------------------------------------------------------------------
select * from user;

----------------- Inserting Records to user table  ----------------------------
-------------------------------------------------------------------------------
insert into user values
(101,'Justin Bieber'),
(102,'Jason Statham'),
(103,'Jhonny Depp'),
(104,'Justin Bieber');

-------------- Showing Inserted Records of user Table---------------------------
--------------------------------------------------------------------------------
select * from user;

--------------------------------------------------------------------------------




-- -------------------- MovieCruiser.favorites----------------------------------
-------------- Showing Empty Records of favorites table  -----------------------
--------------------------------------------------------------------------------
select * from favorites;

----------------- Inserting Records to favorites table  ------------------------
--------------------------------------------------------------------------------
insert into favorites values
(1,101,1),
(2,102,2),
(3,103,3),
(4,102,1),
(5,103,2),
(6,104,3),
(7,104,5);

-------------- Showing Inserted Records of favorites Table----------------------
--------------------------------------------------------------------------------
select * from favorites;

-------------- Showing Records of favorites detials ---------------------------
-------------------------------------------------------------------------------
select 
 f.fa_us_id,
 m.mo_title,
 m.mo_box_office,
 m.mo_genre,
 m.mo_has_teaser
 from movie_item m 
 join favorites f 
 on m.mo_id=f.fa_mo_id;

-------------- Deleting One Record of favorites Table---------------------------
---------------------------------------------------------------------------------
Delete 
 from favorites
 where fa_mo_id=5
 limit 1;

-------------- Showing Records of favorites Table-------------------------------
--------------------------------------------------------------------------------
select * from favorites;
--------------------------------------------------------------------------------