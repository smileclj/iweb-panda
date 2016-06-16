package com.panda.iweb.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.panda.iweb.dto.AccessTokenResp;
import com.panda.iweb.dto.BaseTemplate;
import com.panda.iweb.dto.JsApiTicketResp;
import com.panda.iweb.dto.WxResult;
import com.panda.iweb.dto.WxTemplateMessageResp;
import com.panda.iweb.util.common.HttpTookit;
import com.panda.iweb.util.common.Sha1Util;
import com.panda.iweb.util.common.StringUtil;

public class WxUtil {
	protected static final Logger logger = LoggerFactory.getLogger(WxUtil.class);
	private static final String ACCESS_TOKEN_URL = "" + "/webchat/access_token/" + 500;
	private static final String JSAPI_TICKET_URL = "" + "/webchat/jsapi_ticket/" + 500;
	// wx
	private static final String TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";
	// private static final String WX_ACCESSTOKEN_KEY = "wx:accessToken";
	// private static final String WX_JSAPITICKET_KEY = "wx:jsapiTicket";
	private static final String KEY = "EA7E0F5D7A164B7DAA9229EB0DB1B7D6";

	// public static AccessToken getAccessToken() {
	// AccessToken token = (AccessToken)
	// AliyunOcsSampleHelp.getIMemcachedCache().get("wx_access_token");
	// if (token != null) {
	// return token;
	// }
	// SysConfigure conf = ApplicationListenerImpl.sysConfigureJson;
	// token = getAccessToken(conf.getWeixinAppId(), conf.getWeixinAppSecret());
	// if (token != null) {
	// AliyunOcsSampleHelp.getIMemcachedCache().set("wx_access_token",
	// token.getExpiresIn() - 10, token);
	// }
	// return token;
	// }

	// public static AccessToken getAccessToken(String appid, String appsecret)
	// {
	// AccessToken accessToken = null;
	//
	// String requestUrl =
	// "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
	// + appid + "&secret=" + appsecret;
	// JSONObject jsonObject = null;
	// try {
	// jsonObject = JSONObject.fromObject(httpProxy.get(requestUrl, null));
	// } catch (HttpException e1) {
	// e1.printStackTrace();
	// }
	// if (null != jsonObject) {
	// try {
	// accessToken = new AccessToken();
	// accessToken.setToken(jsonObject.getString("access_token"));
	// accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
	// accessToken.setCreateTime(System.currentTimeMillis());
	// } catch (JSONException e) {
	// accessToken = null;
	// log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
	// jsonObject.getString("errmsg"));
	// }
	// }
	// return accessToken;
	// }

	// 发送模版消息
	public static boolean send(BaseTemplate template) {
		String url = TEMPLATE_MESSAGE_URL + "?" + "access_token=" + getAccessToken();
		String responseBody = HttpTookit.postJson(url, JsonUtil.toJsonString(template));
		WxTemplateMessageResp resp = JsonUtil.parseObject(responseBody, WxTemplateMessageResp.class);
		return resp.getErrcode() == 0 ? true : false;
	}

	// 获取授权地址
	public static String auth(String to) throws UnsupportedEncodingException {
		StringBuilder redirect = new StringBuilder();
		redirect.append("").append("/webchat/auth/getUserToken/").append("");
		redirect.append("?to=").append(URLEncoder.encode(to, "UTF-8"));
		String redirect_uri = redirect.toString();
		redirect_uri = URLEncoder.encode(redirect_uri, "UTF-8");
		redirect.setLength(0);
		redirect.append("https://open.weixin.qq.com/connect/oauth2/authorize");
		redirect.append("?appid=" + "");
		redirect.append("&redirect_uri=" + redirect_uri);
		redirect.append("&response_type=code");
		redirect.append("&scope=snsapi_base");
		redirect.append("&state=STATE#wechat_redirect");
		logger.info("auth url:{}", redirect.toString());
		return redirect.toString();
	}

	// url处理
	public static String removeParams(String url, String[] params) {
		String reg = null;
		StringBuffer ps = new StringBuffer();
		ps.append("(");
		for (int i = 0; i < params.length; i++) {
			ps.append(params[i]).append("|");
		}
		ps.deleteCharAt(ps.length() - 1);
		ps.append(")");
		reg = "(?<=[\\?&])" + ps.toString() + "=[^&]*&?";
		url = url.replaceAll(reg, "");
		url = url.replaceAll("(\\?|&+)$", "");
		return url;
	}

