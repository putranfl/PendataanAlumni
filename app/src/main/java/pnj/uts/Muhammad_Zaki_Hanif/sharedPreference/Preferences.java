package pnj.uts.Muhammad_Zaki_Hanif.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    static final String KEY_EMAIL = "email",KEY_NAMA = "nama",KEY_KELAS = "kelas",KEY_NIM = "nim";

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setDataUser(Context context, String email,String nama, String kelas, int nim){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_NAMA, nama);
        editor.putString(KEY_KELAS, kelas);
        editor.putInt(KEY_NIM, nim);
        editor.apply();
    }

    public static String getEmailUser(Context context){
        return getSharedPreference(context).getString(KEY_EMAIL,"");
    }

    public static int getNimUser(Context context){
        return getSharedPreference(context).getInt(KEY_NIM,0);
    }
    public static String getNamaUser(Context context){
        return getSharedPreference(context).getString(KEY_NAMA,"");
    }
    public static String getKelasUser(Context context){
        return getSharedPreference(context).getString(KEY_KELAS,"");
    }

    public static void clearDataUser(Context context){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(KEY_KELAS);
        editor.remove(KEY_NAMA);
        editor.remove(KEY_NIM);
        editor.remove(KEY_EMAIL);
        editor.apply();
    }
}
