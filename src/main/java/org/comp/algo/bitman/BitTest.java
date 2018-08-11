package org.comp.algo.bitman;

import org.junit.Test;

public class BitTest {

    @Test
    public void addTwoNumbers() {
        int x = 0b111;// 7
        int y = 0b1010;// 10
        System.out.println(x + y);
        add(x, y);
    }

    @Test
    public void multiply() {
        int x = 0b101;// 5
        int y = 0b1010;// 10

        int b = 0, i = 0, mply = 0;
        while (x != 0) {
            b = x & 1;
            if (b == 1) {
                mply = add(mply << i, y);
            }
            x >>>= 1;
            i++;
        }
        System.out.println(mply);
    }

    public int add(int x, int y) {
        int cin = 0, cout, xb, yb, sum = 0, temp, i = 0;

        while (x != 0 || y != 0) {
            xb = x & 1;
            yb = y & 1;
            cout = (xb & yb) | (xb & cin) | (yb & cin);
            temp = xb ^ yb ^ cin;
            sum = sum | temp << i;
            cin = cout;
            x >>>= 1;
            y >>>= 1;
            i++;
        }
        sum |= cin << i;
        System.out.println(sum);
        return sum;
    }

}

