package ctu.edu.blogAPI.dto.request;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data // khai all hàm get,set,ToString
@Builder // khởi tạo object theo kiểu xâu chuỗi, dễ đọc – không cần viết constructor dài hay gọi nhiều setter.
@NoArgsConstructor // tạo constructor không tham số (mặc định).
@AllArgsConstructor // tạo constructor với tất cả field theo thứ tự khai báo.
@FieldDefaults(level = AccessLevel.PRIVATE) // ko cần khai khai báo các phạm vi của biến

public class UserUpdateRequest {
    String username;
    String password;
    String fullname;
    LocalDate dob;
}
