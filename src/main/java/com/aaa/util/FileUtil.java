package com.aaa.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * className:FileUtil
 * discription:
 * author:zz
 * createTime:2018-11-23 08:35
 */
public class FileUtil {
    /**
     * 通用上传方法
     * @param savePath
     * @param multipartFile
     * @return
     */
    public static String uploadFile(String savePath, MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        //获取源文件后缀
        String suffix=originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼装新文件名称
        String newFileName= UUID.randomUUID()+suffix;//UUID.randomUUID()随机字符串
        File file=new File(savePath+ newFileName);//    D:/images/jin.jpg

        try {
            //调用spring提供的方法进行文件读写
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }
    /**
     * 通用下载方法
     * @param filename
     * @param response
     * @return
     */
    public static String downLoad(String filename,HttpServletResponse response){
        String filePath = "D:/images" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");//MIME类型
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
           /* int i = bis.read(buffer);
            while(i != -1){
                os.write(buffer);
                i = bis.read(buffer);
            }*/
                int i=0;
                while((i = bis.read(buffer))!=-1){
                    os.write(buffer,0,i);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

}
