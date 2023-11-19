package com.example.Website_sell_soccer_shoes_bumblebee.controller;

import com.example.Website_sell_soccer_shoes_bumblebee.entity.*;
import com.example.Website_sell_soccer_shoes_bumblebee.repository.*;

import com.example.Website_sell_soccer_shoes_bumblebee.service.ChiTietSanPhamService;
import com.example.Website_sell_soccer_shoes_bumblebee.service.Impl.VnPayServiceImpl;
import com.example.Website_sell_soccer_shoes_bumblebee.service.KichCoService;
import com.example.Website_sell_soccer_shoes_bumblebee.service.LoaiGiayService;
import com.example.Website_sell_soccer_shoes_bumblebee.service.MauSacService;

import com.example.Website_sell_soccer_shoes_bumblebee.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import java.text.ParseException;

import java.util.*;


import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    LoaiGiayService loaiGiayService;

    @Autowired
    KichCoService kichCoService;

    @Autowired
    MauSacService mauSacService;

    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Autowired
    GioHangRepo gioHangRepo;

    @Autowired
    GioHangChiTietRepo gioHangChiTietRepo;

    @Autowired
    GioHangChiTietService gioHangChiTietService;

    @Autowired
    KhachHangRepository khachHangRepository;

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    TaiKhoanService taiKhoanService;

    private static int maHoaDon = 1;

    @Data
    public static class SortForm {
        String key;
    }

    @Autowired
    HinhAnhRepository hinhAnhRepository;

    @Autowired
    HoaDonChiTietService hoaDonChiTietService;


    @Data
    public static class SearchFormByKichCo {
        Double key;
    }

    @Data
    public static class SearchFormByGiaBan {
        Double minPrice;
        Double maxPrice;
    }

    @ModelAttribute
    public void addAttributeSLGioHang(Model model, HttpSession session) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        Integer slGioHang;
        if (taiKhoan == null || taiKhoan.getKhachHangKH() == null) {
            slGioHang = 0;
        } else {
            slGioHang = chiTietSanPhamService.getSLGioHang(taiKhoan.getKhachHangKH().getId());
        }
        model.addAttribute("slGioHang", slGioHang);
    }


    @RequestMapping("/bumblebee/select-slsp")
    public ResponseEntity<String> getSLBySize(@RequestParam UUID idSP, @RequestParam UUID idMS, @RequestParam String size) {
        String sl = chiTietSanPhamService.getSoLuongByKichCo(idMS, idSP, size);
        return ResponseEntity.ok(sl);
    }

    @RequestMapping("/bumblebee/select-giaban")
    public ResponseEntity<ChiTietSanPham> getGiabanBySize(@RequestParam UUID idSP, @RequestParam UUID idMS, @RequestParam String size) {
        ChiTietSanPham giaBan = chiTietSanPhamRepo.getCTSPByKichCo(idMS,idSP,size);
        return ResponseEntity.ok(giaBan);
    }

    @GetMapping("/bumblebee/select-size")
    public ResponseEntity<List<Integer>> getKichCoByItemId(@RequestParam UUID idSP, @RequestParam UUID idMS, Model model) {
        List<Integer> kichCoList = chiTietSanPhamService.getKichCoByMauSacAndSanPham(idMS, idSP);
        return ResponseEntity.ok(kichCoList);
    }

    private List<GioHangChiTiet> listGHCT = null;
    private List<UUID> idCartUUIDList = null;


    @RequestMapping("/bumblebee/home")
    public String home(Model model, @RequestParam(defaultValue = "0") int p, HttpSession session) {
        int page = p; // Trang đầu tiên
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ChiTietSanPham> pageSP = chiTietSanPhamRepo.get1CTSPByMauSac(pageable);
        model.addAttribute("pageSP", pageSP);
        model.addAttribute("view", "../template_home/home.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/cart")
    public String cart(Model model, HttpSession session) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        if (taiKhoan == null) {
            return "redirect:/bumblebee/login";
        } else {
            Integer slGioHang = chiTietSanPhamService.getSLGioHang(taiKhoan.getKhachHangKH().getId());
            model.addAttribute("slGioHang", slGioHang);
            GioHang gioHang = gioHangRepo.getGioHang(taiKhoan.getKhachHangKH().getId());
            List<GioHangChiTiet> listGHCT;
            listGHCT = gioHangRepo.getGioHangChiTiet(gioHang.getId());
            model.addAttribute("listGHCT", listGHCT);
//            model.addAttribute("totalPrice", gioHangChiTietService.getTotalMoney(listGHCT));
            model.addAttribute("view", "../template_home/cart.jsp");
            return "template_home/index";
        }

    }

    @RequestMapping("/bumblebee/product_list")
    public String product_list(Model model, @RequestParam(defaultValue = "0") int p,
                               @ModelAttribute("sortForm") SortForm sortForm,
                               @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                               HttpSession session) {
        int page = p;
        int pageSize = 12;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ChiTietSanPham> listSP = chiTietSanPhamRepo.get1CTSPByMauSac(pageable);
        List<LoaiGiay> listLG = loaiGiayService.findAll();
        List<KichCo> listKC = kichCoService.getList();
        List<MauSac> listMS = mauSacService.getAll();
        model.addAttribute("pageSP", listSP);
        // model.addAttribute("pageSP", pageCTSP);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);
        model.addAttribute("view", "../template_home/product_listing.jsp");
        return "template_home/index";
    }

    @PostMapping("/bumblebee/update-cart")
    public Map<String, Object> updateCart(@RequestBody Map<String, Object> requestData, @RequestParam UUID idGHCT) {
        int soLuongMoi = Integer.parseInt(requestData.get("soLuong").toString());
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepo.getOne(idGHCT);
        ChiTietSanPham ctsp = gioHangChiTiet.getCtsp();
        int slCTSP = ctsp.getSoLuong();
        if (soLuongMoi > slCTSP) {
            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("soLuong", ctsp.getSoLuong());
            return jsonResponse;
        } else {
            gioHangChiTiet.setSoLuong(soLuongMoi);
            gioHangChiTietRepo.save(gioHangChiTiet);
            double thanhTienMoi = soLuongMoi * ctsp.getGiaBan();
            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("soLuong", soLuongMoi);
            jsonResponse.put("thanhTien", thanhTienMoi);
            return jsonResponse;
        }
    }


    @RequestMapping("/bumblebee/remove-ghct/{id}")
    public String removeGHCT(@PathVariable UUID id) {
        gioHangChiTietRepo.deleteById(id);
        return "redirect:/bumblebee/cart";
    }

    @GetMapping("/bumblebee/detail")
    public String detail(Model model, @RequestParam UUID idSP, @RequestParam UUID idCTSP, @RequestParam UUID idMS) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(idCTSP);
        System.out.println(chiTietSanPham.getSoLuong());
        List<Integer> listKCBySP = chiTietSanPhamService.getKichCoByMauSacAndSanPham(idMS, idSP);
        HinhAnh hinhAnh = chiTietSanPhamRepo.getHADetail(idCTSP);
        model.addAttribute("idCTSP", idCTSP);
        model.addAttribute("hinhAnh", hinhAnh);
        model.addAttribute("listKC", listKCBySP);
        model.addAttribute("ctsp", chiTietSanPham);
        model.addAttribute("view", "../template_home/product_detail.jsp");
        return "template_home/index";
    }


    @RequestMapping("/bumblebee/add-to-cart")
    public String addCart(Model model,
                          @RequestParam int kichCo,
                          @RequestParam UUID idMS,
                          @RequestParam UUID idSP,
                          @RequestParam String soLuong,
                          @RequestParam UUID idCTSP,
                          HttpSession session) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        if (taiKhoan == null) {
            return "redirect:/bumblebee/login";
        } else {
            KichCo size = chiTietSanPhamRepo.getKichCoBySize(kichCo);
            ChiTietSanPham ctsp = chiTietSanPhamService.findCTSPAddCart(idSP, idMS, size.getId());
            int soLuongCTSP = ctsp.getSoLuong();
            GioHang gioHang = gioHangRepo.getGioHang(taiKhoan.getKhachHangKH().getId());
            List<GioHangChiTiet> listGHCT = gioHangRepo.getGioHangChiTiet(gioHang.getId());
            for (GioHangChiTiet gioHangChiTiet : listGHCT) {
                if (gioHangChiTiet.getCtsp().getId().equals(ctsp.getId())) {
                    int soLuongHienTai = gioHangChiTiet.getSoLuong();
                    int slThem = Integer.parseInt(soLuong);
                    int slUpdate = soLuongHienTai + slThem;
                    if (slUpdate > soLuongCTSP) {
                        Integer slGioHang = chiTietSanPhamService.getSLGioHang(taiKhoan.getKhachHangKH().getId());
                        model.addAttribute("slGioHang", slGioHang);
                        model.addAttribute("errorSL", " Không thể thêm số lượng đã chọn vào giỏ hàng vì sẽ vượt quá giới hạn mua hàng của bạn.");
                        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(idCTSP);
                        List<Integer> listKCBySP = chiTietSanPhamService.getKichCoByMauSacAndSanPham(idMS, idSP);
                        HinhAnh hinhAnh = chiTietSanPhamRepo.getHADetail(idCTSP);
                        model.addAttribute("idCTSP", idCTSP);
                        model.addAttribute("hinhAnh", hinhAnh);
                        model.addAttribute("listKC", listKCBySP);
                        model.addAttribute("ctsp", chiTietSanPham);
                        model.addAttribute("view", "../template_home/product_detail.jsp");
                        return "template_home/index";
                    }
                    gioHangChiTiet.setSoLuong(slUpdate);
                    gioHangChiTietRepo.save(gioHangChiTiet);
                    return "redirect:/bumblebee/cart";
                }
            }
            int sl = Integer.parseInt(soLuong);
            if (sl > soLuongCTSP) {
                Integer slGioHang = chiTietSanPhamService.getSLGioHang(taiKhoan.getKhachHangKH().getId());
                model.addAttribute("slGioHang", slGioHang);
                model.addAttribute("errorSL", " Không thể thêm số lượng đã chọn vào giỏ hàng vì sẽ vượt quá giới hạn mua hàng của bạn.");
                ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(idCTSP);
                List<Integer> listKCBySP = chiTietSanPhamService.getKichCoByMauSacAndSanPham(idMS, idSP);
                HinhAnh hinhAnh = chiTietSanPhamRepo.getHADetail(idCTSP);
                model.addAttribute("idCTSP", idCTSP);
                model.addAttribute("hinhAnh", hinhAnh);
                model.addAttribute("listKC", listKCBySP);
                model.addAttribute("ctsp", chiTietSanPham);
                model.addAttribute("view", "../template_home/product_detail.jsp");
                return "template_home/index";
            }
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setCtsp(ctsp);
            gioHangChiTiet.setGioHang(gioHang);
            if (ctsp.getCtkm() != null) {
                double donGiaKhiGiam = 0;
                for (ChiTietKhuyenMai ctkm : ctsp.getCtkm()) {
                    if (ctkm.getKhuyenMai().getDonVi().contains("%")) {
                        donGiaKhiGiam = ctsp.getGiaBan() - (ctsp.getGiaBan() * ctkm.getKhuyenMai().getGiaTri() / 100);
                        gioHangChiTiet.setDonGiaKhiGiam(donGiaKhiGiam);
                    }
                    if (ctkm.getKhuyenMai().getDonVi().equals("VNÐ")) {
                        donGiaKhiGiam = ctsp.getGiaBan() - ctkm.getKhuyenMai().getGiaTri();
                        gioHangChiTiet.setDonGiaKhiGiam(donGiaKhiGiam);
                    }
                }
            }
            gioHangChiTiet.setDonGia(ctsp.getGiaBan());
            gioHangChiTiet.setSoLuong(sl);
            gioHangChiTietRepo.save(gioHangChiTiet);
            List<ChiTietSanPham> listCTSP = chiTietSanPhamService.getList();
            model.addAttribute("listGHCT", listGHCT);
            model.addAttribute("listCTSP", listCTSP);
            model.addAttribute("view", "../template_home/cart.jsp");
            return "redirect:/bumblebee/cart";

        }
    }

    @RequestMapping("/bumblebee/mua-ngay")
    public String muaNgay(Model model, HttpSession session, @RequestParam int kichCo,
                          @RequestParam UUID idMS,
                          @RequestParam UUID idSP,
                          @RequestParam int soLuong) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        if (taiKhoan == null) {
            return "redirect:/bumblebee/login";
        } else {
            model.addAttribute("listKH", taiKhoan.getKhachHangKH());
            listGHCT = new ArrayList<>();
            KichCo size = chiTietSanPhamRepo.getKichCoBySize(kichCo);
            ChiTietSanPham chiTietSanPham = chiTietSanPhamService.findCTSPAddCart(idSP, idMS, size.getId());
            GioHangChiTiet ghct = new GioHangChiTiet();
            ghct.setCtsp(chiTietSanPham);
            ghct.setSoLuong(soLuong);
            ghct.setDonGia(chiTietSanPham.getGiaBan());
            listGHCT.add(ghct);
            model.addAttribute("listGHCT", listGHCT);
            model.addAttribute("totalPrice", chiTietSanPham.getGiaBan() * soLuong);
            model.addAttribute("view", "../template_home/thanhtoan.jsp");
            return "template_home/index";
        }
    }

    @RequestMapping("/bumblebee/thanh-toan")
    public String thanhToan(Model model, @RequestParam(name = "idListCartDetail", required = false) String
            idListCartDetail,
                            @ModelAttribute("hoadon") HoaDon hoadon, HttpSession session
    ) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listKH", taiKhoan.getKhachHangKH());
        if (taiKhoan == null) {
            return "redirect:/bumblebee/login";
        } else {
            model.addAttribute("listKH", taiKhoan.getKhachHangKH());

            if (idListCartDetail == null) {
                return "redirect:/bumblebee/cart";
            } else {

                // Lấy list idctsp
                idCartUUIDList = Arrays.asList(idListCartDetail.split(","))
                        .stream()
                        .map(UUID::fromString)
                        .collect(Collectors.toList());
                listGHCT = new ArrayList<>();
                for (UUID id : idCartUUIDList) {
                    GioHangChiTiet ghct = gioHangChiTietService.findId(id, taiKhoan.getKhachHangKH().getId());
                    listGHCT.add(ghct);
                }
                model.addAttribute("listKH", taiKhoan.getKhachHangKH());

                //totalPrice = gioHangChiTietService.getTotalMoney(listGHCT);
                model.addAttribute("listGHCT", listGHCT);

                model.addAttribute("view", "../template_home/thanhtoan.jsp");
                return "template_home/index";
            }
        }
    }


    private HoaDon hoaDon;
    @Autowired
    HoaDonRepository hoaDonRepository;

    @RequestMapping("/bumblebee/dat-hang")
    public String datHang(
            Model model,
            HttpSession session,
            //@ModelAttribute("hoadon") HoaDon hoaDon,
            @RequestParam(name = "tenNguoiNhan") String tenNguoiNhan,
            @RequestParam(name = "sdt") String sdt,
            @RequestParam(name = "diaChiShip") String diaChiShip,
            @RequestParam(name = "ghiChu") String ghiChu,
            @RequestParam(name = "payment") Integer payment
    ) throws ParseException {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        KhachHang kh = khachHangService.findId(taiKhoan.getKhachHangKH().getId());

        // Tạo hóa đơn
        hoaDon = new HoaDon();
        String formatHoaDon = "HD" + String.format("%07d", maHoaDon);
        HoaDon checkMa = hoaDonRepository.searchHoaDon(formatHoaDon);
        if (checkMa != null) {
            String maHoaDonMax = hoaDonRepository.searchMaxMaHoaDon();
            maHoaDon = Integer.valueOf(maHoaDonMax.substring(2));
            maHoaDon++;
            String formatSoMa = "HD" + String.format("%07d", maHoaDon);
            hoaDon.setMaHoaDon(formatSoMa);
        } else {
            hoaDon.setMaHoaDon(formatHoaDon);
        }
        hoaDon.setNgayTao(new Date());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String format = sdf.format(date);
        hoaDon.setKhachHang(kh);
        hoaDon.setNgayTao(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(format));
        hoaDon.setNgayThanhToan(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(format));
        hoaDon.setTenNguoiNhan(tenNguoiNhan);
        hoaDon.setSdt(sdt);
        hoaDon.setDiaChiShip(diaChiShip);
        hoaDon.setGhiChu(ghiChu);
        hoaDon.setLoaiHoaDon(0);
        if (payment.intValue() == 2) {
            return "redirect:/VnPay";
        } else {
            hoaDon.setPhuongThucThanhToan(1);
            hoaDon.setTrangThai(1);
            hoaDonService.saveHoaDon(hoaDon);
        }

        // Tạo hóa đơn chi tiết
        for (GioHangChiTiet ghct : listGHCT) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setHoaDon(hoaDon);
            hdct.setChiTietSanPham(ghct.getCtsp());
            hdct.setSoLuong(ghct.getSoLuong());
            if (ghct.getCtsp().getCtkm() != null) {
                hdct.setDonGiaKhiGiam(ghct.getDonGiaKhiGiam());
            }
            hdct.setDonGia(ghct.getDonGia());
            hdct.setTrangThai(3);
            hoaDonChiTietService.save(hdct);
            ChiTietSanPham ctsp = chiTietSanPhamService.getOne(ghct.getCtsp().getId());
            ctsp.setSoLuong(ghct.getCtsp().getSoLuong() - ghct.getSoLuong());
            chiTietSanPhamRepo.save(ctsp);
            if (ghct.getId() != null) {
                gioHangChiTietService.deleteGHCT(ghct.getId());
            }
        }

        return "redirect:/bumblebee/don-mua/cho-xac-nhan";
