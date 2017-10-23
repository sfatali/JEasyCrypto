package easycrypto;

import easycrypto.EasyCryptoAPI.Result;

interface CryptoMethod {
	/**
    Encrypts the given plain text and stores it to the parameter to be used by the caller.
    @param toEncrypt Text to encrypt.
    @param toStoreTo A string to store the encrypted text to.
    @returns Returns success code of the encryption. See Result enum for details.
    */
   public Result encrypt(final String toEncrypt);
   
   public Result encrypt(final String toEncrypt, final String key);
   public boolean requiresKey();
   /**
    Decrypts the given encrypted text and stores it to the parameter to be used by the caller.
    @param toDecrypt Text to decrypt.
    @param toStoreTo A string to store the derypted plain text to.
    @returns Returns success code of the decryption. See Result enum for details.
    */
   public Result decrypt(final String toDecrypt);
   
   public Result decrypt(final String toDecrypt, final String key);

   
   /** To query the supported en/decryption methods of the library. Method returns the supported method names separated by comma.
    @returns The supported methods in the form "matrix,reverse".
    */
   public String method();
}
