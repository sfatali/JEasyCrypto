package easycrypto;

import easycrypto.EasyCryptoAPI.Result;
import easycrypto.EasyCryptoAPI.ResultCode;

class ReverseMethod implements CryptoMethod {

	@Override
	public boolean requiresKey() {
		return false;
	}
	@Override
	public Result encrypt(final String toEncrypt) {
		String toStoreTo = new StringBuilder(toEncrypt).reverse().toString();
		return new Result(ResultCode.ESuccess, toStoreTo);
	}
	
	
	@Override
	public Result decrypt(final String toDecrypt) {
		// TODO Auto-generated method stub
		return encrypt(toDecrypt);
	}

	@Override
	public String method() {
		return "reverse";
	}

	//empty methods for interface
	
	@Override
	public Result encrypt(final String toEncrypt, final String key) {
		return new Result(ResultCode.EError, "Error: Wrong method accessed!");
	}
			
	@Override
	public Result decrypt(final String toDecrypt, final String key) {
		return new Result(ResultCode.EError, "Error: Wrong method accessed!");
	}

}
