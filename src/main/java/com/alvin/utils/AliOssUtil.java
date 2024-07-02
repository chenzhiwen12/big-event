package com.alvin.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;

import java.io.InputStream;

/**
 * packageName com.alvin.utils
 *
 * @author 你的名字
 * @version JDK 8
 * @className AliOssUtil (此处以class为例)
 * @date 2024/7/2 星期二
 * @description TODO
 */
public class AliOssUtil {
	private static final String ENDPOINT = "https://oss-cn-beijing.aliyuncs.com";
	public static final String ACCESS_KEY_ID = System.getenv("ALIYUN_ACCESSKEY_ID");
	private static final String SECRET_ACCESS_KEY = System.getenv("ALIYUN_ACCESSKEY_SECRET");
	private static final String BUCKET_NAME = "big-eventvin";

	public static String uploadFile(String objectName, InputStream inputStream) {
		OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, SECRET_ACCESS_KEY);
		String url = "";
		try {
			// 创建存储空间。
			ossClient.createBucket(BUCKET_NAME);
			ossClient.putObject(BUCKET_NAME, objectName, inputStream);
			url = "https://" + BUCKET_NAME + "." + ENDPOINT.substring(ENDPOINT.lastIndexOf("/") + 1) + "/" + objectName;
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message:" + oe.getErrorMessage());
			System.out.println("Error Code:" + oe.getErrorCode());
			System.out.println("Request ID:" + oe.getRequestId());
			System.out.println("Host ID:" + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message:" + ce.getMessage());
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
		return url;
	}
}
