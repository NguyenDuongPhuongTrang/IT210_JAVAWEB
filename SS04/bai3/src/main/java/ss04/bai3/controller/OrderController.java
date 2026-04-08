package ss04.bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3/orders")
public class OrderController {

    @GetMapping("/{id}")
    @ResponseBody
    public String getOrderDetail(@PathVariable Long id) {
        return "Chi tiết đơn hàng số " + id;
    }
}

// Trong Cách A số 5 nằm trong URI Path (đường dẫn), thể hiện đây là định danh của một tài nguyên cụ thể.
// Còn cách B số 5 nằm trong Query String (chuỗi truy vấn), thường dùng để lọc hoặc tìm kiếm dữ liệu.
//Theo RESTful convention, khi truy cập vào một tài nguyên cụ thể (theo ID) thì nên dùng PathVariable.
//Vì vậy, chọn Cách A vì nó rõ nghĩa, chuẩn REST và dễ đọc hơn.
