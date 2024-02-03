package fplhn.ptpm.demo_java5.dto.hoa_don;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreRequest {
    @PositiveOrZero(message = "Id phải là số nguyên dương")
    @NotNull(message = "Không được để trống")
    private int id;
    private int idNhanVien;
    private int idKhachHang;
    private Date ngayMuaHang;
    private int trangThai;
}
