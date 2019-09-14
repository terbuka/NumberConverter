/*
 * MainActivity.java
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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.EditText;
import android.support.design.widget.TextInputLayout;
import android.text.TextWatcher;
import android.text.Editable;
import android.text.InputType;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	/** Called when the activity is first created. */
	
	private EditText in_des;
	private EditText in_bin;
	private EditText in_oct;
	private EditText in_hex;
	
	private TextInputLayout til_des;
	private TextInputLayout til_bin;
	private TextInputLayout til_oct;
	private TextInputLayout til_hex;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout main_layout = new LinearLayout(this);
		in_des = new EditText(this);
		in_bin = new EditText(this);
		in_oct = new EditText(this);
		in_hex = new EditText(this);
		
		til_des = new TextInputLayout(this);
		til_bin = new TextInputLayout(this);
		til_oct = new TextInputLayout(this);
		til_hex = new TextInputLayout(this);
		
		LayoutParams fill_h = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		
		main_layout.setOrientation(LinearLayout.VERTICAL);
		main_layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		
		in_des.setLayoutParams(fill_h);
		in_bin.setLayoutParams(fill_h);
		in_oct.setLayoutParams(fill_h);
		in_hex.setLayoutParams(fill_h);
		
		til_des.setLayoutParams(fill_h);
		til_bin.setLayoutParams(fill_h);
		til_oct.setLayoutParams(fill_h);
		til_hex.setLayoutParams(fill_h);
		
		in_des.setHint("Decimal (10)");
		in_bin.setHint("Binary (2)");
		in_oct.setHint("Octal (8)");
		in_hex.setHint("Hex (16)");
		
		in_des.setInputType(InputType.TYPE_CLASS_NUMBER);
		in_bin.setInputType(InputType.TYPE_CLASS_NUMBER);
		in_oct.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		til_des.addView(in_des);
		til_bin.addView(in_bin);
		til_oct.addView(in_oct);
		til_hex.addView(in_hex);
		
		main_layout.addView(til_des);
		main_layout.addView(til_bin);
		main_layout.addView(til_oct);
		main_layout.addView(til_hex);
		
		setContentView(main_layout);
		
		des_listener();
		bin_listener();
		oct_listener();
		hex_listener();
	}
	
	private String tmp_des = "0";
	private String tmp_bin = "0";
	private String tmp_oct = "0";
	private String tmp_hex = "0";
	
	private void des_listener(){
		in_des.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence cstext, int start, int before, int count){
				String text = cstext.toString().trim();
				
				String text2 = text.replaceAll("[^0-9]", "");
				
				if(text.length() != text2.length()){
					in_des.setText(text2);
					in_des.setSelection(text2.length());
					text = text2;
				}
				
				if(tmp_des.equals(text)) return;
				
				tmp_des = text;
				
				if(text.length() == 0){
					in_bin.setText("");
					in_oct.setText("");
					in_hex.setText("");
					return;
				}
				
				if(!Bilangan.checkDes(text)) return;
				
				String bin = Bilangan.desToBin(text);
				String oct = Bilangan.desToOct(text);
				String hex = Bilangan.desToHex(text);

				in_bin.setText(bin);
				in_bin.setSelection(bin.length());
				in_oct.setText(oct);
				in_oct.setSelection(oct.length());
				in_hex.setText(hex.toUpperCase());
				in_hex.setSelection(hex.length());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after){}

			@Override
			public void afterTextChanged(Editable s){}
		});
	}
	
	private void bin_listener(){
		in_bin.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence cstext, int start, int before, int count){
				String text = cstext.toString().trim();
				
				String text2 = text.replaceAll("[^01]", "");
				
				if(text.length() != text2.length()){
					in_bin.setText(text2);
					in_bin.setSelection(text2.length());
					text = text2;
				}
				
				if(tmp_bin.equals(text)) return;
				
				tmp_bin = text;
				
				if(text.length() == 0){
					in_des.setText("");
					in_oct.setText("");
					in_hex.setText("");
					return;
				}
				
				if(!Bilangan.checkBin(text)) return;
				
				String des = Bilangan.binToDes(text);
				String oct = Bilangan.binToOct(text);
				String hex = Bilangan.binToHex(text);

				in_des.setText(des);
				in_des.setSelection(des.length());
				in_oct.setText(oct);
				in_oct.setSelection(oct.length());
				in_hex.setText(hex.toUpperCase());
				in_hex.setSelection(hex.length());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after){}

			@Override
			public void afterTextChanged(Editable s){}
		});
	}
	
	private void oct_listener(){
		in_oct.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence cstext, int start, int before, int count){
				String text = cstext.toString().trim();
				
				String text2 = text.replaceAll("[^0-8]", "");
				
				if(text.length() != text2.length()){
					in_oct.setText(text2);
					in_oct.setSelection(text2.length());
					text = text2;
				}
				
				if(tmp_oct.equals(text)) return;
				
				tmp_oct = text;
				
				if(text.length() == 0){
					in_des.setText("");
					in_bin.setText("");
					in_hex.setText("");
					return;
				}
				
				if(!Bilangan.checkOct(text)) return;
				
				String des = Bilangan.octToDes(text);
				String bin = Bilangan.octToBin(text);
				String hex = Bilangan.octToHex(text);

				in_des.setText(des);
				in_des.setSelection(des.length());
				in_bin.setText(bin);
				in_bin.setSelection(bin.length());
				in_hex.setText(hex.toUpperCase());
				in_hex.setSelection(hex.length());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after){}

			@Override
			public void afterTextChanged(Editable s){}
		});
	}
	
	private void hex_listener(){
		in_hex.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence cstext, int start, int before, int count){
				String text = cstext.toString().trim();
				
				String text2 = text.replaceAll("[^0-9a-fA-F]", "");
				
				if(text.length() != text2.length()){
					in_hex.setText(text2);
					in_hex.setSelection(text2.length());
					text = text2;
				}
				
				if(tmp_hex.equals(text)) return;
				
				tmp_hex = text;
				
				if(text.length() == 0){
					in_des.setText("");
					in_oct.setText("");
					in_bin.setText("");
					return;
				}
				
				if(!Bilangan.checkHex(text)) return;
				
				String des = Bilangan.hexToDes(text);
				String oct = Bilangan.hexToOct(text);
				String bin = Bilangan.hexToBin(text);

				in_des.setText(des);
				in_des.setSelection(des.length());
				in_oct.setText(oct);
				in_oct.setSelection(oct.length());
				in_bin.setText(bin);
				in_bin.setSelection(bin.length());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after){}

			@Override
			public void afterTextChanged(Editable s){}
		});
	}
}