//        return "redirect:/pay";
    }

//    @GetMapping("/pay")
//    public String home(Model model) {
//        Double price = gioHangChiTietService.getTotalMoney(listGHCT);
//        model.addAttribute("price", price);
//        return "/paypal/paypal";
//    }


    // THANH TOÁN VNPAY
    @Autowired
    private VnPayServiceImpl vnPayService;


    @GetMapping("/VnPay")
    public String home(Model model) {
        Double price = gioHangChiTietService.getTotalMoney(listGHCT);
        Integer amount = price.intValue();
        model.addAttribute("amount", amount);
        return "VnPay/index";
    }

    @PostMapping("/submitOrder")
    public String submidOrder(@RequestParam("amount") Integer orderTotal,
                              @RequestParam("orderInfo") String orderInfo,
                              HttpServletRequest request) {

        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
        return "redirect:" + vnpayUrl;
    }

    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request, Model model) {
        int paymentStatus = vnPayService.orderReturn(request);
        if (paymentStatus == 1) {
            hoaDon.setPhuongThucThanhToan(2);
            hoaDon.setTrangThai(1);
            hoaDonService.saveHoaDon(hoaDon);
            // Tạo hóa đơn chi tiết
            for (GioHangChiTiet ghct : listGHCT) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setHoaDon(hoaDon);
                hdct.setChiTietSanPham(ghct.getCtsp());
                hdct.setSoLuong(ghct.getSoLuong());
                hdct.setDonGia(ghct.getDonGia());
                hdct.setTrangThai(3);
                hoaDonChiTietService.save(hdct);
                gioHangChiTietService.deleteGHCT(ghct.getId());
            }
        }
        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "redirect:/bumblebee/don-mua/cho-xac-nhan" : "redirect:/bumblebee/thanh-toan";
    }


    @RequestMapping("/bumblebee/bill/{id}")
    public String bill(Model model, @PathVariable(name = "id") UUID id) {
        model.addAttribute("listHD", hoaDonService.getId(id));
        model.addAttribute("totalPrice", gioHangChiTietService.getTotalMoney(listGHCT));
        model.addAttribute("view", "../template_home/bill.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua")
    public String donMua(Model model, HttpSession session) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        if (taiKhoan == null) {
            return "redirect:/bumblebee/login";
        } else {
            model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonMua(taiKhoan.getKhachHangKH().getId()));
            model.addAttribute("view", "../don_mua/don_mua.jsp");
            return "template_home/index";
        }
    }

    @RequestMapping("/bumblebee/don-mua/{id}")
    public String donMuaChiTet(Model model, HttpSession session, @PathVariable(name = "id") UUID id) {

        List<HoaDonChiTiet> list = hoaDonChiTietService.getListHoaDonCTByIdHoaDon(id);


        model.addAttribute("id", id);
        model.addAttribute("hoaDon", hoaDonService.getOne(id));
        model.addAttribute("listHoaDonChiTiet", hoaDonChiTietService.getHoaDonById(id));
        model.addAttribute("view", "../don_mua/don_mua_chi_tiet.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua/cho-xac-nhan")
    public String donChoThanhToan(Model model, HttpSession session) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonChoThanhToan(taiKhoan.getKhachHangKH().getId()));
        for (HoaDon hd : hoaDonService.listHoaDonChoThanhToan(taiKhoan.getKhachHangKH().getId())){
            System.out.println(hd.getMaHoaDon());
            System.out.println("a");
        }
        model.addAttribute("view", "../don_mua/don_mua.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua/dang-chuan-bi")
    public String donDangChuanBi(Model model, HttpSession session) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonDangChuanBi(taiKhoan.getKhachHangKH().getId()));
        model.addAttribute("view", "../don_mua/don_mua.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua/dang-giao")
    public String donDangGiao(Model model, HttpSession session) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonDangGiao(taiKhoan.getKhachHangKH().getId()));
        model.addAttribute("view", "../don_mua/don_mua.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua/hoan-thanh")
    public String donHoanThanh(Model model, HttpSession session) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonHoanThanh(taiKhoan.getKhachHangKH().getId()));
        model.addAttribute("view", "../don_mua/don_mua.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua/da-huy")
    public String donDaHuy(Model model, HttpSession session) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonDaHuy(taiKhoan.getKhachHangKH().getId()));
        model.addAttribute("view", "../don_mua/don_mua.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua/tra-hang")
    public String donTraHang(Model model, HttpSession session) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonTraHang(taiKhoan.getKhachHangKH().getId()));


        model.addAttribute("view", "../don_mua/don_mua.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/don-mua/da-hoan-tra")
    public String donDaHoanTra(Model model, HttpSession session) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("listHoaDonMua", hoaDonService.listHoaDonDaHoanTra(taiKhoan.getKhachHangKH().getId()));
        model.addAttribute("view", "../don_mua/don_mua.jsp");
        return "template_home/index";
    }

    @ModelAttribute("dsGioiTinh")
    public Map<Boolean, String> getDsGioiTinh() {
        Map<Boolean, String> dsGT = new HashMap<>();
        dsGT.put(true, "Nam");
        dsGT.put(false, "Nữ");
        return dsGT;
    }

    @GetMapping("/bumblebee/thong-tin-ca-nhan")
    public String getThongTinCaNhan(Model model, HttpSession session, @ModelAttribute("kh") KhachHang kh) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        model.addAttribute("kh", khachHangService.findId(taiKhoan.getKhachHangKH().getId()));
        model.addAttribute("view", "../don_mua/thong_tin_ca_nhan.jsp");
        return "template_home/index";
    }

    @PostMapping("/bumblebee/thong-tin-ca-nhan")
    public String thongTinCaNhan(Model model, HttpSession session, @ModelAttribute("kh") KhachHang kh) {

        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");

        KhachHang khachHang = khachHangService.findId(taiKhoan.getKhachHangKH().getId());
        khachHang.setHo(kh.getHo());
        khachHang.setTenDem(kh.getTenDem());
        khachHang.setTen(kh.getTen());
        khachHang.setGioiTinh(kh.getGioiTinh());
        khachHang.setSoDienThoai(kh.getSoDienThoai());
        khachHang.setNgaySinh(kh.getNgaySinh());
        khachHang.setDiaChi(kh.getDiaChi());
        khachHangService.saveKhachHang(kh);

        return "redirect:/bumblebee/thong-tin-ca-nhan";
    }


    @RequestMapping("/bumblebee/product_list/sort")
    public String sort(Model model, @RequestParam(defaultValue = "0") int p,
                       @ModelAttribute("sortForm") SortForm sortForm,
                       @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                       HttpSession session) {
        Sort sort;
        Pageable pageable;
        if (sortForm.key.equals("giaBanTangDan")) {
            sort = Sort.by(Sort.Direction.ASC, "giaBan");
            pageable = PageRequest.of(p, 12, sort);
        } else if (sortForm.key.equals("giaBanGiamDan")) {
            sort = Sort.by(Sort.Direction.DESC, "giaBan");
            pageable = PageRequest.of(p, 12, sort);
        } else if (sortForm.key.equals("moiNhat")) {
            sort = Sort.by(Sort.Direction.DESC, "ngayTao");
            pageable = PageRequest.of(p, 12, sort);
        } else {
            pageable = PageRequest.of(p, 12);
        }
        Page<ChiTietSanPham> pageCTSP = chiTietSanPhamRepo.get1CTSPByMauSac(pageable);
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        List<LoaiGiay> listLG = loaiGiayService.findAll();
        List<KichCo> listKC = kichCoService.getList();
        List<MauSac> listMS = mauSacService.getAll();
        model.addAttribute("listSP", listSP);
        model.addAttribute("pageSP", pageCTSP);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);
        model.addAttribute("view", "../template_home/product_listing.jsp");
        return "template_home/index";
    }


    @RequestMapping("/bumblebee/product_list/searchbygiaban")
    public String getListByGiaBan(Model model, @RequestParam(defaultValue = "0") int p,
                                  @ModelAttribute("sortForm") SortForm sortForm,
                                  @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan) {
        Pageable pageable = PageRequest.of(p, 12);
        Page<ChiTietSanPham> pageCTSPByGia = chiTietSanPhamService.getCTSPByGiaBan(searchFormByGiaBan.minPrice, searchFormByGiaBan.maxPrice, pageable);
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        List<LoaiGiay> listLG = loaiGiayService.findAll();
        List<KichCo> listKC = kichCoService.getList();
        List<MauSac> listMS = mauSacService.getAll();
        model.addAttribute("listSP", listSP);
        model.addAttribute("pageSP", pageCTSPByGia);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);
        model.addAttribute("view", "../template_home/product_listing.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/product_list/searchbykichco/{id}")
    public String getListByKichCo(Model model, @RequestParam(defaultValue = "0") int p,
                                  @ModelAttribute("sortForm") SortForm sortForm,
                                  @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                                  @PathVariable UUID id,
                                  HttpSession session) {
        KichCo kichCo = kichCoService.getOne(id);
        Pageable pageable = PageRequest.of(p, 12);
        Page<ChiTietSanPham> pageCTSPByKichCo = chiTietSanPhamService.getCTSPByKC(kichCo.getId(), pageable);
        List<LoaiGiay> listLG = loaiGiayService.findAll();
        List<KichCo> listKC = kichCoService.getList();
        List<MauSac> listMS = mauSacService.getAll();
        model.addAttribute("pageSP", pageCTSPByKichCo);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);
        model.addAttribute("view", "../template_home/product_listing.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/product_list/searchbymausac")
    public String getListByMauSac(Model model, @RequestParam(defaultValue = "0") int p,
                                  @ModelAttribute("sortForm") SortForm sortForm,
                                  @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                                  @RequestParam UUID idMS,
                                  HttpSession session
    ) {
        Pageable pageable = PageRequest.of(p, 12);
        Page<ChiTietSanPham> listCTSPBYMS = chiTietSanPhamService.getCTSPByMS(idMS, pageable);
        List<LoaiGiay> listLG = loaiGiayService.findAll();
        List<KichCo> listKC = kichCoService.getList();
        List<MauSac> listMS = mauSacService.getAll();
        model.addAttribute("pageSP", listCTSPBYMS);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);
        model.addAttribute("view", "../template_home/product_listing.jsp");
        return "template_home/index";
    }

    @RequestMapping("/bumblebee/product_list/searchbyloaigiay")
    public String getListByLoaiGiay(Model model,
                                    @RequestParam(defaultValue = "0") int p,
                                    @ModelAttribute("sortForm") SortForm sortForm,
                                    @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                                    @RequestParam(name = "idLoaiGiayList", required = false) String idLoaiGiayList,
                                    HttpSession session
    ) {
        if ("all".equals(idLoaiGiayList)) {
            int page = p;
            int pageSize = 12;
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<ChiTietSanPham> pageSP = chiTietSanPhamRepo.get1CTSPByMauSac(pageable);
            List<LoaiGiay> listLG = loaiGiayService.findAll();
            List<KichCo> listKC = kichCoService.getList();
            List<MauSac> listMS = mauSacService.getAll();

            model.addAttribute("pageSP", pageSP);
            model.addAttribute("listLG", listLG);
            model.addAttribute("listKC", listKC);
            model.addAttribute("listMS", listMS);
            model.addAttribute("view", "../template_home/product_listing.jsp");
        } else {
            List<UUID> idLoaiGiayUUIDList = Arrays.asList(idLoaiGiayList.split(","))
                    .stream()
                    .map(UUID::fromString)
                    .collect(Collectors.toList());

            Pageable pageable = PageRequest.of(p, 12);
            Page<ChiTietSanPham> listCTSPByLoaiGiay = chiTietSanPhamService.searchCTSPByLoaiGiayList(idLoaiGiayUUIDList, pageable);
            List<LoaiGiay> listLG = loaiGiayService.findAll();
            List<KichCo> listKC = kichCoService.getList();
            List<MauSac> listMS = mauSacService.getAll();

            model.addAttribute("pageSP", listCTSPByLoaiGiay);
            model.addAttribute("listLG", listLG);
            model.addAttribute("listKC", listKC);
            model.addAttribute("listMS", listMS);
            model.addAttribute("view", "../template_home/product_listing.jsp");
        }

        return "template_home/index";
    }

    @GetMapping("/bumblebee/chinh-sach-doi-tra")
    public String chinhSach(Model model) {
        model.addAttribute("view", "../template_home/chinh-sach.jsp");
        return "template_home/index";
    }
}
