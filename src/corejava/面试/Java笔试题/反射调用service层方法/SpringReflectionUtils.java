package corejava.面试.Java笔试题.反射调用service层方法;



import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
	* Spring 反射工具类，增加Service方法统一调用功能
	*/
public class SpringReflectionUtils {
				
				// 保留原有的其他方法...（省略，保持不变）
				
				/**
					* 统一调用Service中的方法（支持有参和无参）
					*
					* @param serviceInstance Service实例对象
					* @param methodName 要调用的方法名
					* @param args 方法参数（无参时传null或空数组）
					* @return 方法返回值
					*/
				public static Object invokeServiceMethod(Object serviceInstance, String methodName, Object... args) {
								
								// 处理无参情况
								Object[] actualArgs = (args == null) ? new Object[0] : args;
								
								// 获取参数类型数组
								Class<?>[] parameterTypes = new Class<?>[actualArgs.length];
								for (int i = 0; i < actualArgs.length; i++) {
												parameterTypes[i] = actualArgs[i] != null ? actualArgs[i].getClass() : null;
								}
								
								// 查找方法（支持继承的方法）
								Method targetMethod = findServiceMethod(serviceInstance.getClass(), methodName, parameterTypes);
								Assert.notNull(targetMethod, String.format(
																"在Service[%s]中未找到方法: %s%s",
																serviceInstance.getClass().getName(),
																methodName,
																getMethodSignature(parameterTypes)
								));
								
								// 确保方法可访问（处理private/protected方法）
								ReflectionUtils.makeAccessible(targetMethod);
								
								// 调用方法并返回结果
								try {
												return ReflectionUtils.invokeMethod(targetMethod, serviceInstance, actualArgs);
								} catch (Exception e) {
												throw new RuntimeException(String.format(
																				"调用Service方法失败: %s%s",
																				methodName,
																				getMethodSignature(parameterTypes)
												), e);
								}
				}
				
				/**
					* 查找Service中的方法（包括父类和接口方法）
					*/
				private static Method findServiceMethod(Class<?> serviceClass, String methodName, Class<?>[] parameterTypes) {
								// 先尝试直接查找
								Method method = ReflectionUtils.findMethod(serviceClass, methodName, parameterTypes);
								if (method != null) {
												return method;
								}
								
								// 查找接口中的方法
								for (Class<?> ifc : serviceClass.getInterfaces()) {
												method = ReflectionUtils.findMethod(ifc, methodName, parameterTypes);
												if (method != null) {
																return method;
												}
								}
								
								// 查找父类中的方法
								Class<?> superClass = serviceClass.getSuperclass();
								if (superClass != null && superClass != Object.class) {
												return findServiceMethod(superClass, methodName, parameterTypes);
								}
								
								return null;
				}
				
				/**
					* 生成方法签名字符串（用于日志和错误提示）
					*/
				private static String getMethodSignature(Class<?>[] parameterTypes) {
								StringBuilder sb = new StringBuilder("(");
								for (int i = 0; i < parameterTypes.length; i++) {
												if (i > 0) {
																sb.append(", ");
												}
												sb.append(parameterTypes[i] != null ? parameterTypes[i].getSimpleName() : "null");
								}
								sb.append(")");
								return sb.toString();
				}
				
				// 原有的其他方法...（保持不变）
				// 包括：instantiate()、invokeMethod()、invokeStaticMethod()等
}
