package com.example.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipUtil {
	        // 目录标识判断符
	        public static final String PATCH = "/";
	        // 基目录
	        public static final String BASE_DIR = "";
	        // 缓冲区大小
	        private static final int BUFFER = 2048;
	        // 字符集
	        public static final String CHAR_SET = "GBK";
	 
	 
	        /**
	         *
	         * 描述: 压缩文件
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param fileOutName
	         * @param files
	         * @throws Exception
	         */
	        public static void compress(String fileOutName, List<File> files) throws Exception {
	            try {
	                FileOutputStream fileOutputStream = new FileOutputStream(fileOutName);
	                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
	                //((Object) zipOutputStream).setEncoding(CHAR_SET);
	 
	                if (files != null && files.size() > 0) {
	                    for (int i = 0,size = files.size(); i < size; i++) {
	                        compress(files.get(i), zipOutputStream, BASE_DIR);
	                    }
	                }
	                // 冲刷输出流
	                zipOutputStream.flush();
	                // 关闭输出流
	                zipOutputStream.close();
	            } catch (Exception e) {
	                throw new Exception(e.getMessage(),e);
	            }
	        }
	 
	 
	        /**
	         *
	         * 描述:压缩文件并进行Base64加密
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param files
	         * @return
	         * @throws Exception
	         */
	        public static String compressToBase64(List<File> files) throws Exception {
	            try {
	                ByteArrayOutputStream bos = new ByteArrayOutputStream();
	                ZipOutputStream zipOutputStream = new ZipOutputStream(bos);
	               // zipOutputStream.setEncoding(CHAR_SET);
	 
	                if (files != null && files.size() > 0) {
	                    for (int i = 0,size = files.size(); i < size; i++) {
	                        compress(files.get(i), zipOutputStream, BASE_DIR);
	                    }
	                }
	                // 冲刷输出流
	                zipOutputStream.flush();
	                // 关闭输出流
	                zipOutputStream.close();
	 
	                byte[] data = bos.toByteArray();
	                return new String(Base64.encodeBase64(data));
	            } catch (Exception e) {
	                throw new Exception(e.getMessage(),e);
	            }
	        }
	 
	        /**
	         *
	         * 描述: 压缩
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param srcFile
	         * @param zipOutputStream
	         * @param basePath
	         * @throws Exception
	         */
	        public static void compress(File srcFile, ZipOutputStream zipOutputStream, String basePath) throws Exception {
	            if (srcFile.isDirectory()) {
	                compressDir(srcFile, zipOutputStream, basePath);
	            } else {
	                compressFile(srcFile, zipOutputStream, basePath);
	            }
	        }
	 
	        /**
	         *
	         * 描述:压缩目录下的所有文件
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param dir
	         * @param zipOutputStream
	         * @param basePath
	         * @throws Exception
	         */
	        private static void compressDir(File dir, ZipOutputStream zipOutputStream, String basePath) throws Exception {
	            try {
	                // 获取文件列表
	                File[] files = dir.listFiles();
	 
	                if (files.length < 1) {
	                    ZipEntry zipEntry = new ZipEntry(basePath + dir.getName() + PATCH);
	 
	                    zipOutputStream.putNextEntry(zipEntry);
	                    zipOutputStream.closeEntry();
	                }
	 
	                for (int i = 0,size = files.length; i < size; i++) {
	                    compress(files[i], zipOutputStream, basePath + dir.getName() + PATCH);
	                }
	            } catch (Exception e) {
	                throw new Exception(e.getMessage(), e);
	            }
	        }
	 
	        /**
	         *
	         * 描述:压缩文件
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param file
	         * @param zipOutputStream
	         * @param dir
	         * @throws Exception
	         */
	        private static void compressFile(File file, ZipOutputStream zipOutputStream, String dir) throws Exception {
	            try {
	                // 压缩文件
	                ZipEntry zipEntry = new ZipEntry(dir + file.getName());
	                zipOutputStream.putNextEntry(zipEntry);
	 
	                // 读取文件
	                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	 
	                int count = 0;
	                byte data[] = new byte[BUFFER];
	                while ((count = bis.read(data, 0, BUFFER)) != -1) {
	                    zipOutputStream.write(data, 0, count);
	                }
	                bis.close();
	                zipOutputStream.closeEntry();
	            } catch (Exception e) {
	                throw new Exception(e.getMessage(),e);
	            }
	        }
	 
	        /**
	         *
	         * 描述: 文件Base64加密
	         * @author wanghui
	         * @created 2017年10月27日 上午9:27:38
	         * @param srcFile
	         * @return
	         * @throws Exception
	         */
	        public static String encodeToBASE64(File srcFile) throws Exception {
	            try {
	                ByteArrayOutputStream bos = new ByteArrayOutputStream();
	                // 读取文件
	                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
	 
	                int count = 0;
	                byte data[] = new byte[BUFFER];
	                while ((count = bis.read(data, 0, BUFFER)) != -1) {
	                    bos.write(data, 0, count);
	                }
	                bis.close();
	 
	                byte[] base64Data = Base64.encodeBase64(bos.toByteArray());
	                if (null == base64Data) {
	                    bos.close();
	                    return null;
	                }
	 
	                bos.close();
	                return new String(base64Data, CHAR_SET);
	            } catch (Exception e) {
	                throw new Exception(e.getMessage(),e);
	            }
	        }
	 
	        /**
	         *
	         * 描述: 文件Base64解密
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param destFile
	         * @param encodeStr
	         * @throws Exception
	         */
	        public static void decodeToBase64(File destFile, String encodeStr) throws Exception {
	            try {
	                byte[] decodeBytes = Base64.decodeBase64(encodeStr.getBytes());
	 
	                ByteArrayInputStream bis = new ByteArrayInputStream(decodeBytes);
	                // 读取文件
	                FileOutputStream fileOutputStream = new FileOutputStream(destFile);
	 
	                int count = 0;
	                byte data[] = new byte[BUFFER];
	                while ((count = bis.read(data, 0, BUFFER)) != -1) {
	                    fileOutputStream.write(data, 0, count);
	                }
	                fileOutputStream.close();
	                bis.close();
	            } catch (Exception e) {
	                throw new Exception(e.getMessage(),e);
	            }
	        }
	 
	        /**
	         *
	         * 描述: 解压缩
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param srcFileName
	         * @param destFileName
	         * @throws Exception
	         */
	        @SuppressWarnings("unchecked")
	        public static void decompress(String srcFileName, String destFileName)  throws Exception {
//	            try {
//	                ZipFile zipFile = new ZipFile(srcFileName);
//	                Enumeration<ZipEntry> entries = zipFile.get;
//	                File destFile = new File(destFileName);
//	                InputStream inputStream = null;
//	 
//	                while(entries.hasMoreElements()) {
//	                    ZipEntry zipEntry = (ZipEntry)entries.nextElement();
//	                    String dir = destFile.getPath() + File.separator + zipEntry.getName();
//	                    File dirFile = new File(dir);
//	 
//	                    if (zipEntry.isDirectory()) {
//	                        dirFile.mkdirs();
//	                    } else {
//	                        fileProber(dirFile);
//	                        inputStream = zipFile.getInputStream(zipEntry);
//	                        decompressFile(dirFile, inputStream);
//	                    }
//	                }
//	                zipFile.close();
//	            } catch (Exception e) {
//	                throw new Exception(e.getMessage(),e);
//	            }
	        }
	 
	        /**
	         *
	         * 描述: 解压文件
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param destFile
	         * @param inputStream
	         * @throws Exception
	         */
	        private static void decompressFile(File destFile, InputStream inputStream) throws Exception {
	            try {
	                // 文件输入流
	                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
	 
	                int count = 0;
	                byte data[] = new byte[BUFFER];
	                while ((count = inputStream.read(data, 0, BUFFER)) != -1) {
	                    bos.write(data, 0, count);
	                }
	                bos.close();
	                inputStream.close();
	            } catch (Exception e) {
	                throw new Exception(e.getMessage(), e);
	            }
	        }
	 
	        /**
	         *
	         * 描述:文件探测
	         * @author wanghui
	         * @created 2017年10月27日
	         * @param dirFile
	         */
	        private static void fileProber(File dirFile) {
	            File parentFile = dirFile.getParentFile();
	            if (!parentFile.exists()) {
	                // 递归寻找上级目录  
	                fileProber(parentFile);
	                parentFile.mkdir();
	            }
	        }
	    /**
	     * 递归删除目录下的所有文件及子目录下所有文件
	     * @param dir 将要删除的文件目录
	     * @return boolean Returns "true" if all deletions were successful.
	     *                 If a deletion fails, the method stops attempting to
	     *                 delete and returns "false".
	     */
	    public static boolean deleteDir(File dir) {
	        if (dir.isDirectory()) {
	            String[] children = dir.list();
	           //递归删除目录中的子目录下
	            for (int i=0; i<children.length; i++) {
	                boolean success = deleteDir(new File(dir, children[i]));
	                if (!success) {
	                    return false;
	                }
	            }
	        }
	        // 目录此时为空，可以删除
	        return dir.delete();
	    }
}