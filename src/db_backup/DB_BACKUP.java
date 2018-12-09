/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_backup;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author malindad
 */
public class DB_BACKUP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Process p = null;
        int processComplete = 10;
        try {
            Format formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String s = formatter.format(new Date());
            s = "C:\\Users\\public\\dump_"+s+".sql";
            
            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump.exe -uroot -ppassword --add-drop-database -B institute_management -r" + s);
            //C:\\xampp\\mysql\\bin\\mysqldump.exe -uroot -pmypass --add-drop-database -B institute_management_test -r"+path
            processComplete = p.waitFor();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(processComplete);
    }

}
