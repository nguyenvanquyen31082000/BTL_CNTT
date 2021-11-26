create database `quanlytuyensinh`;
use `quanlytuyensinh`;

-- table
create table UuTien(
UuTien_ID varchar(99) primary key,
DiemCongThem float not null
);

create table ThiSinh(
ID_ThiSinh varchar(99) primary key,
HoTen varchar(40) not null,
NoiSinh varchar(40) not null,
CMND varchar(99) not null,
DiaChi varchar(40) not null,
GioiTinh varchar(10) not null,
NgaySinh datetime not null,
SoDienThoai varchar(99) not null,
Email varchar(99) not null,
UuTien_ID varchar(99) not null,
foreign key (UuTien_ID) references UuTien(UuTien_ID)
);

create table TaiKhoan(
ID_TaiKhoan varchar(99) primary key,
MatKhau varchar(99) not null,
QuyenHan varchar(99) not null
);

create table MonThi(
ID_MonThi varchar(99) primary key,
TenMon varchar(99) not null
);

create table DiemThi(
ID_ThiSinh varchar(99) not null,
ID_MonThi varchar(99) not null,
Diem float not null,
CumThi varchar(99) not null,
NamThi varchar(99) not null,
primary key (ID_ThiSinh,ID_MonThi),
foreign key (ID_ThiSinh) references ThiSinh(ID_ThiSinh),
foreign key (ID_MonThi) references MonThi(ID_MonThi)
);

create table KhoiThi(
ID_KhoiThi varchar(99),
TenKhoi varchar(99) not null,
ID_MonThi varchar(99),
primary key (ID_KhoiThi,ID_MonThi),
foreign key (ID_MonThi) references MonThi(ID_MonThi)
);

-- procedure
delimiter //
create procedure get_all_thisinh()
begin
	select * from thisinh;
end;

create procedure get_thisinh(id varchar(99))
begin
	select * from thisinh where ID_ThiSinh = id;
end;

create procedure insert_thisinh(id varchar(99), hoten varchar(99), noisinh varchar(99), cmnd varchar(99), diachi varchar(99), gioitinh varchar(99),
 ngaysinh date, sodienthoai varchar(99), email varchar(99), uutien varchar(99))
begin
	insert into thisinh values(id, hoten, noisinh, cmnd, diachi, gioitinh, ngaysinh, sodienthoai, email, uutien);
end;

create procedure update_thisinh(id varchar(99), hoten varchar(99), noisinh varchar(99), cmnd varchar(99), diachi varchar(99), gioitinh varchar(99),
 ngaysinh date, sodienthoai varchar(99), email varchar(99), uutien varchar(99))
begin
	update thisinh
    set HoTen = hoten, NoiSinh = noisinh, DiaChi = diachi, GioiTinh = gioitinh, NgaySinh = ngaysinh, SoDienThoai = sodienthoai, Email = email, UuTien_ID = uutien, CMND = cmnd
    where ID_ThiSinh = id;
end;

create procedure delete_thisinh(id varchar(99))
begin
	delete from thisinh
    where ID_ThiSinh = id;
end;

create procedure get_a_thisinh(id varchar(99))
begin
	select * from thisinh
    where CMND = id;
end;

create procedure get_a_taikhoan(id varchar(99))
begin
	select * from taikhoan where ID_TaiKhoan = id;
end;

create procedure get_taikhoan(uname varchar(99), upass varchar(99))
begin
	select * from taikhoan where ID_TaiKhoan = uname and MatKhau = upass;
end;

create procedure insert_taikhoan(uname varchar(99), upass varchar(99), quyenhan varchar(99))
begin
	insert into taikhoan values(uname, upass, quyenhan);
end;

create procedure update_taikhoan(uname varchar(99), upass varchar(99), quyenhan varchar(99))
begin
	update taikhoan
    set MatKhau = upass, QuyenHan = quyenhan
    where ID_TaiKhoan = uname;
end;

create procedure delete_taikhoan(uname varchar(99))
begin
	delete from taikhoan
    where ID_TaiKhoan = uname;
end;

create procedure get_all_diem()
begin
	select * from diemthi;
end;

create procedure check_diem(id varchar(99), id_mon varchar(99))
begin
	select * from diemthi where ID_ThiSinh = id and ID_MonThi = id_mon;
end;

create procedure get_diem(id varchar(99))
begin
	select * from diemthi
    where ID_ThiSinh = id;
end;

create procedure insert_diem(id varchar(99), id_monhoc varchar(99), diem float, cumthi varchar(99), namthi varchar(99))
begin
	insert into diemthi values(id, id_monhoc, diem, cumthi, namthi);
end;

create procedure update_diem(id varchar(99), id_monhoc varchar(99), diem float, cumthi varchar(99), namthi varchar(99))
begin
	update diemthi
	set Diem = diem, CumThi = cumthi, NamThi = namthi
    where ID_ThiSinh = id and ID_MonThi = id_monhoc;
end;

create procedure delete_diem(id varchar(99), id_monhoc varchar(99))
begin
	delete from diemthi where ID_ThiSinh = id and ID_MonThi = id_monhoc;
end;

create procedure get_mon(id varchar(99))
begin
	select * from monthi where ID_MonThi = id;
end;

create procedure get_idmon(ten varchar(99))
begin
	select * from monthi where TenMon = ten;
end;
//
delimiter ;

-- data 
insert into taikhoan values('admin','admin','ADMIN');
insert into taikhoan values('1234567890','user','USER');

insert into monthi values('1','Toán');
insert into monthi values('2','Vật Lý');
insert into monthi values('3','Hóa Học');
insert into monthi values('4','Sinh Học');
insert into monthi values('5','Ngữ Văn');
insert into monthi values('6','Lịch Sử');
insert into monthi values('7','Địa Lý');

insert into khoithi values('A','Khối A', '1');
insert into khoithi values('A','Khối A', '2');
insert into khoithi values('A','Khối A', '3');
insert into khoithi values('B','Khối B', '1');
insert into khoithi values('B','Khối B', '3');
insert into khoithi values('B','Khối B', '4');
insert into khoithi values('C','Khối C', '5');
insert into khoithi values('C','Khối C', '6');
insert into khoithi values('C','Khối C', '7');

insert into UuTien values('UT1',2);
insert into UuTien values('UT2',1);
insert into UuTien values('KV1',1);
insert into UuTien values('KV2',0.5);
insert into UuTien values('KV2-NT',0.5);
insert into UuTien values('KV3',0);

call insert_thisinh('1','Phạm Văn Long','Hà Nội','1234567890','123 - Cầu Diễn','Nam','1995-05-05','123456789','abc@gmail.com','KV1');
call insert_thisinh('2','Phạm Văn Long','Hà Nội','1234567891','123 - Cầu Diễn','Nam','1995-5-5','123456788','abc@gmail.com','KV1');

call insert_diem('1','2','5','THPT Hà Nội','2010');











