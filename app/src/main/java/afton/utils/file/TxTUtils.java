package afton.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TxTUtils {
    /**
     * 保存内容到TXT文件中
     */
    public static boolean writeToXML(String filePath, String content) {
//        boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
//        if (hasSDCard) {
//            fileName = Environment.getExternalStorageDirectory().toString() + File.separator+"/test/" + fileName +".txt";
//        } else{
//            fileName = Environment.getDownloadCacheDirectory().toString() + File.separator +"/test/" +fileName + ".txt";
//        }
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        File file = new File(filePath);
        try {
            DeleteUtils.delete(filePath);
            CreatFileUtils.CreateFile(filePath);
            fileOutputStream = new FileOutputStream(file);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 读取内容
     *
     * @param filePath
     * @return
     */
    public static String readFromXML(String filePath) {

        //缓存地址
        String txtcache = "/storage/emulated/0/Filemanager/cache/txt/"+ PathNameUtils.FileName(filePath);

        //先复制源文件到缓存地址
        CopyPasteUtils.copyFile(filePath,txtcache);
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(txtcache);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return stringBuilder.toString();
    }

}