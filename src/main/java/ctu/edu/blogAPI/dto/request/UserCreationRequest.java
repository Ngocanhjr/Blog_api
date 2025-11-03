package ctu.edu.blogAPI.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data // khai all hàm get,set,ToString
@Builder //khởi tạo object theo kiểu xâu chuỗi, dễ đọc – không cần viết constructor dài hay gọi nhiều setter.
@NoArgsConstructor // tạo constructor không tham số (mặc định).
@AllArgsConstructor //tạo constructor với tất cả field theo thứ tự khai báo.
@FieldDefaults(level = AccessLevel.PRIVATE) // ko cần khai khai báo các phạm vi của biến
public class UserCreationRequest {
     @NotBlank(message = "Tên tài khoản không được để trống")
    @Size(min = 3, max = 30, message = "Username 3–30 ký tự")
    // CHỌN 1 TRONG 2 regex dưới đây:

    // Chữ + số (phổ biến, vẫn không khoảng trắng/ký tự đặc biệt):
    @Pattern(regexp = "^[a-z0-9]+$", message = "Username chỉ gồm a-z, 0-9, không khoảng trắng")
    String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 8, message = "password must be at least 8 character!!!")
    @Pattern(
        regexp = "^(?=.*[!@#$%^&*(),.?\":{}|<>]).+$",
        message = "Mật khẩu phải chứa ít nhất 1 ký tự đặc biệt"
    )
    String password;

    @NotNull(message = "Họ tên không được để trống")
    String fullname;

    @Past(message = "Ngày sinh phải nhỏ hơn ngày hiện tại")
    LocalDate dob;

    String userAvatarUrl;
    
}
