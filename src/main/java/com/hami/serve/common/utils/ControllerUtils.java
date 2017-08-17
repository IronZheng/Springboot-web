package com.hami.serve.common.utils;

import org.slf4j.Logger;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ControllerUtils {
	public static final String RESPONSE_CODE_SUCCESS = "SUCCESS";
	public static final String RESPONSE_CODE_FAILED = "FAILED";

	public static void output(PrintWriter printWriter, Object obj, Logger logger, boolean byExpose) {
		try {
			if (byExpose) {
				output(printWriter, JsonUtils.toJsonByExpose(obj), logger);
			} else {
				output(printWriter, JsonUtils.toJson(obj), logger);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static void output(PrintWriter printWriter, String result, Logger logger) {
		try {
			printWriter.write(result);
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static Map<String, Object> createReturnObject(String returnCode, String returnMessage) {
		return createReturnObject(returnCode, returnMessage, null);
	}

	public static Map<String, Object> createReturnObject(String returnCode, String returnMessage, Object returnParam) {
		Map<String, Object> result = new HashMap();
		result.put("CODE", returnCode);
		result.put("MESSAGE", returnMessage);
		if (returnParam != null) {
			result.put("RETURN_PARAM", returnParam);
		}
		return result;
	}
}