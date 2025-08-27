# Phạm Lê Anh Tuấn - 23110356

## 1. Login với Cookies và Session
Tất cả thông tin đăng nhập trong bài đều là cố định với Username: AnhTuan và Password: 123456
### Login với Cookies:
Trong thư mục: utesocial chọn src/main chọn webapp, nhấn chạy file Login.html. Lúc này sẽ hiện giao diện đăng nhập và nhập Username và Password theo như cung cấp ở trên.

Khi nhập Username và Password, tiến hành xét trong file LoginServlet.java trong package login, đúng thì sẽ chuyển sang trang HelloServlet.java trong package hello, ngược lại thì sẽ quay lại trang đăng nhập.

### Login với Session:
Trong thư mục: utesocial chọn src/main chọn webapp, nhấn chạy file Loginsession.html. Lúc này sẽ hiện giao diện đăng nhập và nhập Username và Password theo như cung cấp ở trên.

Khi nhập Username và Password, tiến hành xét trong file LoginServletSession.java trong package login, đúng thì sẽ chuyển sang trang ProfileHome.java trong package profile, ngược lại thì sẽ hiện thông báo: "Tài khoản hoặc mật khẩu không chính xác". Khi đăng nhập thành công và vào được trang ProfileHome, hiện thông báo: "Chào bạn, [Username] đến với trang quản lý tài khoản". Trong trang cũng đã thiết kế thêm phần Đăng xuất để khi nhấn vào sẽ chuyển ra trang Logout từ đó quay về Loginsession

## 2. Bài tập tuần 2:
Trong thư mục: CSDLKetNoi chọn src/main chọn webapp, nhấn chạy file Login.jsp. Sẽ hiện giao diện đăng nhập, tùy theo cài đặt tài khoản admin, manager.
Khi đăng nhập sẽ chuyển sang LoginController từ đó chuyển sang WaitingController. Từ đây sẽ xem vai trò của 
