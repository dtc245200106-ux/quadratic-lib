package com.codegym;

/**
 * Lớp đóng gói kết quả giải phương trình bậc 2.
 * Chứa số nghiệm và các giá trị nghiệm (nếu có).
 */
public class QuadraticResult {

    /**
     * Số nghiệm của phương trình:
     *   -1 = vô số nghiệm (a = b = 0)
     *    0 = vô nghiệm
     *    1 = có nghiệm kép
     *    2 = có 2 nghiệm phân biệt
     */
    private int numberOfSolutions;

    /** Giá trị nghiệm thứ nhất (x1). */
    private double x1;

    /** Giá trị nghiệm thứ hai (x2) — chỉ dùng khi có 2 nghiệm. */
    private double x2;

    /** Thông báo mô tả kết quả (dễ đọc cho người dùng). */
    private String message;

    public QuadraticResult() {
    }

    public QuadraticResult(int numberOfSolutions, double x1, double x2, String message) {
        this.numberOfSolutions = numberOfSolutions;
        this.x1 = x1;
        this.x2 = x2;
        this.message = message;
    }

    // ===== Getter & Setter =====

    public int getNumberOfSolutions() {
        return numberOfSolutions;
    }

    public void setNumberOfSolutions(int numberOfSolutions) {
        this.numberOfSolutions = numberOfSolutions;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "QuadraticResult{" +
                "numberOfSolutions=" + numberOfSolutions +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", message='" + message + '\'' +
                '}';
    }
}