package com.muyembe.jr.labs;

public class CaesarCipher {
    public static final int ALPHABET_SIZE = 26;
    public static char[] alphabet = {
            'A', 'B','C','D','E',
            'F','G', 'H','I','J',
            'K','L','M','N', 'O',
            'P','Q','R', 'S','T',
            'U','V','W','X','Y','Z'
    };
    protected char[] encrypt = new char[ALPHABET_SIZE];
    protected char[] decrypt = new char[ALPHABET_SIZE];

    public CaesarCipher() {
        for(int i = 0; i < ALPHABET_SIZE; i++)
            encrypt[i] = alphabet[(i + 3) % ALPHABET_SIZE];
        for(int i=0; i < ALPHABET_SIZE; i++)
            decrypt[encrypt[i] - 'A'] = alphabet[i];
    }

    public String encrypt(String secret){
        char[] message = secret.toCharArray();
        for(int i = 0; i < message.length; i++)
            if(Character.isUpperCase(message[i]))
                message[i] = encrypt[message[i] - 'A'];
            return new String(message);
    }

    public String decrypt(String secret){
        char[] message = secret.toCharArray();
        for(int i = 0; i < message.length; i++){
            if(Character.isUpperCase(message[i]))
                message[i] = decrypt[message[i] - 'A'];
        }
        return new String(message);
    }

    public static void main(String[] args) {
	    CaesarCipher cipher = new CaesarCipher();
	    System.out.println("Encryption order = " + new String(cipher.encrypt));
	    System.out.println("Decryption order = " + new String(cipher.decrypt));
	    String secret = "THE COPPER EAGLE IS IN PLAY; ZAMBIA KU CHALO";
	    secret = cipher.encrypt(secret);
	    System.out.println(secret);
	    secret = cipher.decrypt(secret);
	    System.out.println(secret);
    }
}
