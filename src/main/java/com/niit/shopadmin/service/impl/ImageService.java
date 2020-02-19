package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.model.ResultBean;
import com.niit.shopadmin.util.ConsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-18 14:35
 **/
@Service
@PropertySource("classpath:common.properties")
public class ImageService {

    @Value("${image.upload.path}")
    String path;

    public static final String[] EXTNAMES = {".png",".jpg",".jpeg",".gif"};

    public ResultBean upload(MultipartFile file){

        String fileName = file.getOriginalFilename(); // 原始文件名: test01.png

        String extName = fileName.substring(fileName.lastIndexOf("."));
        String finalPath = path;
        boolean checkResult= false;
        for(String e : EXTNAMES){
            if(extName.equals(e)){
                checkResult =true;
                break;
            }
        }
        if(!checkResult){ //格式错误报错
            return new ResultBean(ConsUtil.RES_CODE_ERROR, ConsUtil.E_FORMAT_ERROR);
        }
        fileName = System.currentTimeMillis()+fileName;
        try {
            finalPath = finalPath+fileName;
            // 写入到服务器的地址
            file.transferTo(new File(finalPath));
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultBean(ConsUtil.RES_CODE_ERROR, ConsUtil.E_UPLOAD_ERROR);
        }

        ResultBean resultBean = new ResultBean();
        resultBean.setData(fileName);

        return resultBean;
    }
}
