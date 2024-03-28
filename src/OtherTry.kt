import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

fun decrypt9(algorithm: String, cipherText: String, key: SecretKeySpec, iv: IvParameterSpec): String {
    val cipher = Cipher.getInstance(algorithm)
    cipher.init(Cipher.DECRYPT_MODE, key, iv)
    val plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText))
    return String(plainText)
}

fun encrypt9(algorithm: String, inputText: String, key: SecretKeySpec, iv: IvParameterSpec): String {
    val cipher = Cipher.getInstance(algorithm)
    cipher.init(Cipher.ENCRYPT_MODE, key, iv)
    val cipherText = cipher.doFinal(inputText.toByteArray())
    return Base64.getEncoder().encodeToString(cipherText)
}

val algorithm = "AES/CBC/PKCS5Padding"
val key = SecretKeySpec("1234567890123456".toByteArray(), "AES")
val iv = IvParameterSpec(ByteArray(16))


val inputText = "abcdefghigklmnopqrstuvwxyz0123456789"

val cipherText = encrypt9(algorithm, inputText, key, iv)
val plainText = decrypt9(algorithm, cipherText, key, iv)

fun main() {
    println("é isso: $cipherText")
    println("plain text: $plainText")
}