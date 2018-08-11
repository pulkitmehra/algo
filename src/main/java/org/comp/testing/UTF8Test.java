package org.comp.testing;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.junit.Test;

public class UTF8Test {

    @Test
    public void utf8Testing() throws UnsupportedEncodingException {
        String s = "Il semble y avoir un problÃ¨me. Nous y travaillons, alors veuillez rÃ©essayer plus tard.";
        System.out.println(new String(s.getBytes("UTF-8")));

        byte[] encode = Charset.forName("UTF-8").encode(s).array();
        System.out.println(new String(encode));
        
        byte[] ptext = s.getBytes("ISO_8859_1"); 
        String value = new String(ptext, "UTF_8");
        System.out.println(value);
    }
}

