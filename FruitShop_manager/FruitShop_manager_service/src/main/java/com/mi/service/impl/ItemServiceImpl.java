package com.mi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.mapper.TbItemMapper;
import com.mi.pojo.TbItem;
import com.mi.pojo.TbItemExample;
import com.mi.pojo.TbItemExample.Criteria;
import com.mi.service.ItemService;


/*
 * 商品管理
 */

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		//添加查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list !=null && list.size() > 0){
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

}
