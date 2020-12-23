use webdb;

desc user;

-- 회원가입 : insert
insert 
into user 
values(null, '김송현', 'kims@bitacademy.com', '1234', 'male', now());


-- 로그인 : select
select no, name
from user
where email='kims@bitacademy.com'
and password='1234';

-- 회원정보 : select
select no, name, email, gender, date_formate(join_date, %Y-%m-%d)
from user
where no= 1;

-- 회원정보 수정 : update
update
set
where
-- 