package org.comp.algo.hashing;

import org.junit.Test;

public class KeysInBytes {

    @Test
    public void keyToBytes(){
        int id= 1_000_000;
        //11101110011010
        // 11001010
        // 00000000
        System.out.println(Integer.toBinaryString(id));
        byte[] key =  new byte[3];

        for (int i=0; i<key.length; i++){
            System.out.println(Integer.toBinaryString((id >>> (i*8)) & 0xFF));
            key[i] = (byte) ((id >>> (i*8)) & 0xFF);
        }
        System.out.println(key);
        //0 - 1000000
        //1 - 1000010
        //2 - 1111

        System.out.println("-------------");

        int back=0, size=key.length-1;
        for (int i=size; i>=0; i--){
            back =key[i] | ( back <<  8 );
            System.out.println("back"+Integer.toBinaryString(back));
        }
        //1111
        //1111
        //01000010
        System.out.println(back);


    }
}
