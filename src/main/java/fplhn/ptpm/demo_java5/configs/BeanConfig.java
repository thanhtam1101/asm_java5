package fplhn.ptpm.demo_java5.configs;

import fplhn.ptpm.demo_java5.dto.san_pham.StoreRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class BeanConfig {
//    @Bean("bean san pham")
//    public List<StoreRequest> configBeanSP(){
//       List<StoreRequest> listSP = new ArrayList<>();
//        listSP.add(new StoreRequest(1, "sp1", "Bánh", 0));
//        listSP.add(new StoreRequest(2, "sp2", "Kẹo", 0));
//        listSP.add(new StoreRequest(3, "sp3", "Sữa", 0));
//        return listSP;
//    }
//    @Bean("bean mau sac")
//    public List<fplhn.ptpm.demo_java5.dto.mau_sac.StoreRequest> configBeanMS(){
//        List<fplhn.ptpm.demo_java5.dto.mau_sac.StoreRequest> listMS = new ArrayList<>();
//        listMS.add(new fplhn.ptpm.demo_java5.dto.mau_sac.StoreRequest(1, "m1", "Green", 0));
//        listMS.add(new fplhn.ptpm.demo_java5.dto.mau_sac.StoreRequest(2, "m2", "Black", 0));
//        listMS.add(new fplhn.ptpm.demo_java5.dto.mau_sac.StoreRequest(3, "m3", "Red", 0));
//        return listMS;
//    }
//    @Bean("bean kich thuoc")
//    public List<fplhn.ptpm.demo_java5.dto.kich_thuoc.StoreRequest> configBeanKT(){
//        List<fplhn.ptpm.demo_java5.dto.kich_thuoc.StoreRequest> listKT = new ArrayList<>();
//        listKT.add(new fplhn.ptpm.demo_java5.dto.kich_thuoc.StoreRequest(1, "kt1", "2x5x6", 0));
//        listKT.add(new fplhn.ptpm.demo_java5.dto.kich_thuoc.StoreRequest(2, "kt2", "3x2x8", 0));
//        listKT.add(new fplhn.ptpm.demo_java5.dto.kich_thuoc.StoreRequest(3, "kt3", "1x4x3", 0));
//        return listKT;
//    }
//
//    @Bean("bean CTSP")
//    public List<fplhn.ptpm.demo_java5.dto.chi_tiet_san_pham.StoreRequest> configBeanCTSP(){
//        BigDecimal gia1 = new BigDecimal(1000);
//        BigDecimal gia2 = new BigDecimal(20000);
//        BigDecimal gia3 = new BigDecimal(15000);
//        List<fplhn.ptpm.demo_java5.dto.chi_tiet_san_pham.StoreRequest> list = new ArrayList<>();
//        list.add(new fplhn.ptpm.demo_java5.dto.chi_tiet_san_pham.StoreRequest(1, "SP1",1, 1, 1, 50,gia1,0 ));
//        list.add(new fplhn.ptpm.demo_java5.dto.chi_tiet_san_pham.StoreRequest(2, "SP2",2, 2, 2, 30,gia2,0 ));
//        list.add(new fplhn.ptpm.demo_java5.dto.chi_tiet_san_pham.StoreRequest(3, "SP3",3, 2, 3, 10,gia3,0 ));
//        return list;
//    }
//    @Bean("bean nhan vien")
//    public List<fplhn.ptpm.demo_java5.dto.nhan_vien.StoreRequest> configBeanNV(){
//        List<fplhn.ptpm.demo_java5.dto.nhan_vien.StoreRequest> listNV = new ArrayList<>();
//        listNV.add(new fplhn.ptpm.demo_java5.dto.nhan_vien.StoreRequest(1, "NV1", "Nguyễn Văn A", "ASD", "1234", 0));
//        listNV.add(new fplhn.ptpm.demo_java5.dto.nhan_vien.StoreRequest(2, "NV2", "Nguyễn Văn B", "SDF", "12345", 0));
//      return listNV;
//    }
//    @Bean("bean khach hang")
//    public List<fplhn.ptpm.demo_java5.dto.khach_hang.StoreRequest> configBeanKH(){
//        List<fplhn.ptpm.demo_java5.dto.khach_hang.StoreRequest> listKH = new ArrayList<>();
//        listKH.add(new fplhn.ptpm.demo_java5.dto.khach_hang.StoreRequest(1, "KH001", "Nguyễn Văn A", "0265478694", 0));
//        listKH.add(new fplhn.ptpm.demo_java5.dto.khach_hang.StoreRequest(2, "KH002", "Nguyễn Văn B", "0324569874", 0));
//        listKH.add(new fplhn.ptpm.demo_java5.dto.khach_hang.StoreRequest(3, "KH003", "Nguyễn Thị C", "0478954123", 0));
//        return listKH;
//    }
//    @Bean("bean hoa don")
//    public List<fplhn.ptpm.demo_java5.dto.hoa_don.StoreRequest> configBeanHD(){
//        List<fplhn.ptpm.demo_java5.dto.hoa_don.StoreRequest> listHD = new ArrayList<>();
//        Date date = new Date(Date.UTC(2024,10,10,1,11,11));
//        listHD.add(new fplhn.ptpm.demo_java5.dto.hoa_don.StoreRequest(1, 1, 2, date, 1));
//        return listHD;
//    }
//    @Bean("bean hoa don chi tiet")
//    public List<fplhn.ptpm.demo_java5.dto.hoa_don_chi_tiet.StoreRequest> configBeanHDCT(){
//        BigDecimal gia1 = new BigDecimal(1000);
//        BigDecimal gia2 = new BigDecimal(1000);
//        List<fplhn.ptpm.demo_java5.dto.hoa_don_chi_tiet.StoreRequest> listHDCT = new ArrayList<>();
//        listHDCT.add(new fplhn.ptpm.demo_java5.dto.hoa_don_chi_tiet.StoreRequest(1, 1, 1,2,gia1,0));
//        listHDCT.add(new fplhn.ptpm.demo_java5.dto.hoa_don_chi_tiet.StoreRequest(2, 1, 2,1,gia2,0));
//        return listHDCT;
//    }
}
