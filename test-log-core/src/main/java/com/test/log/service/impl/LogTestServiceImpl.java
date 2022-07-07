package com.test.log.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.log.service.LogTestService;

import test.log.annotation.LogAnnotation;
import test.log.entity.RpcCacheContext;

@DubboService(interfaceClass=LogTestService.class, version="${demo.service.version}")
public class LogTestServiceImpl implements LogTestService {
	private static final Logger logger = LoggerFactory.getLogger(LogTestServiceImpl.class);

	@Override
	public void testA() {
		logger.info("log 测试A");
	}

	@LogAnnotation(function="log测试B")
	public String testB(String info) throws RuntimeException{
		logger.info("log 测试B：{}", info);
		try {
			logger.info("上下文传递rpc缓存信息：{}", RpcCacheContext.getRpcInfo());
			logger.info("当前接口上下文缓存信息：{}", RpcCacheContext.getServiceInfo());
			logger.info("包括当前接口的上下文缓存信息：{}", RpcCacheContext.getAllServiceContext());
			return "succ";
		} catch (Exception e) {
			throw new RuntimeException("测试aop返回执行"); 
		}
	}

}
