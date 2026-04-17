package ss08.bai1.controller;

import jakarta.validation.Valid;
import ss08.bai1.model.dto.AddressDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class Bai1Controller {
    // gây lỗi 500 vì không validation cho body dẫn đến khi spring map vào model có thể null hoặc lỗi mapping
    @PostMapping("/update")
    public ResponseEntity<String> updateAddress(@Valid @RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok("Update address successfully");
    }
}