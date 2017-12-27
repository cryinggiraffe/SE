package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;



public class DAO <T> {
	
	//insert、delete、update
	public boolean update(String sql, Object ...args){
		
		boolean flag = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i = 0; i < args.length; i++){
				preparedStatement.setObject(i+1, args[i]);
			}
			
			preparedStatement.executeUpdate();
			
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			JDBCTools.release(null, preparedStatement, connection);
		}
		return flag;
	}
	
	//查询一条记录
		public T get(Class<T> clazz, String sql, Object ...args){
			T entity = null;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try{
				connection = JDBCTools.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				
				for(int i = 0; i < args.length; i++){
					preparedStatement.setObject(i+1, args[i]);
				}
				resultSet = preparedStatement.executeQuery();
				
				//一条记录
				if(resultSet.next()){
					//多个属性及属性值
					Map<String, Object> values = new HashMap<>();
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
					
					//使用元数据，获取每一列
					int columnCount = resultSetMetaData.getColumnCount();
					
					for(int i = 0; i < columnCount; i++){
						String columnLabel = resultSetMetaData.getColumnLabel(i+1);
						Object columnValue = resultSet.getObject(i+1);
						
						values.put(columnLabel, columnValue);
					}
					
					entity = clazz.newInstance();
					//遍历每一列，生成一个对象
					for(Map.Entry<String, Object> entry : values.entrySet()){
						String propertName = entry.getKey();
						Object value = entry.getValue();
						
						ReflectionUtils.setFieldValue(entity, propertName, value);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCTools.release(resultSet, preparedStatement, connection); 
			}
			
			return entity;
		}
		
		public List<T> getForList(Class<T> clazz, String sql, Object ...args){
			//最后的对象
			List<T> list = new ArrayList<>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try{
				connection = JDBCTools.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				
				for(int i = 0; i < args.length; i++){
					preparedStatement.setObject(i+1, args[i]);
				}
				
				resultSet = preparedStatement.executeQuery();
				//准备多个map，k-v一一对应
				List<Map<String, Object>> values = new ArrayList<>();
				
				ResultSetMetaData rsmd = resultSet.getMetaData();
				Map<String, Object> map = null;
				
				while(resultSet.next()){
					map = new HashMap<>();
					
					for(int i = 0; i < rsmd.getColumnCount(); i++){
						String columnLable = rsmd.getColumnLabel(i+1);
						Object columnValue = resultSet.getObject(i+1);
						
						map.put(columnLable, columnValue);
					}
					values.add(map);
				}
				
				T bean = null;
				
				if(values.size() > 0){
					for(Map<String,Object> m : values){
						bean = clazz.newInstance();
						for(Map.Entry<String, Object> entry : m.entrySet()){
							String propertName = entry.getKey();
							Object value = entry.getValue();
							
							BeanUtils.setProperty(bean, propertName, value);
						}
						list.add(bean);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCTools.release(resultSet, preparedStatement, connection);
			}
			
			return list;
		}
		
		
		public List<T> getALL(Class<T> clazz, String sql, Object ...args){
			//最后的对象
			List<T> list = new ArrayList<>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try{
				connection = JDBCTools.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				
				for(int i = 0; i < args.length; i++){
					preparedStatement.setObject(i+1, args[i]);
				}
				
				resultSet = preparedStatement.executeQuery();
				//准备多个map，k-v一一对应
				List<Map<String, Object>> values = new ArrayList<>();
				
				ResultSetMetaData rsmd = resultSet.getMetaData();
				Map<String, Object> map = null;
				
				while(resultSet.next()){
					map = new HashMap<>();
					
					for(int i = 0; i < rsmd.getColumnCount(); i++){
						String columnLable = rsmd.getColumnLabel(i+1);
						Object columnValue = resultSet.getObject(i+1);
						
						map.put(columnLable, columnValue);
					}
					values.add(map);
				}
				
				T bean = null;
				
				if(values.size() > 0){
					for(Map<String,Object> m : values){
						bean = clazz.newInstance();
						for(Map.Entry<String, Object> entry : m.entrySet()){
							String propertName = entry.getKey();
							Object value = entry.getValue();
							
							BeanUtils.setProperty(bean, propertName, value);
						}
						list.add(bean);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCTools.release(resultSet, preparedStatement, connection);
			}
			
			return list;
		}
}
