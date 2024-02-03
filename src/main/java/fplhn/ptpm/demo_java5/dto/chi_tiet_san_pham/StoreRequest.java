package fplhn.ptpm.demo_java5.dto.chi_tiet_san_pham;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequest {

    private int id;
    private String maSPCT;
    private int idSanPham;

    private int idKichThuoc;
    private int idMauSac;
    @Positive(message = "Số lượng phải là số nguyên dương")
    @NotNull(message = "Không được để trống")
    private Integer soLuong;
    @Positive(message = "Giá phải > 0")
    @NotNull(message = "Không được để trống")
    private BigDecimal donGia;
    private int trangThai;
}
