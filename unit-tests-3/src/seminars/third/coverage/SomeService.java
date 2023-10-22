package seminars.third.coverage;

public class SomeService {

    /**
     * 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5, и FizzBuzz для кратных 3 и 5 одновременно
     */
    public String fizzBuzz(int i) {

        if (i % 5 == 0 && i % 3 == 0) {
            return "FizzBuzz"; // вместо этого напишите свою реализацию
        } else if (i % 3 == 0) {
            return "Fizz"; // вместо этого напишите свою реализацию
        } else if (i % 5 == 0) {
            return "Buzz"; // вместо этого напишите свою реализацию
        }
        return String.valueOf(i);

    }

    /**
     * 3.2. Метод возвращает true для массивов, которые начинаются или заканчиваются 6, и false - если 6 нет ни в начале ни в конце массива
     */
    public boolean firstLast6(int[] nums) {

        if (nums == null || nums.length == 0) return false;
        if (nums[0] == 6 || nums[nums.length - 1] == 6) return true;
        return false;
    }


    /**
     * 3.3. Метод подсчета скидки
     */
    public double calculatingDiscount(double purchaseAmount, int discountAmount) {

        if (purchaseAmount < 0) throw new IllegalArgumentException("purchaseAmount < 0");
        if (discountAmount > 100) throw new IllegalArgumentException("discountAmount > 100");
        if (discountAmount < 0) throw new IllegalArgumentException("discountAmount < 0");
        return purchaseAmount - purchaseAmount * discountAmount / 100;
    }


    /**
     * 3.4. Метод принимает на вход 3 числа (int a, b, c). Нужно вернуть их сумму. Однако, если одно из значений равно 13,
     * то оно не учитывается в сумме. Так, например, если b равно 13, то считается сумма только a и c.
     */

    public int calculatingSumThreeNumbers(int one, int two, int three){
        int res = 0;
        if(one != 13) res += one;
        if(two != 13) res += two;
        if(three != 13) res += three;
        return res;
    }
}