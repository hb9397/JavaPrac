package org.example.jBCryprt;

import org.mindrot.jbcrypt.BCrypt;

public class CryptMain {
    public static void main(String[] args) {
        // 복호화가 불가능한 암호화
        // 64자리나 128자리 정도
        String encryptString = BCrypt.hashpw("abcdefghijklmnop", BCrypt.gensalt());

        System.out.println(encryptString);

        // 비교
        // 비교할 때는 항상 평문이 먼저 와야되며 그렇지 않으면 예외가 발생한다.
        // System.out.println(BCrypt.checkpw(encryptString,"abcdefghijklmnop"));
        System.out.println(BCrypt.checkpw("abcdefghijklmnop",encryptString));
    }
}
