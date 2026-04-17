package ss08.bai3.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ss08.bai3.model.dto.BankWithdrawal;

@Controller
@RequestMapping("/withdrawals")
public class Bai3Controller {

    @GetMapping("/create")
    public String showWithdrawalForm(Model model) {
        model.addAttribute("bankWithdrawal", new BankWithdrawal());
        return "bankWithdrawal";
    }

    @PostMapping("/create")
    public String createWithdrawal(
            @Valid @ModelAttribute("bankWithdrawal") BankWithdrawal withdrawal,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "bankWithdrawal";
        }

        String successMessage = String.format(
                "Rút tiền thành công! Số tiền: %,d VNĐ từ %s tài khoản %s",
                withdrawal.getWithdrawAmount(),
                withdrawal.getBankName(),
                withdrawal.getBankAccountNumber()
        );

        model.addAttribute("message", successMessage);
        model.addAttribute("success", true);
        model.addAttribute("bankWithdrawal", new BankWithdrawal());

        return "bankWithdrawal";
    }
}
