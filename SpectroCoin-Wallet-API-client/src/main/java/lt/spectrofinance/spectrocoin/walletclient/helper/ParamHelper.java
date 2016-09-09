package lt.spectrofinance.spectrocoin.walletclient.helper;

import javax.ws.rs.QueryParam;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
public class ParamHelper {

	public static HashMap<String, String> get(Object obj){
		HashMap<String, String> values = new HashMap<>();

		String name = obj.getClass().getName();
		Class<?> currentClass = obj.getClass();
		while (name.compareTo(Object.class.getName()) != 0){
			Field[] declaredFields = currentClass.getDeclaredFields();
			fillValuesMap(obj, values, declaredFields);

			currentClass = currentClass.getSuperclass();
			name = currentClass.getName();
		}
		return values;
	}

	private static void fillValuesMap(Object o, HashMap<String, String> values, Field[] declaredFields) {
		for (Field declaredField : declaredFields) {
			if (declaredField.isAnnotationPresent(QueryParam.class)){
				try {
					QueryParam annotation = declaredField.getAnnotation(QueryParam.class);
					String annotationValue = annotation.value();

					declaredField.setAccessible(true);
					Object value = declaredField.get(o);
					if(value != null){
						values.put(annotationValue, value.toString());
					}

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}