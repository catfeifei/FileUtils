package afton.utils.file;

public class PathNameUtils {

    /**
     * 路径名字类工具：
     * Path是路径名
     */

    //当前路径的上一个路径名称
    public static String LastPath(String Path) {

        Path = Path.substring(0,Path.lastIndexOf("/"));

        return Path;
    }

    //当前路径的文件或文件夹名称
    public static String FileName(String Path) {

        Path = Path.substring(Path.lastIndexOf("/")+1);

        return Path;
    }

    //当前文件路径的文件名称后缀
    public static String FileSuffix(String Path) {

        Path = Path.substring(Path.lastIndexOf(".")+1);

        return Path;
    }

    //当前文件路径的文件名称前缀
    public static String FilePrefix(String Path) {

        String filename = FileName(Path);
        Path = filename.substring(0,filename.indexOf("."));

        return Path;
    }

}
