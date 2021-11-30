/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Audd
 */
public class UtilityClass {
    public static boolean hasLetter(String a) {
		char c;
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			if (Character.isLetter(c)) {
				return true;
			}
		}
		return false;
	}

    public static boolean hasLetterUpper(String a) {
		char c;
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			if (Character.isLetter(c) && Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

    public static boolean hasDigit(String a) {
		char c;
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

    public static boolean hasSpecChar(String a) {
		char c;
		String specChar = "!@#$%&*()_+=|<>?{}\\\\[\\\\]~-";
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			String d = Character.toString(c);
			if (specChar.contains(d))
				return true;
		}
		return false;
	}
    
    public static void clearRowJTable(JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int row = model.getRowCount();
        for (int i = row - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    public static boolean validPassword(String pass){
        return pass.length() > 8 && hasDigit(pass) && hasLetter(pass) && hasLetterUpper(pass) && hasLetterUpper(pass);
    }
    
    public static boolean validEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
  
    public static boolean validDate(JComboBox d, JComboBox m, JComboBox y){
        String ngaySinh = y.getSelectedItem().toString() + "-" + m.getSelectedItem().toString() + "-" + d.getSelectedItem().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        try {
            Date dt = df.parse(ngaySinh);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public static String chuanHoa(String st) {
	st = st.trim().toLowerCase();
	st = st.replaceAll("\\s+", " ");
	String[] a = st.split(" ");	
	st = "";
	for(int i=0;i<a.length;i++) {
            st+=String.valueOf(a[i].charAt(0)).toUpperCase() + a[i].substring(1);
            if (i<a.length - 1)
                st+=" ";				
	}
        return st;
    }
    
    public static boolean validFullName(String fName){
        return !(hasDigit(fName) || hasSpecChar(fName) || fName.equals(""));
    }
    
    public static boolean validNumberPhone(String nPhone){
        return !((hasLetter(nPhone) || hasLetterUpper(nPhone) || hasSpecChar(nPhone)) || nPhone.length() < 8);
    }
}
