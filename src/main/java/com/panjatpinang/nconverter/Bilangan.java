/*
 * Bilangan.java
 * This file is part of Number Converter
 *
 * Copyright (C) 2019 - Hamba Allah <kunyuk@disroot.org>
 *
 * Number Converter is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Number Converter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Number Converter. If not, see <http://www.gnu.org/licenses/>.
 */

package com.panjatpinang.nconverter;

public class Bilangan {
	public static String desToBin(String in){
		long des = Long.valueOf(in);
		return Long.toBinaryString(des);
	}

	public static String desToOct(String in){
		long des = Long.valueOf(in);
		return Long.toOctalString(des);
	}

	public static String desToHex(String in){
		long des = Long.valueOf(in);
		return Long.toHexString(des);
	}
	
	public static String binToDes(String in){
		long des = Long.valueOf(in, 2);
		return String.valueOf(des);
	}
	
	public static String octToDes(String in){
		long des = Long.valueOf(in, 8);
		return String.valueOf(des);
	}
	
	public static String hexToDes(String in){
		long des = Long.valueOf(in, 16);
		return String.valueOf(des);
	}
	
	public static String binToOct(String in){
		return Bilangan.desToOct(Bilangan.binToDes(in));
	}
	
	public static String binToHex(String in){
		return Bilangan.desToHex(Bilangan.binToDes(in));
	}
	
	public static String octToBin(String in){
		return Bilangan.desToBin(Bilangan.octToDes(in));
	}
	
	public static String octToHex(String in){
		return Bilangan.desToHex(Bilangan.octToDes(in));
	}
	
	public static String hexToBin(String in){
		return Bilangan.desToBin(Bilangan.hexToDes(in));
	}
	
	public static String hexToOct(String in){
		return Bilangan.desToOct(Bilangan.hexToDes(in));
	}
	
	public static boolean checkDes(String in){
		try {
			Long.valueOf(in);
			return true;
		}
		catch(Error e){
			return false;
		}
	}
	
	public static boolean checkBin(String in){
		try {
			Long.valueOf(in, 2);
			return true;
		}
		catch(Error e){
			return false;
		}
	}
	
	public static boolean checkOct(String in){
		try {
			Long.valueOf(in, 8);
			return true;
		}
		catch(Error e){
			return false;
		}
	}
	
	public static boolean checkHex(String in){
		try {
			Long.valueOf(in, 16);
			return true;
		}
		catch(Error e){
			return false;
		}
	}
}
