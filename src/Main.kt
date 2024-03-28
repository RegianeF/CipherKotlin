import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val key = "chaveDeExemplo12" // Substitua pela sua chave real
    val originalText = senha60


    val encryptedData = encrypt(originalText, key)
    println("Texto criptografado: ${encryptedData.contentToString()}")


    val decryptedText = decrypt(encryptedData, key)
    println("Texto descriptografado: $decryptedText")
}

fun encrypt(text: String, key: String): ByteArray {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key.toByteArray(), "AES"))
    return cipher.doFinal(text.toByteArray())
}


fun decrypt(encryptedData: ByteArray, key: String): String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key.toByteArray(), "AES"))
    return String(cipher.doFinal(encryptedData))
}

const val valor = "Esta é uma mensagem secreta. Grande com várias pontuações *-*, 788.+- 285881 12312dbjhasjbdjh178236187263 snd$%Y|º====3+§duahsdiu FIM"
const val senha1 = "5@Ri9uWXAXbTmNQ#5EEfC9"
const val senha60 = "jP8okBdm3!RxzhF@^9ED0h3IOE5@ZibXvxzn3^SvpS&EnZUXtR%zh0Ojcnh"