package me.fengyj.huawei_od;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;

public class StringEncryptorTest {

    @Test
    public void test() {

        String input = "xy";
        String expect = "ya";

        Assert.assertEquals(expect, StringEncryptor.encrypt(input));

        input = "abcde";
        expect = "bdgkr";

        Assert.assertEquals(expect, StringEncryptor.encrypt(input));

        input = "abcdz";
        expect = "bdgkm";

        Assert.assertEquals(expect, StringEncryptor.encrypt(input));

        Integer[] arr = (Integer[]) Array.newInstance(Integer.class, 1);
        arr[0] = 100;

    }
}