	// 获取accessToken
	public static String getAccessToken() {
		// String accessToken = (String)
		// AliyunOcsSampleHelp.getIMemcachedCache().get(WX_ACCESSTOKEN_KEY);
		String accessToken = "";
		if (StringUtil.isEmpty(accessToken)) {
			return _getAccessToken();
		} else {
			return accessToken;
		}
	}

	// 获取jsapiTicket
	public static String getJsapiTicket() {
		// String ticket = (String)
		// AliyunOcsSampleHelp.getIMemcachedCache().get(WX_JSAPITICKET_KEY);
		String ticket = "";
		if (StringUtil.isEmpty(ticket)) {
			return _getJsapiTicket();
		} else {
			return ticket;
		}
	}

	private static String _getAccessToken() {
		long timeStart = System.currentTimeMillis();
		List<String> list = new ArrayList<String>();
		Map<String, Object> params = new HashMap<String, Object>();
		String timestamp = String.valueOf(new Date().getTime());
		params.put("timestamp", timestamp);
		list.add(timestamp);
		String nonce = String.valueOf((int) (Math.random() * 1000));
		params.put("nonce", nonce);
		list.add(nonce);
		String sign = _getSign(list);
		params.put("signature", sign);
		String responseBody = HttpTookit.get(ACCESS_TOKEN_URL, params);
		try {
			WxResult<AccessTokenResp> wxResult = JsonUtil.objectMapper.readValue(responseBody, new TypeReference<WxResult<AccessTokenResp>>() {
			});
			if (wxResult.getOk()) {
				// String token = wxResult.getDataView().getToken();
				// AliyunOcsSampleHelp.getIMemcachedCache().add(WX_ACCESSTOKEN_KEY,
				// wxResult.getExpiresIn(), token);
			}
		} catch (IOException e) {
			logger.error("解析字符串responseBody出错");
		}
		long timeEnd = System.currentTimeMillis();
		logger.info("获取accessToken耗时:{}ms", timeEnd - timeStart);
		return "";
	}

	private static String _getJsapiTicket() {
		long timeStart = System.currentTimeMillis();
		List<String> list = new ArrayList<String>();
		Map<String, Object> params = new HashMap<String, Object>();
		String timestamp = String.valueOf(new Date().getTime());
		params.put("timestamp", timestamp);
		list.add(timestamp);
		String nonce = String.valueOf((int) (Math.random() * 1000));
		params.put("nonce", nonce);
		list.add(nonce);
		String sign = _getSign(list);
		params.put("signature", sign);
		String responseBody = HttpTookit.get(JSAPI_TICKET_URL, params);
		try {
			WxResult<JsApiTicketResp> wxResult = JsonUtil.objectMapper.readValue(responseBody, new TypeReference<WxResult<JsApiTicketResp>>() {
			});
			if (wxResult.getOk()) {
				// String ticket = wxResult.getDataView().getTicket();
				// AliyunOcsSampleHelp.getIMemcachedCache().add(WX_JSAPITICKET_KEY,
				// wxResult.getExpiresIn(), ticket);
			}
		} catch (IOException e) {
			logger.error("解析字符串responseBody出错");
		}
		long timeEnd = System.currentTimeMillis();
		logger.info("获取jsapiTicket耗时:{}ms", timeEnd - timeStart);
		return "";
	}

	private static String _getSign(List<String> list) {
		list.add(KEY);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		return Sha1Util.getSha1(sb.toString());
	}

	public static void main(String[] args) throws IOException {
		// JSONObject json = new JSONObject();
		// json.put("touser", "ooGOKs9WLigobep_7nyOelxM5JtM");
		// json.put("template_id",
		// "X3i2Kn2qoEt-Oqtjj-j51rUV6Nxm5AiMvkbVCouu1DI");
		// json.put("url", "http://www.163.com");
		//
		// JSONObject data = new JSONObject();
		//
		// JSONObject resultItem = new JSONObject();
		// resultItem.put("value", "恭喜您，中奖啦！");
		// resultItem.put("color", "#173177");
		// data.put("result", resultItem);
		//
		// JSONObject totalWinMoney = new JSONObject();
		// totalWinMoney.put("value", "中奖320元");
		// totalWinMoney.put("color", "#173177");
		// data.put("totalWinMoney", totalWinMoney);
		//
		// json.put("data", data);
		// final String result = WxUtil.send(json.toString());
		// System.out.println("result=" + result);

		// System.out.println(getAccessToken());
		System.out.println(getJsapiTicket());
	}

}
