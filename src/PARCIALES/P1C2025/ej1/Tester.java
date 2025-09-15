package PARCIALES.P1C2025.ej1;

import java.time.Month;
import java.time.MonthDay;

public class Tester {
    public static void main(String[] args) {
        // Ejemplo de uso de la clase java.time.MonthDay y java.time.Month
        MonthDay today = MonthDay.of(Month.APRIL, 24);
        System.out.println(today.isAfter(MonthDay.of(Month.MARCH, 1))); // true
        System.out.println(today.isBefore(MonthDay.of(Month.MAY, 1))); // true
        // Se instancia una cuenta remunerada el 15/01 donde se verifica que
        // - los montos de depósito y extracción son positivos
        // - las fechas de depósito y extracción no son anteriores a la fecha de creación
        // - se paga interés por el TOTAL del saldo
        SavingsAccount acc1 = new SavingsAccount(MonthDay.of(Month.JANUARY, 15));
        // Se deposita un millón $1000000 en la cuenta remunerada
        acc1.depositFunds(1_000_000, MonthDay.of(Month.JANUARY, 18));
        acc1.depositFunds(50_000, MonthDay.of(Month.JANUARY, 16));
        System.out.printf("$%.2f\n", acc1.getBalance()); // $1050000,00
        // Se paga el interés por 3 días con TNA = 30% lo que es 0,3
        // Pago Día 1: $1050000,00 * 0,3 * (1,0 / 365) = $863,01
        // Pago Día 2: $1050863,01 * 0,3 * (1,0 / 365) = $863,72
        // Pago Día 3: $1051726,73 * 0,3 * (1,0 / 365) = $864,43
        acc1.interestPayment(3);

        System.out.printf("$%.2f\n", acc1.getBalance()); // $1052591,17
        // Se realiza una extracción de $500000
        acc1.withdrawFunds(500_000, MonthDay.of(Month.JANUARY, 20));
        System.out.printf("$%.2f\n", acc1.getBalance()); // $552591,17
        acc1.withdrawFunds(100_000, MonthDay.of(Month.JANUARY, 15));
        System.out.printf("$%.2f\n", acc1.getBalance()); // $452591,17

        //Se instancia una cuenta remunerada el 15/02 donde se verifica que
        // - los montos de depósito y extracción son positivos
        // - las fechas de depósito y extracción no son anteriores a la fecha de creación
        // y no se pueden realizar una extracción con una fecha anterior a la última extracción
        // (o anterior a la fecha de creación si es que todavía no se hizo ninguna extracción)
        // - se paga interés por el TOTAL del saldo

        SavingsAccount acc2 = new SavingsAccountB(MonthDay.of(Month.FEBRUARY, 15));
        acc2.depositFunds(1_000_000, MonthDay.of(Month.FEBRUARY, 18));
        acc2.depositFunds(50_000, MonthDay.of(Month.FEBRUARY, 16));
        System.out.printf("$%.2f\n", acc2.getBalance()); // $1050000,00
        acc2.interestPayment(3);
        System.out.printf("$%.2f\n", acc2.getBalance()); // $1052591,17
        acc2.withdrawFunds(500_000, MonthDay.of(Month.FEBRUARY, 20));
        System.out.printf("$%.2f\n", acc2.getBalance()); // $552591,17
        try {
            // Falla porque la fecha de extracción debe ser posterior al 20/02
            acc2.withdrawFunds(100_000, MonthDay.of(Month.FEBRUARY, 15));
        } catch (Exception ex) {
            System.out.println("Error"); // Error
        }
        System.out.printf("$%.2f\n", acc2.getBalance()); // $552591,17
        acc2.withdrawFunds(100_000, MonthDay.of(Month.FEBRUARY, 21));
        System.out.printf("$%.2f\n", acc2.getBalance()); // $452591,17

        /// Se instancia una cuenta remunerada el 15/03 donde se verifica que
        /// - los montos de depósito y extracción son positivos
        /// y el monto de depósito mínimo es de cien mil pesos $100000,00
        /// - las fechas de depósito y extracción no son anteriores a la fecha de creación
        /// y no se pueden realizar una extracción con una fecha anterior a la última extracción
        /// (o anterior a la fecha de creación si es que todavía no se hizo ninguna extracción)
        /// - se paga interés SOLO HASTA 1 millón $1000000,00 del saldo

        SavingsAccount acc3 = new SavingsAccountC(MonthDay.of(Month.MARCH, 15));
        acc3.depositFunds(1_000_000, MonthDay.of(Month.MARCH, 18));
        try {
        // Falla porque el monto de depósito debe ser mayor o igual a cien mil 100000
            acc3.depositFunds(50_000, MonthDay.of(Month.MARCH, 16));
        } catch (Exception ex) {
            System.out.println("Error"); // Error
        }
        System.out.printf("$%.2f\n", acc3.getBalance()); // $1000000,00
        acc3.depositFunds(500_000, MonthDay.of(Month.MARCH, 16));
        System.out.printf("$%.2f\n", acc3.getBalance()); // $1500000,00
                // Se paga el interés por 3 días con TNA = 30% lo que es 0,3
                // Pago Día 1: $1000000,00 * 0,3 * (1,0 / 365) = $821,91
                // Pago Día 2: $1000000,00 * 0,3 * (1,0 / 365) = $821,91
                // Pago Día 3: $1000000,00 * 0,3 * (1,0 / 365) = $821,91
        acc3.interestPayment(3);
        System.out.printf("$%.2f\n", acc3.getBalance()); // $1502465,75
        acc3.withdrawFunds(500_000, MonthDay.of(Month.MARCH, 20));
        System.out.printf("$%.2f\n", acc3.getBalance()); // $1002465,75
        acc3.withdrawFunds(100_000, MonthDay.of(Month.MARCH, 21));
        System.out.printf("$%.2f\n", acc3.getBalance()); // $902465,75

    }
}
