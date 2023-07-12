use demo_api;

insert into user(user_id, user_full_name, user_address, user_email, user_phone, user_account, user_password)
                 values (default,'Hai Son', 'Nam Dinh','son@gmail.com','0858437557','son94','123'),
                        (default,'Ngo Hai', 'Thai Binh','hai@gmail.com','0919734568','hai97','123'),
                        (default,'Minh Tuan', 'Thai Binh','mt@gmail.com','0987654321','mt98','123'),
                        (default,'pukadu', 'Ha Dong','dung@gmail.com','123456789','pukadu','123'),
                        (default,'Minh Cong', 'Ha Giang','cong@gmail.com','987654321','cong98','123');
insert into blog(blog_id,blog_topic,blog_text_content,user_user_id)
                    values (default, 'Xa hoi','khong co gi',1),
                        (default, 'Tao lao','khong co gi',1),
                        (default, 'Thoi su','khong co gi',1),
                        (default, 'Xa hoi','chua co gi',2),
                        (default, 'Tao lao','chua co gi',2),
                        (default, 'Thoi su','chua co gi',2),
                        (default, 'Xa hoi','deo co gi',3),
                        (default, 'Tao lao','chua co gi',3),
                        (default, 'Thoi su','deo co gi',3),
                        (default, 'Xa hoi','cha co gi',4),
                        (default, 'Tao lao','cha co gi',4),
                        (default, 'Thoi su','cha co gi',4),
                        (default, 'Xa hoi','eo co gi',5),
                        (default, 'Tao lao','eo co gi',5),
                        (default, 'Thoi su','eo co gi',5);