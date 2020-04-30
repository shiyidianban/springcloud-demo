package com.springcloud.demo.client.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.mapper.ClientMapper;
import com.springcloud.demo.client.service.ClientService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author FLY
 * @since 2020-04-30
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

}
