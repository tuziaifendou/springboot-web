package com.kimzing.web.feign;

import com.kimzing.web.domain.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 远程接口服务.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/24 17:13
 */
@Service
public class UserFeign {

    @Resource
    RestTemplate restTemplate;

    public List<UserDTO> userInfo(Integer pageNum, Integer pageSize) {
        HashMap<String, Integer> params = new HashMap<>();
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        List<UserDTO> userList = restTemplate.getForObject("http://localhost:8080/user/list", List.class, params);
        return userList;
    }

}
