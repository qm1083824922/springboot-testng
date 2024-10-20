package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.mapper.PackingFinishedMapper;
import com.sailheader.testng.service.PackingFinishedService;
import org.springframework.stereotype.Service;

/**
 * 成品包装 服务实现类
 * @author Porsche
 * @since 2024/10/19 23:42
 */
@Service
public class PackingFinishedServiceImpl extends ServiceImpl<PackingFinishedMapper, PackingFinished> implements PackingFinishedService {
}
