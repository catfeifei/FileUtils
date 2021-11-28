package afton.utils.file;

import android.text.TextUtils;

import java.io.File;

public class RenameUtils {

    /**
     * 重命名文件：
     * oldPath 和 newPath必须是新旧文件的绝对路径
     */
    public static boolean renameFile(String oldPath, String newPath) {
        if (TextUtils.isEmpty(oldPath)) {
            return false;
        }

        if (TextUtils.isEmpty(newPath)) {
            return false;
        }
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);
        if (newFile.exists()) {
            return false;
        }
        //重命名
        return oldFile.renameTo(newFile);
    }


}
