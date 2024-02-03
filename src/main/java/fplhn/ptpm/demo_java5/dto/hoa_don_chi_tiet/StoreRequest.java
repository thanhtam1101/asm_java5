package fplhn.ptpm.demo_java5.dto.hoa_don_chi_tiet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private int idHoaDon;
    private int idSPCT;

    private Integer soLuong;

    private BigDecimal donGia;
    private int trangThai;
}
