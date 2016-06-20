package com.panda.iweb.util.lbs.gaode;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.panda.iweb.util.JsonUtil;
import com.panda.iweb.util.common.HttpUtil;
import com.panda.iweb.util.common.ReflectUtil;
import com.panda.iweb.util.common.StringUtil;
import com.panda.iweb.util.lbs.gaode.req.DataCreateReq;
import com.panda.iweb.util.lbs.gaode.req.DataUpdateReq;
import com.panda.iweb.util.lbs.gaode.req.SearchAroundReq;
import com.panda.iweb.util.lbs.gaode.req.SearchLocalReq;
import com.panda.iweb.util.lbs.gaode.resp.DataCreateResp;
import com.panda.iweb.util.lbs.gaode.resp.DataDeleteResp;
import com.panda.iweb.util.lbs.gaode.resp.DataSearchResp;
import com.panda.iweb.util.lbs.gaode.resp.TableCreateResp;

public class LbsUtil {
	public static final String KEY = "46367691bcfd10674ebdfb0c021c8cdd";
	public static final String TABLE_ID = "5757f442305a2a3f8e9afe89"; // 5514cabfe4b0f88620720eca

	// --------------存储api----------------//
	/**
	 * 建表
	 * 
	 * @author chenlj
	 * @throws Exception
	 * @Date 2016 下午5:45:23
	 */
	public static TableCreateResp createTable(String tableName) throws Exception {
		if (StringUtil.isEmpty(tableName)) {
			throw new IllegalArgumentException("tableName is not empty");
		}
		String url = "http://yuntuapi.amap.com/datamanage/table/create";
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", KEY);
		params.put("name", tableName);
		String resp = HttpUtil.post(url, params);
		return JsonUtil.parseObject(resp, TableCreateResp.class);
	}

	/**
	 * 创建一条记录
	 * 
	 * @author chenlj
	 * @throws Exception
	 * @Date 2016 上午11:32:43
	 */
	public static DataCreateResp createData(DataCreateReq data) throws Exception {
		String url = "http://yuntuapi.amap.com/datamanage/data/create";
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", KEY);
		params.put("tableid", TABLE_ID);
		params.put("data", JsonUtil.toJsonString(data));
		String resp = HttpUtil.post(url, params);
		return JsonUtil.parseObject(resp, DataCreateResp.class);
	}

	/**
	 * 更新一条记录(更新字段值：只更新请求中上传的字段值，未上传的字段保留原值，且系统字段中_id,_createtime,
	 * _updatetime三个字段不能被更新。) 本可以在json序列化的时候做处理,目前采用反射的方式
	 * 
	 * @author chenlj
	 * @Date 2016 上午11:35:22
	 */
	public static DataCreateResp updateData(DataUpdateReq data) throws Exception {
		if (StringUtil.isEmpty(data.get_id())) {
			throw new IllegalArgumentException("_id is not empty");
		}
		String url = "http://yuntuapi.amap.com/datamanage/data/update";
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", KEY);
		params.put("tableid", TABLE_ID);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Field> fields = ReflectUtil.getFields(data);
		for (Field field : fields) {
			field.setAccessible(true);
			String key = field.getName();
			Object value = field.get(data);
			if (value != null) {
				dataMap.put(key, value);
			}
		}
		params.put("data", JsonUtil.toJsonString(dataMap));

		String resp = HttpUtil.post(url, params);
		return JsonUtil.parseObject(resp, DataCreateResp.class);
	}

	/**
	 * 删除数据 ids用逗号隔开
	 * 
	 * @author chenlj
	 * @throws Exception
	 * @Date 2016 上午11:35:32
	 */
	public static DataDeleteResp deleteData(String ids) throws Exception {
		String url = "http://yuntuapi.amap.com/datamanage/data/delete";
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", KEY);
		params.put("tableid", TABLE_ID);
		params.put("ids", ids);

		String resp = HttpUtil.post(url, params);
		return JsonUtil.parseObject(resp, DataDeleteResp.class);
	}

	// ------------云检索api------------------//
	/**
	 * 根据id检索
	 * 
	 * @author chenlj
	 * @throws Exception
	 * @Date 2016 下午12:11:55
	 */
	public static DataSearchResp searchById(String id) throws Exception {
		if (StringUtil.isEmpty(id)) {
			throw new IllegalArgumentException("id is not empty");
		}
		String url = "http://yuntuapi.amap.com/datasearch/id";
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", KEY);
		params.put("tableid", TABLE_ID);
		params.put("_id", id);
		String resp = HttpUtil.post(url, params);
		return JsonUtil.parseObject(resp, DataSearchResp.class);
	}

	/**
	 * 本地检索
	 * 
	 * @author chenlj
	 * @throws Exception
	 * @Date 2016 下午12:11:55
	 */
	public static DataSearchResp searchByLocal(SearchLocalReq req) throws Exception {
		String url = "http://yuntuapi.amap.com/datasearch/local";
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", KEY);
		params.put("tableid", TABLE_ID);

		if (req.getKeywords() == null) {
			req.setKeywords("");
		}
		List<Field> fields = ReflectUtil.getFields(req);
		for (Field field : fields) {
			field.setAccessible(true);
			String key = field.getName();
			Object value = field.get(req);
			if (value != null) {
				params.put(key, value.toString());
			}
		}

		String resp = HttpUtil.post(url, params);
		return JsonUtil.parseObject(resp, DataSearchResp.class);
	}

	/**
	 * 周边检索
	 * 
	 * @author chenlj
	 * @throws Exception
	 * @Date 2016 下午12:11:55
	 */
	public static DataSearchResp searchByAround(SearchAroundReq req) throws Exception {
		String url = "http://yuntuapi.amap.com/datasearch/around";
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", KEY);
		params.put("tableid", TABLE_ID);

		List<Field> fields = ReflectUtil.getFields(req);
		for (Field field : fields) {
			field.setAccessible(true);
			String key = field.getName();
			Object value = field.get(req);
			if (value != null) {
				params.put(key, value.toString());
			}
		}

		String resp = HttpUtil.post(url, params);
		return JsonUtil.parseObject(resp, DataSearchResp.class);
	}
}
