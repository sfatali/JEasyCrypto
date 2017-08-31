package EasyCryptoLib;

import java.text.BreakIterator;
import java.util.Locale;

import EasyCryptoLib.EasyCryptoLib.Result;
import EasyCryptoLib.EasyCryptoLib.ResultCode;

public class CyrMethod implements CryptoMethod {
	
	@Override
	public Result encrypt(String toEncrypt) {
		String result = new String();

        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.ENGLISH);
        breakIterator.setText(toEncrypt);

        String tmp;
        int start = breakIterator.first();
        for (int end = breakIterator.next(); end != BreakIterator.DONE; start = end, end = breakIterator.next()) {
        		tmp = toEncrypt.substring(start, end);
        		int valueOfChar = tmp.codePointAt(0); 
        		int newValue = 0x0400 + (valueOfChar-0x20);
        		result += String.copyValueOf(Character.toChars(newValue));
        }
		return new Result(ResultCode.ESuccess, result);
	}

	@Override
	public Result decrypt(String toDecrypt) {
		String result = new String();

        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.ENGLISH);
        breakIterator.setText(toDecrypt);

        String tmp;
        int start = breakIterator.first();
        for (int end = breakIterator.next(); end != BreakIterator.DONE; start = end, end = breakIterator.next()) {
        		tmp = toDecrypt.substring(start, end);
        		int valueOfChar = tmp.codePointAt(0); 
        		int newValue = 0x20 + (valueOfChar-0x0400);
        		result += String.copyValueOf(Character.toChars(newValue));
        }
		return new Result(ResultCode.ESuccess, result);
	}

	@Override
	public String method() {
		return "cyr";
	}

}
