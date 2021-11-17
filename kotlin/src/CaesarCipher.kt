package com.muyembe.jr.labs

open class CaesarCipher {
    protected var encrypt = CharArray(ALPHABET_SIZE)
    protected var decrypt = CharArray(ALPHABET_SIZE)
    fun encrypt(secret: String): String {
        val message = secret.toCharArray()
        for (i in message.indices) if (Character.isUpperCase(message[i])) message[i] = encrypt[message[i] - 'A']
        return String(message)
    }

    fun decrypt(secret: String): String {
        val message = secret.toCharArray()
        for (i in message.indices) {
            if (Character.isUpperCase(message[i])) message[i] = decrypt[message[i] - 'A']
        }
        return String(message)
    }

    companion object {
        const val ALPHABET_SIZE = 26
        var alphabet = charArrayOf(
                'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        )

        @JvmStatic
        fun main(args: Array<String>) {
            val cipher = CaesarCipher()
            println("Encryption order = " + String(cipher.encrypt))
            println("Decryption order = " + String(cipher.decrypt))
            var secret = "THE COPPER EAGLE IS IN PLAY; ZAMBIA KU CHALO"
            secret = cipher.encrypt(secret)
            println(secret)
            secret = cipher.decrypt(secret)
            println(secret)
        }
    }

    init {
        for (i in 0 until ALPHABET_SIZE) encrypt[i] = alphabet[(i + 3) % ALPHABET_SIZE]
        for (i in 0 until ALPHABET_SIZE) decrypt[encrypt[i] - 'A'] = alphabet[i]
    }
}