package com.codegym;

/**
 * Thư viện giải phương trình bậc 2: ax² + bx + c = 0.
 * 
 * Công thức:
 *   Δ = b² - 4ac
 *   - Δ > 0: 2 nghiệm phân biệt x1 = (-b + √Δ) / (2a), x2 = (-b - √Δ) / (2a)
 *   - Δ = 0: nghiệm kép x1 = x2 = -b / (2a)
 *   - Δ < 0: vô nghiệm (trên tập số thực)
 * 
 * Trường hợp đặc biệt:
 *   - a = 0: phương trình trở thành bậc 1 (bx + c = 0)
 *   - a = b = 0: phương trình vô nghiệm hoặc vô số nghiệm
 */
public class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // ===== Getter & Setter =====

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    /**
     * Tính delta (Δ) = b² - 4ac.
     * @return giá trị delta
     */
    public double getDelta() {
        return b * b - 4 * a * c;
    }

    /**
     * Giải phương trình bậc 2 (static method — tiện dùng).
     * 
     * @param a hệ số bậc 2
     * @param b hệ số bậc 1
     * @param c hệ số tự do
     * @return QuadraticResult chứa số nghiệm và giá trị nghiệm
     */
    public static QuadraticResult solve(double a, double b, double c) {
        // Trường hợp a = 0 → phương trình bậc 1: bx + c = 0
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return new QuadraticResult(-1, 0, 0,
                            "Phương trình vô số nghiệm (a = b = c = 0)");
                } else {
                    return new QuadraticResult(0, 0, 0,
                            "Phương trình vô nghiệm (a = b = 0, c ≠ 0)");
                }
            } else {
                double x = -c / b;
                return new QuadraticResult(1, x, 0,
                        "Phương trình có 1 nghiệm (bậc 1): x = " + x);
            }
        }

        // Trường hợp a ≠ 0 → phương trình bậc 2
        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b + sqrtDelta) / (2 * a);
            double x2 = (-b - sqrtDelta) / (2 * a);
            return new QuadraticResult(2, x1, x2,
                    "Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return new QuadraticResult(1, x, x,
                    "Phương trình có nghiệm kép: x1 = x2 = " + x);
        } else {
            return new QuadraticResult(0, 0, 0,
                    "Phương trình vô nghiệm (Δ = " + delta + " < 0)");
        }
    }

    /**
     * Giải phương trình dựa trên giá trị a, b, c của instance hiện tại.
     * @return QuadraticResult
     */
    public QuadraticResult solve() {
        return solve(this.a, this.b, this.c);
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}