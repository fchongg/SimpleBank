package tests.java;

import com.bank.Luhn;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LuhnSpec {

    @Test
    public void zeroLuhn(){
        String zero = "0000";
        boolean actual = Luhn.Check(zero);
        assertEquals(true, actual);
    }

    @Test
    public void luhnNumberTrue(){
        String luhn_num = "4024007142780749528";
        boolean actual = Luhn.Check(luhn_num);
        assertEquals(true, actual);
    }

}
