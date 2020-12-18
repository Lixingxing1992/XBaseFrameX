package com.xx.base.project.util.file;


/**
 *  文件名称常量
 *  Created by lixingxing on 2019/6/11.
 */
public class ProFileConfig {
    public static void init(String APP_ROOT_DIRs, String SHAREPREFERENCESs){
        APP_ROOT_DIR = APP_ROOT_DIRs;
        SHAREPREFERENCES = SHAREPREFERENCESs;
    }
    /**
     * 默认 APP SharedPreferences文件夹路径
     */
    public static String SHAREPREFERENCES = "xbaseframex_default";
    /**
     * 默认APP文件目录
     **/
    public static String APP_ROOT_DIR = "xbaseframex";
    /**
     * 默认APP下载根目录.
     */
    public static String DOWNLOAD_ROOT_DIR = "download";
    /**
     * 默认下载图片文件地址.
     */
    public static String DOWNLOAD_IMAGE_DIR = "images";
    /**
     * 默认下载文件地址.
     */
    public static String DOWNLOAD_FILE_DIR = "files";
    /**
     * 默认放置临时文件目录
     */
    public static String FILE_TEMPORARY_DIR = "temporary";
    /**
     * APP缓存目录.
     */
    public static String CACHE_DIR = "cache";
    /**
     * DB目录.
     */
    public static String DB_DIR = "db";
}
