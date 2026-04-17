package ss08.bai3.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ss08.bai3.annotation.MultipleOfTenThousand;

public class BankWithdrawal {

    @NotNull(message = "ID giao dịch không được để trống")
    private Long transactionId;

    @NotNull(message = "Số tiền rút không được để trống")
    @MultipleOfTenThousand(
            message = "Số tiền rút phải >= 50.000 VNĐ và là bội số của 10.000 VNĐ " +
                    "(Ví dụ: 50.000, 60.000, 150.000)",
            minValue = 50_000,
            multipleOf = 10_000
    )
    private Long withdrawAmount;

    @NotBlank(message = "Số tài khoản ngân hàng không được để trống")
    private String bankAccountNumber;

    @NotBlank(message = "Tên ngân hàng không được để trống")
    private String bankName;

    @NotBlank(message = "Tên chủ tài khoản không được để trống")
    private String accountHolder;

    public BankWithdrawal() {
    }

    public BankWithdrawal(Long transactionId, Long withdrawAmount,
                          String bankAccountNumber, String bankName, String accountHolder) {
        this.transactionId = transactionId;
        this.withdrawAmount = withdrawAmount;
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.accountHolder = accountHolder;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString() {
        return "BankWithdrawal{" +
                "transactionId=" + transactionId +
                ", withdrawAmount=" + withdrawAmount +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                '}';
    }
}
