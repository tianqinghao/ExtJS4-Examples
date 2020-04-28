package com.sample.ext4.direct.config;

import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.softwarementors.extjs.djn.config.GlobalConfiguration;
import com.softwarementors.extjs.djn.gson.DefaultGsonBuilderConfigurator;

public class GsonBuilderConfiguratorCustom extends DefaultGsonBuilderConfigurator {
	@Override
	public void configure(GsonBuilder builder, GlobalConfiguration configuration) {
		super.configure(builder, configuration);
		addCustomSerializationSupport(builder);
	}

	/**
	 * �����Զ�������л��ͷ����л�������
	 * 
	 * @param builder
	 */
	private void addCustomSerializationSupport(GsonBuilder builder) {
		
		//ע��PageParam������л���������ʹ���ڲ���ķ�ʽʵ��JsonSerializer���л��ӿ�
		builder.registerTypeAdapter(PageParam.class, new JsonSerializer<PageParam>(){
			@Override
			public JsonElement serialize(PageParam src, Type typeOfSrc, JsonSerializationContext context) {
				
				JsonObject result = new JsonObject();
				result.addProperty("start", src.getStart());
				result.addProperty("limit", src.getLimit());
				
				return result;
			}
		});
		
		//ע��PageParam��ķ����л���������ʹ���ڲ���ķ�ʽʵ��JsonDeserializer���л��ӿ�
		builder.registerTypeAdapter(PageParam.class, new JsonDeserializer<PageParam>(){

			@Override
			public PageParam deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				
				JsonObject obj = json.getAsJsonObject();
				PageParam param = new PageParam();
				param.setStart(obj.get("start").getAsInt());
				param.setLimit(obj.get("limit").getAsInt());
				
				return param;
			}
			
		});
	}

}