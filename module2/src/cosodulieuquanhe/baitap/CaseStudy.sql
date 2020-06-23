#2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from employees where (employee_name like "H%" or employee_name like "T%" or employee_name like "K%") and length(employee_name)<=15;
#3Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *,year(localtime()) - year(customer_birthday) as age from customers having (age between 18 and 50) and customer_address in ("Đà Nẵng","Quảng Trị");
#4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select customers.customer_name, count(contract_id) as total_book, customertypes.customer_type_name from customers join contracts using(customer_id)
join customertypes using(customer_type_id) where customer_type_name = "Diamond" group by customer_id order by total_book desc;
#5-------------------------IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
select customers.customer_id,customer_name,customer_type_name,temp.* from customers left join customertypes using(customer_type_id)
left join
(
select customers.customer_id,contracts.contract_id,service_name,contract_start_date,contract_end_date,
contract_price + attach_service_price*quantity as total_payment from customers join contracts using(customer_id)
join services using(service_id) join contractdetails using (contract_id) join attachservices using(attach_service_id)
group by customer_id
) as temp using (customer_id);
#6---------------------------------------IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
select services.service_id, service_name, service_area, contract_price + attach_service_price*quantity as total_payment,
service_type_name,contract_start_date from services join servicetypes using(service_type_id)
join contracts using(service_id) 
join contractdetails using(contract_id)
join attachservices using(attach_service_id) where month(contract_start_date) not in (1,2,3) and year(contract_start_date)!=2019;
#7----------------------------------tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
select services.service_id,service_name,service_area,service_max_people,contract_price, service_type_name, count(contract_id) as book_time, contract_start_date
from services join contracts using (service_id)
join servicetypes using(service_type_id)
where year(contract_start_date)=2018 and service_id not in(
select contract_id
from services join contracts using (service_id)
join servicetypes using(service_type_id)
where year(contract_start_date)=2019
) group by service_id;
#8-----------------------------Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
select distinct customer_name
from customers;
select * from customers group by customer_name;
#9-------------------------------------------nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng
SELECT
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 1 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'January',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 2 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'February',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 3 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'March',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 4 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'April',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 5 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'May',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 6 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'June',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 7 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'July',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 8 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'August',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 9 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'September',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 10 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'October',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 11 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'November',
  SUM(CASE MONTH(contracts.contract_start_date) WHEN 12 THEN contract_price + attach_service_price*quantity ELSE 0 END) AS 'December'
FROM
   contracts join contractdetails using(contract_id) join attachservices using(attach_service_id) 
WHERE
  contracts.contract_start_date BETWEEN '2019-01-01' AND '2019-12-31';
  #10--------------------IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem
  select contracts.contract_id,contract_start_date,contract_end_date,contract_deposit, count(attach_service_id) as attach_service_quantity
  from contracts join contractdetails using(contract_id) join attachservices using(attach_service_id) group by contract_id;
  #11-----------------
  select customer_id,customer_name,customer_address, attach_service_name
  from attachservices join contractdetails using(attach_service_id)
  join contracts using(contract_id)
  join customers using(customer_id)
  join customertypes using(customer_type_id)
  where customer_type_name = "Diamond" and customer_address in ("Vinh","Quảng Ngãi");
  #12--------------------IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc
  select contracts.contract_id, employee_name,customer_name,customer_phone,service_name, count(contractdetails.contract_detail_id) as number_attach_service, contract_deposit,contract_start_date
  from contracts join employees using(employee_id)
  join customers using(customer_id)
  join services using(service_id)
  join contractdetails using(contract_id)
  where (month(contract_start_date) in (10,11,12) and year(contract_start_date)=2019) and service_id not in
  (
   select service_id from contracts where month(contract_start_date) in (1,2,3,4,5,6) and year(contract_start_date)=2019
  )
  group by contract_id;
 #13--------------------------------------
 select attach_service_name, count(attach_service_id) as attach_service_id_use_number
 from attachservices join contractdetails using(attach_service_id)
 group by attach_service_name
 order by attach_service_id_use_number desc;
 #14---------------------------------------IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
 select contracts.contract_id,service_name,attach_service_name,count(attach_service_id) as number_attach_service
 from contracts join contractdetails using(contract_id)
 join attachservices using(attach_service_id)
 join services using(service_id)
 group by attach_service_name
 having number_attach_service = 1;
 #15----------------gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi
 select employees.employee_id,employee_name,edu_degree,employee_phone,employee_address, count(contracts.contract_id) as number_contract
 from employees join contracts using(employee_id)
 join edubackgrounds using (edu_bg_id)
 where year(contract_start_date) in (2018,2019)
 group by employee_id
 having number_contract <=3;
