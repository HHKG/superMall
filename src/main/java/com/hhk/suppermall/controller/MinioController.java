package com.hhk.suppermall.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.hhk.suppermall.config.CommonResult;
import com.hhk.suppermall.pojo.BucketPolicyConfig;
import com.hhk.suppermall.pojo.MinioUpload;
import io.minio.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Api(value = "MinioController")
@RequestMapping("/minio")
public class MinioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinioController.class);
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.port}")
    private Integer PORT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;
    @ApiOperation(value = "文件上传")
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public CommonResult upload(@RequestPart("file") MultipartFile file){
       try{
           // 创建一个MinIO的java客户端
           MinioClient minioClient = MinioClient.builder()
                   .endpoint(ENDPOINT,PORT,false)
                   .credentials(ACCESS_KEY,SECRET_KEY)
                   .build();
           boolean isExit = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
           if(isExit){
               LOGGER.info("存储桶已经存在");
           }else {
               // 创建存储桶并设置只读权限
               minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
               BucketPolicyConfig bucketPolicyConfig = createBucketPolicyConfig(BUCKET_NAME);
               SetBucketPolicyArgs bucketPolicyArgs = SetBucketPolicyArgs.builder()
                       .bucket(BUCKET_NAME)
                       .config(JSONUtil.toJsonStr(bucketPolicyConfig))
                       .build();
               minioClient.setBucketPolicy(bucketPolicyArgs);
           }
           String filename = file.getOriginalFilename();
           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
           // 设置存储对象名称
           String objectName = sdf.format(new Date())+"/"+filename;
           // 使用putObject上传一个文件到存储桶中
           PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                   .bucket(BUCKET_NAME)
                   .object(objectName)
                   .contentType(file.getContentType())
                   .stream(file.getInputStream(),file.getSize(),ObjectWriteArgs.MIN_MULTIPART_SIZE)
                   .build();
           minioClient.putObject(putObjectArgs);
           LOGGER.info("文件上传成功！");
           MinioUpload minioUpload = new MinioUpload();
           minioUpload.setName(filename);
           minioUpload.setUrl(ENDPOINT +":" + PORT + "/" + BUCKET_NAME + "/" + objectName);
           return CommonResult.success(minioUpload);
       }catch (Exception e){
           e.printStackTrace();
           LOGGER.info("上传发生错误：{}！",e.getMessage());
       }
        return CommonResult.failed();
    }

    /**
     * 创建存储桶的访问策略，设置为只读权限
     * @param bucketName
     * @return
     */
    private BucketPolicyConfig createBucketPolicyConfig(String bucketName){
        BucketPolicyConfig.Statement statement = BucketPolicyConfig.Statement.builder()
                .Effect("Allow")
                .Principal("*")
                .Action("s3.GetObject")
                .Resource("arn:aws:s3:::" + bucketName + "/*.**")
                .build();
        return BucketPolicyConfig.builder()
                .Version("2012-10-17")
                .Statement(CollUtil.toList(statement))
                .build();
    }

    @ApiOperation(value = "删除文件")
    @GetMapping("/deleteFile")
    public CommonResult deleteFile(@RequestParam(value = "objectName") String objectName){
        try{
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(ENDPOINT,PORT,false)
                    .credentials(ACCESS_KEY,SECRET_KEY)
                    .build();
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(BUCKET_NAME).object(objectName).build());
            return CommonResult.success(null);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.info("error message:{}",e.getMessage());
        }
        return CommonResult.failed();
    }
}
