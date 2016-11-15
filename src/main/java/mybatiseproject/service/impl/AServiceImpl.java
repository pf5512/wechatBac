package mybatiseproject.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mybatiseproject.dao.ADao;
import mybatiseproject.service.AService;

@Service
public class AServiceImpl implements AService {
	@Resource
	ADao adao;

	@Override
	public String queryNameService() {
		// TODO Auto-generated method stub
		return adao.queryName();
	}

}
